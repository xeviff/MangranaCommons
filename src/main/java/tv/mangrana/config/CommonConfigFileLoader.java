package tv.mangrana.config;

import tv.mangrana.exception.IncorrectWorkingReferencesException;
import tv.mangrana.utils.yml.FakeYmlLoader;

import java.io.File;
import java.util.EnumMap;

public abstract class CommonConfigFileLoader<P extends Enum<P>> {

    private static final String CONFIG_FOLDER = "/config";

    public enum CommonProjectConfiguration {
        RADARR_API_KEY,
        RADARR_API_HOST,
        SONARR_API_KEY,
        SONARR_API_HOST,
        PLEX_TOKEN,
        PLEX_HOST,
        PLEX_SECTIONS_LIST_URI,
        PLEX_SECTION_REFRESH_URI,
        SONARR_PATHS_STARTER,
        PLEX_PATHS_STARTER
    }
    private EnumMap<CommonProjectConfiguration, String> commonConfigurationsMap;

    private final Class<P> projectConfigEnumType;
    private EnumMap<P, String> configurationsMap;


    public CommonConfigFileLoader(Class<P> projectConfigEnumType) throws IncorrectWorkingReferencesException {
        this.projectConfigEnumType = projectConfigEnumType;
        loadAllConfigFromFile(false);
    }
    public CommonConfigFileLoader<P> refresh() throws IncorrectWorkingReferencesException {
        return loadAllConfigFromFile(true);
    }
    
    private CommonConfigFileLoader<P> loadAllConfigFromFile(boolean silently) throws IncorrectWorkingReferencesException {
        commonConfigurationsMap = new EnumMap<>(CommonProjectConfiguration.class);
        commonConfigurationsMap.putAll( loadFromFile(CommonProjectConfiguration.class, silently) );

        configurationsMap = new EnumMap<>(projectConfigEnumType);
        configurationsMap.putAll( loadFromFile(projectConfigEnumType, silently) );
        
        return this;
    }

    private <E extends Enum<E>> EnumMap<E, String> loadFromFile(Class<E> enumType, boolean silently) throws IncorrectWorkingReferencesException {
        File configFile = new File(System.getProperty("user.dir")
                + CONFIG_FOLDER.concat("/").concat(getConfigFileName()));

        return FakeYmlLoader.getEnumMapFromFile(configFile, enumType, silently);
    }

    public String getConfig(P key) {
        return configurationsMap.get(key);
    }
    public String getCommonConfig(CommonProjectConfiguration key) {
        return commonConfigurationsMap.get(key);
    }

    protected abstract String getConfigFileName();

}
