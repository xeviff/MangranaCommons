package tv.mangrana.config;


import org.apache.commons.lang.StringUtils;

public class LocalEnvironmentManager {

    private LocalEnvironmentManager(){}

    public static final String PROJECT_ROOT = System.getProperty("user.dir");

    public static boolean isLocal () {
        String envVar = System.getenv("ENV");
        return
                StringUtils.isNotEmpty(envVar)
                && envVar.equals("local");
    }

}
