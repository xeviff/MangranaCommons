package tv.mangrana.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Optional;

public class PathUtils {

    public static final char SEPARATOR = '/';

    private PathUtils(){}

    public static String addSubElement(String parentFolder, String childFolder) {
        return parentFolder+ SEPARATOR +childFolder;
    }
    public static String rootFolder(String rootFolderName){
        return addSubElement("",rootFolderName);
    }

    public static String getParentFromFullPath(String absolutePath){
        return Paths
                .get(absolutePath)
                .getParent()
                .getFileName()
                .toString();
    }

    public static String getCurrentFromFullPath(String absolutePath) {
        return absolutePath.substring(absolutePath.lastIndexOf(SEPARATOR)+1);
    }

    public static int compareFileCreationDate (File o1, File o2) {
        final String creationTimeAttr = "creationTime";
        int res = 0;
        try {
            FileTime o1Birthday = (FileTime) Files.getAttribute(o1.toPath(), creationTimeAttr);
            FileTime o2Birthday = (FileTime) Files.getAttribute(o2.toPath(), creationTimeAttr);
            res = o1Birthday.compareTo(o2Birthday);
        } catch (IOException e) {
            log("there was a problem trying to compare creation date between "
            + o1.getName() + " and " + o2.getName());
        }
        return res;
    }

    private static void log(String msg){
        Output.log("PathUtils: "+msg);
    }

    public static String getRootProjectPath() {
        return System.getProperty("user.dir");
    }
}
