package tv.mangrana.utils;

import tv.mangrana.exception.TooMuchTriesException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static tv.mangrana.utils.Output.getCurrentTime;
import static tv.mangrana.utils.Output.msg;
import static tv.mangrana.utils.Waiter.waitMinutes;
import static tv.mangrana.utils.Waiter.waitSeconds;

public class RetryEngine<D> {

    private final String title;
    private final int minutesToWait;
    private final ChildrenRequirements<D> childrenRequirements;
    private final Consumer<String> logger;

    public static class ChildrenRequirements<D> {
        final int children;
        final Function<D, List<D>> retriever;
        final Function<D, Boolean> constraint;
        final int childrenLookupMaxRetries;

        public ChildrenRequirements(int childrenMustHave, Function<D, List<D>> childrenRetriever, Function<D, Boolean> constraint, int childrenLookupMaxRetries){
            this.children = childrenMustHave;
            this.retriever = childrenRetriever;
            this.constraint = constraint;
            this.childrenLookupMaxRetries = childrenLookupMaxRetries;
        }
    }

    public enum Action {
        PERFORMED
    }

    public RetryEngine(String title, int minutesToWait, Consumer<String> logger) {
        this(title, minutesToWait, null, logger);
    }
    public RetryEngine(String title, int minutesToWait, ChildrenRequirements<D> childrenRequirements, Consumer<String> logger) {
        this.title = title;
        this.minutesToWait = minutesToWait;
        this.childrenRequirements = childrenRequirements;
        this.logger = logger;
    }

    public D tryUntilGotDesired(Supplier<D> tryToGet, final int tooMuchTriesThreshold) throws TooMuchTriesException {
        AtomicInteger loopCount = new AtomicInteger(1);
        D desired = null;
        boolean waitForChildren = Optional.ofNullable(childrenRequirements).map(req -> req.children > 0).orElse(false);
        while (Objects.isNull(desired)) {
            try {
                desired = tryToGet.get();
            } catch (Exception e) {
                log("An error was occurred when trying to get element but it only will count as a failed try. The stacktrace will be printed.");
                e.printStackTrace();
            }
            if (Objects.isNull(desired)) {
                if (loopCount.get() >= tooMuchTriesThreshold) {
                    throw new TooMuchTriesException("Too much tries when retrieving desired element");
                }
                if (loopCount.get() == 1) log(msg("The element was not found yet and will retry every {0} minutes - {1}", minutesToWait, getCurrentTime()));
                loopCount.incrementAndGet();
                waitMinutes(minutesToWait);
            } else if (waitForChildren) {
                childrenCheckingLoop(desired);
            }
        }
        log("the try was satisfied and will return the desired element/s");
        return desired;
    }

    private void childrenCheckingLoop(D got) {
        AtomicInteger loopCount = new AtomicInteger(1);
        boolean waitForChildren=true;
        boolean childrenConstraintSatisfied = childrenRequirements.constraint == null;
        while (waitForChildren) {
            List<D> children = childrenRequirements.retriever.apply(got);
            if (children.size() < childrenRequirements.children) {
                if (loopCount.get() >= childrenRequirements.childrenLookupMaxRetries) {
                    log(msg("Too much tries when retrieving children from {0} while current is {1} and expected {2}. However, we will work with the files we have.",
                                        got.getClass().getSimpleName(), children.size(), childrenRequirements.children));
                    waitForChildren = false;
                }
                if (loopCount.get() == 1)
                    log(msg("Not enough children yet ({2} vs {3}) and will retry in {0} minutes - {1}",
                                        minutesToWait, getCurrentTime(), children.size(), childrenRequirements.children));
                loopCount.incrementAndGet();
                waitMinutes(minutesToWait);
            } else {
                if (!childrenConstraintSatisfied) {
                    childrenConstraintSatisfied = children.stream().allMatch(childrenRequirements.constraint::apply);
                }
                else {
                    waitForChildren = false;
                    waitSeconds(50);
                }
            }
        }
    }

    private void log (String msg) {
        logger.accept(msg("-|*|RetryEngine.{0}|*|- {1}", title, msg));
    }

}
