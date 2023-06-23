package tv.mangrana.radarr.api.client.gateway;

import tv.mangrana.radarr.api.schema.command.RefreshMoviesCommand;
import tv.mangrana.radarr.api.schema.movie.Movie2Add;
import tv.mangrana.radarr.api.schema.movie.MovieFile;
import tv.mangrana.radarr.api.schema.movie.MovieResource;
import tv.mangrana.radarr.api.schema.queue.QueueResourcePagingResource;
import tv.mangrana.utils.rest.APIInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * For more information, visit: <a href="https://radarr.video/docs/api/#/Movie/get_api_v3_movie">...</a>
 */
@Path("/api/v3")
public interface RadarrAPIInterface extends APIInterface {

    @GET
    @Path("/queue")
    @Produces({ MediaType.APPLICATION_JSON })
    QueueResourcePagingResource getQueue(@QueryParam("includeMovie") boolean includeMovie, @QueryParam("apikey") String apikey);

    @DELETE
    @Path("/queue/{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    void removeQueueItem(@PathParam("id") int itemId, @QueryParam("removeFromClient") boolean removeFromClient, @QueryParam("apikey") String apikey);

    @GET
    @Path("/movie/{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    MovieResource getMovieById(@PathParam("id") int movieId, @QueryParam("apikey") String apikey);

    @GET
    @Path("/movie")
    @Produces({ MediaType.APPLICATION_JSON })
    List<MovieResource> getMovieByTMDBid(@QueryParam("tmdbId") int tmdbId, @QueryParam("apikey") String apikey);

    @GET
    @Path("/movie/lookup/tmdb")
    @Produces({ MediaType.APPLICATION_JSON })
    MovieResource movieLookupByTMDBid(@QueryParam("tmdbId") int tmdbId, @QueryParam("apikey") String apikey);

    @POST
    @Path("/command")
    @Consumes({ MediaType.APPLICATION_JSON })
    void refreshMoviesCommand(RefreshMoviesCommand command, @QueryParam("apikey") String apikey);

    @PUT
    @Path("/movie/{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    void updateMovie(MovieResource movie, @PathParam("id") int movieId, @QueryParam("apikey") String apikey);

    @POST
    @Path("/movie")
    @Consumes({ MediaType.APPLICATION_JSON })
    void addMovie(Movie2Add movie, @QueryParam("apikey") String apikey);

    @POST
    @Path("/movie/import")
    @Consumes({ MediaType.APPLICATION_JSON })
    void importMovie(MovieResource movie, @QueryParam("apikey") String apikey);

    @GET
    @Path("/moviefile")
    @Produces({ MediaType.APPLICATION_JSON })
    List<MovieFile> getFileByMovieId(@QueryParam("movieId") int movieId, @QueryParam("apikey") String apikey);

    @PUT
    @Path("/moviefile/{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    void updateFile(MovieFile file, @PathParam("id") int fileId, @QueryParam("apikey") String apikey);

    @PUT
    @Path("/movie/{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    void relocateMovie(MovieResource movie, @PathParam("id") int movieId, @QueryParam("moveFiles") boolean moveFiles, @QueryParam("apikey") String apikey);

    @GET
    @Path("/movie/lookup")
    @Produces({ MediaType.APPLICATION_JSON })
    List<MovieResource> movieLookupByTitle(@QueryParam("term") String term, @QueryParam("apikey") String apikey);
}