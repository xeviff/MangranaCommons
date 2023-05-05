package tv.mangrana.radarr.api.client.gateway;

import tv.mangrana.config.CommonConfigFileLoader;
import tv.mangrana.radarr.api.schema.command.RefreshMoviesCommand;
import tv.mangrana.radarr.api.schema.movie.MovieResource;
import tv.mangrana.radarr.api.schema.queue.QueueResourcePagingResource;
import tv.mangrana.utils.rest.APIProxyBuilderSingleton;

import java.util.List;

import static tv.mangrana.config.CommonConfigFileLoader.CommonProjectConfiguration.RADARR_API_HOST;
import static tv.mangrana.config.CommonConfigFileLoader.CommonProjectConfiguration.RADARR_API_KEY;
import static tv.mangrana.utils.Output.log;

public class RadarrApiGateway {

    private final String apiKey;
    private final RadarrAPIInterface proxy;

    public RadarrApiGateway(CommonConfigFileLoader<?> config) {
        apiKey = config.getConfig(RADARR_API_KEY);
        proxy = APIProxyBuilderSingleton.getRadarrInterface(config.getConfig(RADARR_API_HOST));
    }

    public QueueResourcePagingResource getQueue() {
        return proxy.getQueue(true, apiKey);
    }

    public MovieResource getMovieById(Integer movieId) {
        MovieResource movie = proxy.getMovieById(movieId, apiKey);
        log("retrieved movie from radarr with id "+movieId);
        return movie;
    }

    public List<MovieResource> movieLookupByTMDBid (int tmdbId) {
        return proxy.movieLookupByTMDBid(tmdbId, apiKey);
    }

    public void removeQueueItem(int itemId) {
        proxy.removeQueueItem(itemId, false, apiKey);
        log("removed item from queue successfully: "+itemId);
    }

    public void refreshMovie(int movieId) {
        proxy.refreshMoviesCommand(new RefreshMoviesCommand(movieId), apiKey);
        log("refreshed movie with id "+movieId);
    }

    public void updateMovie(MovieResource movie){
        proxy.updateMovie(movie, movie.getId(), apiKey);
    }

    public void relocateMovie(MovieResource movie){
        proxy.relocateMovie(movie, movie.getId(), true, apiKey);
    }

    public List<MovieResource> movieLookupByTitle (String title) {
        return proxy.movieLookupByTitle(title, apiKey);
    }
}
