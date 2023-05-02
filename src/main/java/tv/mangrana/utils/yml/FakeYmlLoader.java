package tv.mangrana.utils.yml;

import tv.mangrana.exception.IncorrectWorkingReferencesException;
import tv.mangrana.utils.EasyLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;


/**
 * Only applicable to the following format
 * key1: value1
 * key:2 value2
 */
public class FakeYmlLoader {

    private static final EasyLogger logger = new EasyLogger(FakeYmlLoader.class);

    private FakeYmlLoader(){}

    @SuppressWarnings("all")
    public static <E extends Enum<E>> EnumMap<E, String> getEnumMapFromFile(File ymlFile, Class<E> enumData, boolean silently) throws IncorrectWorkingReferencesException {
        EnumMap<E, String> enumMap = new EnumMap<>(enumData);
        try (Stream<String> linesStream = Files.lines(ymlFile.toPath())) {
            Pattern simpleYmlKeyValuePattern = Pattern.compile(".+: .+");
            Stream<String> filteredLines = getFilteredLines(simpleYmlKeyValuePattern, linesStream);
            Map<String, String> fileLines = mapLinesToKeyValue(filteredLines);

            Arrays.stream(enumData.getEnumConstants())
                    .forEach(cons ->
                            enumMap.put(cons, fileLines.get(cons.name().toLowerCase()))
                    );
            if (!silently) {
                logger.nLog("Mapped <key: value> from file {0} to -{1}- EnumMap",
                        ymlFile.getAbsolutePath(), enumData.getSimpleName());
            }
            return enumMap;
        } catch (IOException e) {
            logger.nHLog("Some problem occurred trying to map file {0} to EnumMap {1}",
                    ymlFile.getAbsolutePath(), enumData.getName());
            e.printStackTrace();
        }
        return null;
    }

    private static Stream<String> getFilteredLines(Pattern simpleYmlKeyValuePattern, Stream<String> stream) {
        return stream
                .filter(keyValueCandidate -> simpleYmlKeyValuePattern
                        .matcher(keyValueCandidate)
                        .matches()
                );
    }

    private static Map<String, String> mapLinesToKeyValue(Stream<String> stringStream) {
        Map<String, String> keyValueMap = new HashMap<>();
        stringStream.forEach(line -> {
            try {
                int firstPosition = line.indexOf(':');
                if (firstPosition != line.lastIndexOf(':')) {
                    line = line.replace(':', '-');
                    line = line.replaceFirst("-", ":");
                }
                String[] keyValue = line.split(":");
                keyValueMap.put(keyValue[0], keyValue[1].trim());
            } catch (Exception e) {
                logger.nHLog("Some problem occurred trying to map line {0} to key-value", line);
                e.printStackTrace();
            }
        });
        return keyValueMap;
    }

}
