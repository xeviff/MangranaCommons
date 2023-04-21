package tv.mangrana.utils;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Output {

    public static final String DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    protected Output(){}

    private static void log (String msg) {
        System.out.println(msg);
    }
    public static void log (String msg, Object... params) {
        try {
            if (params.length>0)
                log(msg(msg, params));
            else
                log(msg);
        } catch (Exception e) {
            log("error trying to log with msg="+msg+" and params "+Arrays.toString(params));
        }
    }

    public static void logWithDate(String msg) {
        log(msg+" - "+getCurrentTime());
    }

    public static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        return dateFormat.format(new Date());
    }

    public static String msg(String msg, Object... params) {
        return MessageFormat.format(msg, params);
    }

    public static String formatTitle(String title, int length) {
        return title.length() > length ? title.substring(0,length-3)+"..."
                : StringUtils.rightPad(title.concat(" "), length, '.');
    }

}
