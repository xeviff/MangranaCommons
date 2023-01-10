package tv.mangrana.jobs;

import tv.mangrana.config.LocalEnvironmentManager;
import tv.mangrana.exception.JobFileNotMovedException;

import java.io.File;

import static tv.mangrana.jobs.JobFile.JobLocation.*;
import static tv.mangrana.utils.PathUtils.shiftFileFolder;

public abstract class JobFile<E> {

    public enum JobLocation {
        PATH_TODO("to_do"),
        PATH_DOING("doing"),
        PATH_DONE("done");
        private final String folderName;
        private static final String LOCAL_WORKING_PATH = "local_test";
        JobLocation(String folderName) {
            this.folderName=folderName;
        }
        public String getFolderName(){
            return getLocalNameIfNecessary(this);
        }
        private String getLocalNameIfNecessary(JobLocation location) {
            if (LocalEnvironmentManager.isLocal()
                    && (location.equals(JobLocation.PATH_TODO) || location.equals(JobLocation.PATH_DOING))) {
                return LOCAL_WORKING_PATH;
            }
            return location.folderName;
        }
    }

    protected JobFile(File jobFile) {
        this.jobFile = jobFile;
    }

    public abstract String getInfo(E key);

    public abstract boolean hasNoInfo();

    protected File jobFile;

    public File getFile () {
        return jobFile;
    }


    public void markDoing() throws JobFileNotMovedException {
        if (jobFile.getAbsolutePath().contains(PATH_TODO.getFolderName())) {
            jobFile = shiftFileFolder(jobFile, PATH_TODO, PATH_DOING);
        }
    }

    public void markDone() throws JobFileNotMovedException {
        jobFile = shiftFileFolder(jobFile, PATH_DOING, PATH_DONE);
    }

    public void forceMarkDone() throws JobFileNotMovedException {
        if (jobFile.getAbsolutePath().contains(PATH_DOING.getFolderName())) {
            jobFile = shiftFileFolder(jobFile, PATH_DOING, PATH_DONE);
        } else if (jobFile.getAbsolutePath().contains(PATH_TODO.getFolderName())) {
            jobFile = shiftFileFolder(jobFile, PATH_TODO, PATH_DONE);
        }
    }

    public void driveBack() throws JobFileNotMovedException {
        if (jobFile.getAbsolutePath().contains(PATH_DOING.getFolderName())) {
            jobFile = shiftFileFolder(jobFile, PATH_DOING, PATH_TODO);
        }
    }

}
