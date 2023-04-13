package tv.mangrana.plex.url;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import tv.mangrana.config.CommonConfigFileLoader;
import tv.mangrana.utils.EasyLogger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import static tv.mangrana.config.CommonConfigFileLoader.CommonProjectConfiguration.*;
import static tv.mangrana.utils.Output.log;
import static tv.mangrana.utils.rest.APIInterface.ProtocolURLMark.HTTPS;

public class PlexCommandLauncher {

    private final EasyLogger logger;
    private final CommonConfigFileLoader<?> config;
    private final PlexLibrarySectionsResolver sectionResolver;

    public PlexCommandLauncher(CommonConfigFileLoader<?> config) {
        this.config = config;
        this.logger = new EasyLogger();
        this.sectionResolver = new PlexLibrarySectionsResolver(this, config);
    }

//    public static void main(String[] args) throws IncorrectWorkingReferencesException {
//        String toRefresh="/tv/Series/C/City on a Hill (2019)";
//        new PlexCommandLauncher(new CommonConfigFileLoader()).scanByPath(toRefresh);
//    }

    public boolean scanSerieByPath(String fullDestinationPath) {
        try {
            return scanByPath(getPlexSeriePath2Refresh(fullDestinationPath));
        } catch (Exception e) {
            return false;
        }
    }
    public boolean scanMovieByPath(String fullDestinationPath) {
        try {
            return scanByPath(getPlexMoviePath2Refresh(fullDestinationPath));
        } catch (Exception e) {
            return false;
        }
    }

    private boolean scanByPath(String plexPathToRefresh) {
        boolean ok = true;
        String plexRefreshURL = getPlexRefreshURL(plexPathToRefresh);
        if (plexRefreshURL==null) return false;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpUriRequest httpGET = RequestBuilder.get()
                    .setUri(new URI(plexRefreshURL))
                    .addParameter("path", plexPathToRefresh)
                    .addParameter("X-Plex-Token", config.getConfig(PLEX_TOKEN))
                    .build();
            httpclient.execute(httpGET);
            @SuppressWarnings("unused")
            String urlWithTokenHidden = httpGET.getURI().toString().replaceFirst(config.getConfig(PLEX_TOKEN), "__plex_token__");
            logger.nLog("Launched URL command: {0}",  httpGET.getURI().toString());
        } catch (Exception e) {
            logger.nHLog("Some error has happened using the URL <{0}>", plexRefreshURL);
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }

    public String getPlexSeriePath2Refresh(String fullDestinationPath) {
        String sonarrPathStarter = config.getConfig(SONARR_PATHS_STARTER);
        String seriesPlexDockerPathStarter = config.getConfig(PLEX_SERIES_PATHS_STARTER);
        return fullDestinationPath.replaceFirst(sonarrPathStarter, seriesPlexDockerPathStarter);
    }
    public String getPlexMoviePath2Refresh(String fullDestinationPath) {
        String radarrPathStarter = config.getConfig(RADARR_PATHS_STARTER);
        String moviesPlexDockerPathStarter = config.getConfig(PLEX_MOVIES_PATHS_STARTER);
        return fullDestinationPath.replaceFirst(radarrPathStarter, moviesPlexDockerPathStarter);
    }

    public Document retrieveSectionsInfo() {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            String plexSectionsURL = getPlexSectionsURL();
            HttpUriRequest httpGET = RequestBuilder.get()
                    .setUri(new URI(plexSectionsURL))
                    .addParameter("X-Plex-Token", config.getConfig(PLEX_TOKEN))
                    .build();

            try (CloseableHttpResponse httpResponse = httpclient.execute(httpGET)) {

                final HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    try (InputStream inputStream = entity.getContent()) {
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        return builder.parse(inputStream);
                    } catch (ParserConfigurationException | SAXException e) {
                        log("could not get the section information from plex url");
                    }
                }
            }
            log("launched url command: "+httpGET.getURI().toString().replaceFirst(config.getConfig(PLEX_TOKEN), "__plex_token__"));
        } catch (URISyntaxException | IOException e) {
            log("could not refresh plex artist because of "+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private String getPlexRefreshURL(String fullDestinationPath) {
        try {
            String sectionId = sectionResolver.resolveSectionByPath(fullDestinationPath);
            if (sectionId==null) return null;
            String host = config.getConfig(PLEX_HOST);
            String uriFormat = config.getConfig(PLEX_SECTION_REFRESH_URI);
            String uri = uriFormat.replaceFirst("\\{section_id}", sectionId);
            return HTTPS.getMark() + host + uri;
        } catch (Exception e) {
            return null;
        }
    }

    private String getPlexSectionsURL() {
        String host = HTTPS.getMark() + config.getConfig(PLEX_HOST);
        String uri = config.getConfig(PLEX_SECTIONS_LIST_URI);
        return host + uri;
    }

}
