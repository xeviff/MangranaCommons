package tv.mangrana.jobs;

import tv.mangrana.config.LocalEnvironmentManager;
import tv.mangrana.exception.JobFileNotMovedException;
import tv.mangrana.utils.PathUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static tv.mangrana.config.LocalEnvironmentManager.LocalMode.CONTABO;
import static tv.mangrana.config.LocalEnvironmentManager.getLocalMode;
import static tv.mangrana.jobs.JobFile.JobLocation;
import static tv.mangrana.jobs.JobFile.JobLocation.PATH_DOING;
import static tv.mangrana.jobs.JobFile.JobLocation.PATH_TODO;
import static tv.mangrana.utils.PathUtils.addSubFolder;
import static tv.mangrana.utils.PathUtils.rootFolder;

public class JobFileManager {

    private JobFileManager(){}

    static final String JOBS_FOLDER = "jobs";
    static final String CONTABO_JOBS_FOLDER = "contabo_jobs";

    public enum JobFileType {
        SONARR_JOBS("sonarr"),
        RADARR_JOBS("radarr"),
        TRANSMISSION_JOBS("transm");

        private final String folderName;
        JobFileType(String folderName) {
            this.folderName=folderName;
        }
        public String getFolderName(){
            return folderName;
        }
    }
    public static void moveUncompletedJobsToRetry(JobFileType appType) {
        File jobsDir = new File(getAbsolutePath(PATH_DOING, appType));
        File[] files = jobsDir.listFiles();
        List<File> uncompleted = files!=null
                ? Arrays.asList(files)
                : Collections.emptyList();
        uncompleted.forEach(file -> {
            try {
                PathUtils.shiftFileFolder(file, PATH_DOING, PATH_TODO);
            } catch (JobFileNotMovedException e) {
                e.printStackTrace();
            }
        });
    }

    public static List<File> retrieveJobFiles(String fileIdentifierRegex, JobFileType appType) {
        File jobsDir = new File(getAbsolutePath(PATH_TODO, appType));
        File[] files = jobsDir.listFiles();
        return files==null
                ? Collections.emptyList()
                : Arrays.stream(files)
                    .filter(file -> file.getName().matches(fileIdentifierRegex))
                    .sorted(PathUtils::compareFileCreationDate)
                    .collect(Collectors.toList());
    }

    public static String getAbsolutePath(JobLocation location, JobFileType appType) {
        String jobsFolder = LocalEnvironmentManager.isLocal()
                ? addSubFolder(rootFolder(LocalEnvironmentManager.getRootPath()), getLocalJobsFolder())
                : rootFolder(JOBS_FOLDER);
        String appFolderPath =  addSubFolder(jobsFolder, appType.getFolderName());
        return addSubFolder(appFolderPath, location.getFolderName());
    }


    static String getLocalJobsFolder() {
        return CONTABO.equals(getLocalMode())
                ? CONTABO_JOBS_FOLDER
                : JOBS_FOLDER;
    }
}
