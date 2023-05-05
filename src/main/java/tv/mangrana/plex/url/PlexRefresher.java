package tv.mangrana.plex.url;

import tv.mangrana.config.CommonConfigFileLoader;

import static tv.mangrana.config.CommonConfigFileLoader.CommonProjectConfiguration.*;

public class PlexRefresher {

    private final PlexCommandLauncher commandLauncher;
    private final CommonConfigFileLoader<?> config;

    public PlexRefresher(CommonConfigFileLoader<?> config) {
        this.commandLauncher = new PlexCommandLauncher(config);
        this.config = config;
    }

    public boolean scanSerieByPath(String fullDestinationPath) {
        try {
            String sonarrPathStarter = config.getConfig(SONARR_PATHS_STARTER);
            String plexMountPath = config.getConfig(PLEX_SERIES_PATHS_STARTER);
            String path2Refresh = fullDestinationPath.replaceFirst(sonarrPathStarter, plexMountPath);
            return commandLauncher.scanByPath(path2Refresh, plexMountPath);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean scanMovieByPath(String fullDestinationPath) {
        try {
            String radarrPathStarter = config.getConfig(RADARR_PATHS_STARTER);
            String plexMountPath = config.getConfig(PLEX_MOVIES_PATHS_STARTER);
            String pathToRefresh = fullDestinationPath.replaceFirst(radarrPathStarter, plexMountPath);
            return commandLauncher.scanByPath(pathToRefresh, plexMountPath);
        } catch (Exception e) {
            return false;
        }
    }
}
