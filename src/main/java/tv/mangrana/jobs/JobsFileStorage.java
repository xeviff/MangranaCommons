package tv.mangrana.jobs;

import org.apache.commons.lang.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static tv.mangrana.utils.Output.DATE_TIME_FORMAT;

public class JobsFileStorage {

    static final String COMPLETED_DATE = "done";
    static final String JOB_TYPE = "type";
    static final String HASH = "hash";
    static final String ARR_ID = "arrId";
    static final String INTERNET_DB_ID = "iId";
    static final String ELEMENT_NAME = "element";

    public final String JOB_LINE_FORMAT;

    public JobsFileStorage() {
        String preFormat = "{COMPLETED_DATE}: {5} | {JOB_TYPE}: {0} | {HASH}: {1} | {ARR_ID}: {2} | {INTERNET_DB_ID}: {3} | {ELEMENT_NAME}: {4}";
        JOB_LINE_FORMAT = preFormat
                .replace("{COMPLETED_DATE}", COMPLETED_DATE)
                .replace("{JOB_TYPE}", JOB_TYPE)
                .replace("{HASH}", HASH)
                .replace("{ARR_ID}", ARR_ID)
                .replace("{INTERNET_DB_ID}", INTERNET_DB_ID)
                .replace("{ELEMENT_NAME}", ELEMENT_NAME);
    }
    String resumeFile = JobFileManager.getResumeFile();

    public void persistCompleted(String type, String downloadId, int arrId, int iId, String element, LocalDateTime time){
        String jobLine = MessageFormat.format(JOB_LINE_FORMAT,
                type,
                downloadId,
                fixLength(String.valueOf(arrId)),
                fixLength(String.valueOf(iId)),
                element,
                formatTime(time));
        addLine(jobLine);
    }

    String fixLength(String text) {
        return StringUtils.rightPad(text, 7);
    }

    void addLine(String jobLine) {
        try (FileWriter fw = new FileWriter(resumeFile, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(jobLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getIIDByElement(String element) {
        try (Stream<String> linesStream = Files.lines(Paths.get(resumeFile))) {
            return linesStream
                    .map(this::line2Map)
                    .filter(mappedLine -> mappedLine.get(ELEMENT_NAME).equals(element))
                    .findAny()
                    .map(found -> found.get(INTERNET_DB_ID))
                    .orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, String> line2Map(String line) {
        Map<String, String> mappedLine = new HashMap<>();
        String[] infoList = line.split("\\|");
        for (String elementInfo : infoList) {
            if (!elementInfo.trim().startsWith(COMPLETED_DATE)) {
                String[] fieldValue = elementInfo.split(":");
                String field = fieldValue[0].trim();
                String value = fieldValue[1].trim();
                mappedLine.put(field, value);
            }
        }
        return mappedLine;
    }

    String formatTime(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

}
