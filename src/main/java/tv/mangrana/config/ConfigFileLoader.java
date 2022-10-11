package tv.mangrana.config;

import tv.mangrana.exception.IncorrectWorkingReferencesException;
import tv.mangrana.utils.yml.FakeYmlLoader;

import java.io.File;
import java.util.EnumMap;

public class ConfigFileLoader {

    private static final String CONFIG_FOLDER = "/config";
    private static final String CONFIG_FILE = "AfterDownloadCarerConfig.yml";

    public enum ProjectConfiguration {
        MANAGE_FAILED_DOWNLOADS,
        IMMORTAL_PROCESS,
        GRABBED_FILE_IDENTIFIER_REGEX,
        RADARR_API_KEY,
        RADARR_API_HOST,
        SONARR_API_KEY,
        SONARR_API_HOST,
        DOWNLOADS_TEAM_DRIVE_ID,
        DOWNLOADS_SERIES_FOLDER_ID,
        MOVIES_TEAM_DRIVE_ID,
        SERIES_TEAM_DRIVE_ID,
        PLEX_TOKEN,
        PLEX_HOST,
        PLEX_SECTIONS_LIST_URI,
        PLEX_SECTION_REFRESH_URI,
        GOOGLE_RETRY_INTERVAL,
        SONARR_RETRY_INTERVAL,
        RADARR_RETRY_INTERVAL,
        SONARR_PATHS_STARTER,
        PLEX_PATHS_STARTER
    }

    private EnumMap<ProjectConfiguration, String> configurationsMap;

    public ConfigFileLoader() throws IncorrectWorkingReferencesException {
        loadFromFile(false);
    }
    private ConfigFileLoader(boolean silently) throws IncorrectWorkingReferencesException {
        loadFromFile(silently);
    }
    public ConfigFileLoader refresh() throws IncorrectWorkingReferencesException {
        return loadFromFile(true);
    }
    public static ConfigFileLoader getFreshConfig() throws IncorrectWorkingReferencesException {
        return new ConfigFileLoader(true);
    }

    private ConfigFileLoader loadFromFile(boolean silently) throws IncorrectWorkingReferencesException {
        File configFile = new File(System.getProperty("user.dir")
                + CONFIG_FOLDER.concat("/").concat(CONFIG_FILE));

        configurationsMap = FakeYmlLoader.getEnumMapFromFile(configFile, ProjectConfiguration.class, silently);

        return this;
    }

    public String getConfig(ProjectConfiguration key) {
        return configurationsMap.get(key);
    }

}
