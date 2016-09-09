package demon.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    /**
     * 将 Date 类型时间转成 unix 时间戳
     * 
     * @param date
     * @return unix 时间戳
     */
    public static long dateToLong(Date date) {
        return date.getTime();
    }

    /**
     * 将 unix 时间戳格式化成指定格式
     * 
     * @param time
     *            unix 时间戳
     * @return 时间格式：yyyy-MM-dd HH:mm:ss
     */
    public static String longTimeToString(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return formatter.format(time);
    }

    /**
     * 将 unix 时间戳格式化成指定格式
     * 
     * @param time
     *            unix 时间戳
     * @param format
     *            常用类型如下 <blockquote> <br>
     *            yyyy-MM-dd HH:mm:ss <br>
     *            yyyy-MM-dd <br>
     *            HH:mm:ss <br>
     *            HH:mm:ss yyyy-MM-dd <br>
     *            MM-dd-yyyy HH:mm:ss </blockquote>
     * @return 格式化时间
     */
    public static String longTimeToString(long time, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        return formatter.format(time);
    }

    /**
     * 将 Date 时间格式化成指定格式
     * 
     * @param date
     *            java.util.Date
     * @param format
     *            常用类型如下 <blockquote> <br>
     *            yyyy-MM-dd HH:mm:ss <br>
     *            yyyy-MM-dd <br>
     *            HH:mm:ss <br>
     *            HH:mm:ss yyyy-MM-dd <br>
     *            MM-dd-yyyy HH:mm:ss </blockquote>
     */
    public static String dateToString(java.util.Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(date);

        return dateString;
    }

    /**
     * 获取当前系统时间
     * @return java.util.Date
     */
    public static Date getCurrentTimeDate() {
        Date currentTime = new Date();
        return currentTime;
    }

    /**
     * 获取当前系统时间
     * 
     * @return unix 时间戳
     */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {

        System.out.println(longTimeToString(14999990610451L));
        
        System.out.println(longTimeToString(1463705675664L, "HH:mm:ss yyyy-MM-dd"));
        System.currentTimeMillis();
        System.out.println(getCurrentTimeDate());
    }
}