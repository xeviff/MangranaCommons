package tv.mangrana.config;


import org.apache.commons.lang.StringUtils;

public class LocalEnvironmentManager {

    public enum LocalMode {NAS, PC}

    static LocalMode mode;
    static {
        mode = LocalMode.NAS;
    }

    public static final String PROJECT_ROOT = System.getProperty("user.dir");

    public static final String REMOTE_ACCESS_FOLDER_FROM_MAC = "Volumes";

    public static void setLocalMode(LocalMode mode) {
        try {
            LocalEnvironmentManager.mode = mode;
        } catch (IllegalArgumentException ignored) {
        }
    }

    public static String getLocalRootPath() {
        return mode.equals(LocalMode.PC) ? PROJECT_ROOT : REMOTE_ACCESS_FOLDER_FROM_MAC;
    }

    public static boolean isLocal () {
        String envVar = System.getenv("ENV");
        return
                StringUtils.isNotEmpty(envVar)
                && envVar.equals("local");
    }

    public static boolean isWorkingWithProdFiles () {
        return mode.equals(LocalMode.NAS) || !isLocal();
    }

    public static LocalMode getLocalMode() {
        return mode;
    }

}
