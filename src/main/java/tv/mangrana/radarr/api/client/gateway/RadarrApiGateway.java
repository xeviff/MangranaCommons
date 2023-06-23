package tv.mangrana.radarr.api.client.gateway;

import tv.mangrana.config.CommonConfigFileLoader;
import tv.mangrana.exception.TooMuchTriesException;
import tv.mangrana.radarr.api.schema.command.RefreshMoviesCommand;
import tv.mangrana.radarr.api.schema.movie.Movie2Add;
import tv.mangrana.radarr.api.schema.movie.MovieFile;
import tv.mangrana.radarr.api.schema.movie.MovieResource;
import tv.mangrana.radarr.api.schema.queue.QueueResourcePagingResource;
import tv.mangrana.utils.EasyLogger;
import tv.mangrana.utils.RetryEngine;
import tv.mangrana.utils.RetryEngine.Action;
import tv.mangrana.utils.rest.APIProxyBuilderSingleton;

import java.util.List;
import java.util.function.Supplier;

import static tv.mangrana.config.CommonConfigFileLoader.CommonProjectConfiguration.RADARR_API_HOST;
import static tv.mangrana.config.CommonConfigFileLoader.CommonProjectConfiguration.RADARR_API_KEY;

public class RadarrApiGateway {

    protected final EasyLogger logger;
    private final String apiKey;
    private final RadarrAPIInterface proxy;

    public RadarrApiGateway(CommonConfigFileLoader<?> config) {
        apiKey = config.getConfig(RADARR_API_KEY);
        proxy = APIProxyBuilderSingleton.getRadarrInterface(config.getConfig(RADARR_API_HOST));
        logger = new EasyLogger();
    }

    public QueueResourcePagingResource getQueue() {
        return proxy.getQueue(true, apiKey);
    }

    public MovieResource getMovieById(Integer movieId) {
        MovieResource movie = proxy.getMovieById(movieId, apiKey);
        logger.nLog("retrieved movie from radarr with id "+movieId);
        return movie;
    }

    public MovieResource getMovieByTMDBid (int tmdbId) throws TooMuchTriesException {
        Supplier<MovieResource> movieLookup = () -> {
            try {
                List<MovieResource> retrieved = proxy.getMovieByTMDBid(tmdbId, apiKey);
                if (!retrieved.isEmpty())
                    return retrieved.get(0);
                else return null;
            } catch (Exception e) {
                logger.nLog("failed movieLookupByTMDBid for {0}. Will be retried.", String.valueOf(tmdbId));
                e.printStackTrace();
                return null;
            }
        };
        return createMovieRetryer("MovieLookupByTMDBid")
                .tryUntilGotDesired(movieLookup, 10);
    }

    public MovieResource movieLookupByTMDBid (int tmdbId) throws TooMuchTriesException {
        Supplier<MovieResource> movieLookup = () -> {
            try {
                return proxy.movieLookupByTMDBid(tmdbId, apiKey);
            } catch (Exception e) {
                logger.nLog("failed movieLookupByTMDBid for {0}. Will be retried.", String.valueOf(tmdbId));
                e.printStackTrace();
                return null;
            }
        };
        RetryEngine<MovieResource> retrier = new RetryEngine<>("MovieLookupByTMDBid", 2, logger::nLog);
        return retrier.tryUntilGotDesired(movieLookup, 10);
    }

    public boolean existMovieInRadarr(int tmdbId) throws TooMuchTriesException {
        Supplier<Boolean> checkExistence = () -> {
            try {
                List<MovieResource> retrieved = proxy.getMovieByTMDBid(tmdbId, apiKey);
                return retrieved.isEmpty() ? Boolean.FALSE : Boolean.TRUE;
            } catch (Exception e) {
                logger.nLog("failed getMovieByTMDBid for {0}. Will be retried.", String.valueOf(tmdbId));
                e.printStackTrace();
                return null;
            }
        };
        return createPredicateRetryer("MovieLookupByTMDBid")
                .tryUntilGotDesired(checkExistence, 10);
    }

    public void removeQueueItem(int itemId) {
        proxy.removeQueueItem(itemId, false, apiKey);
        logger.nLog("removed item from queue successfully: "+itemId);
    }

