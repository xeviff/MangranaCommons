package tv.mangrana.config;


import org.apache.commons.lang.StringUtils;

public class LocalEnvironmentManager {

    public enum LocalMode {NAS, PC, CONTABO}

    static LocalMode mode;
    static {
        mode = LocalMode.PC;
    }

    public static final String PROJECT_ROOT = System.getProperty("user.dir");

    public static final String REMOTE_ACCESS_FOLDER_FROM_MAC = "Volumes";

    public static void setLocalMode(String mode) {
        try {
            LocalEnvironmentManager.mode = LocalMode.valueOf(mode);
        } catch (IllegalArgumentException ignored) {
        }
    }

    public static String getRootPath() {
        return mode.equals(LocalMode.PC) ? PROJECT_ROOT : REMOTE_ACCESS_FOLDER_FROM_MAC;
    }

    public static boolean isLocal () {
        String envVar = System.getenv("ENV");
        return
                StringUtils.isNotEmpty(envVar)
                && envVar.equals("local");
    }

    public static boolean isWorkingWithProdFiles () {
        return mode.equals(LocalMode.CONTABO) || !isLocal();
    }

    public static LocalMode getLocalMode() {
        return mode;
    }

}