    public void refreshMovie(int movieId) throws TooMuchTriesException {
        Supplier<RetryEngine.Action> refresh = () -> {
            try {
                proxy.refreshMoviesCommand(new RefreshMoviesCommand(movieId), apiKey);
                return Action.PERFORMED;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        };
        createActionRetryer("RefreshMovie")
                .tryUntilGotDesired(refresh, 10);

        logger.nLog("refreshed movie with id "+movieId);
    }

    public void updateMovie(MovieResource movie) throws TooMuchTriesException {
        Supplier<RetryEngine.Action> refresh = () -> {
            try {
                proxy.updateMovie(movie, movie.getId(), apiKey);
                return Action.PERFORMED;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        };
        createActionRetryer("updateMovie")
                .tryUntilGotDesired(refresh, 10);

        logger.nLog("updated movie in Radarr with id "+movie.getId());
    }

    public void relocateMovie(MovieResource movie){
        proxy.relocateMovie(movie, movie.getId(), true, apiKey);
    }

    public MovieResource movieLookupByTitle (String title) throws TooMuchTriesException {
        Supplier<MovieResource> movieLookup = () -> {
            try {
                List<MovieResource> retrieved = proxy.movieLookupByTitle(title, apiKey);
                if (!retrieved.isEmpty())
                    return retrieved.get(0);
                else return null;
            } catch (Exception e) {
                logger.nLog("failed movieLookupByTitle for {0}. Will be retried.", title);
                e.printStackTrace();
                return null;
            }
        };
        return createMovieRetryer("MovieLookupByTitle")
                .tryUntilGotDesired(movieLookup, 10);
    }

    public void importMovie(MovieResource movie) throws TooMuchTriesException {
        Supplier<RetryEngine.Action> refresh = () -> {
            try {
                proxy.importMovie(movie, apiKey);
                return Action.PERFORMED;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        };
        createActionRetryer("addMovieMovie")
                .tryUntilGotDesired(refresh, 10);

        logger.nLog("add movie in Radarr with id "+movie.getId());
    }

    public void addMovie(Movie2Add movie) {
        proxy.addMovie(movie, apiKey);
    }

    public MovieFile getFileByMovieId (int movieId) throws TooMuchTriesException {
        Supplier<MovieFile> movieLookup = () -> {
            try {
                List<MovieFile> retrieved = proxy.getFileByMovieId(movieId, apiKey);
                if (!retrieved.isEmpty())
                    return retrieved.get(0);
                else return null;
            } catch (Exception e) {
                logger.nLog("failed movieLookupByTitle for {0}. Will be retried.", String.valueOf(movieId));
                e.printStackTrace();
                return null;
            }
        };
        RetryEngine<MovieFile> retryer = new RetryEngine<>("MovieLookupByTitle", 1, logger::nLog);
        return retryer.tryUntilGotDesired(movieLookup, 10);
    }

    public boolean existFileByMovieId (int movieId) throws TooMuchTriesException {
        Supplier<Boolean> movieLookup = () -> {
            try {
                List<MovieFile> retrieved = proxy.getFileByMovieId(movieId, apiKey);
                return retrieved.isEmpty() ? Boolean.FALSE : Boolean.TRUE;
            } catch (Exception e) {
                logger.nLog("failed movieLookupByTitle for {0}. Will be retried.", String.valueOf(movieId));
                e.printStackTrace();
                return null;
            }
        };
        RetryEngine<Boolean> retryer = new RetryEngine<>("getFileByMovieId", 1, logger::nLog);
        return retryer.tryUntilGotDesired(movieLookup, 10);
    }

    public void updateFile(MovieFile file) throws TooMuchTriesException {
        Supplier<RetryEngine.Action> refresh = () -> {
            try {
                proxy.updateFile(file, file.getId(), apiKey);
                return Action.PERFORMED;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        };
        createActionRetryer("updateMovie")
                .tryUntilGotDesired(refresh, 10);

        logger.nLog("updated file in Radarr with id "+file.getId());
    }

    private RetryEngine<MovieResource> createMovieRetryer(String title) {
        return new RetryEngine<>(title,1,logger::nLog);
    }

    private RetryEngine<Action> createActionRetryer(String title) {
        return new RetryEngine<>(title,2,logger::nLog);
    }

    private RetryEngine<Boolean> createPredicateRetryer(String title) {
        return new RetryEngine<>(title,1,logger::nLog);
    }

}
