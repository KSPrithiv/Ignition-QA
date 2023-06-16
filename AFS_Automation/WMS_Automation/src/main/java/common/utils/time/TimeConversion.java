package common.utils.time;

import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TimeConversion {

    public static LocalDateTime getDateNow() {
        return LocalDateTime.now();
    }

    public static String getFormattedDateTime(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return dtf.format(getDateNow());
    }

    public static String getFormattedTime(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalTime localTime = LocalTime.now();
        return dtf.format(localTime);
    }

    public static String getFormattedDate(String format, LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return dtf.format(date);
    }

    public static String getFormattedCurrentDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    @SneakyThrows
    public static Date getFormattedDate(String fromFormat, String toFormat, String date) {
        SimpleDateFormat fromsdf = new SimpleDateFormat(fromFormat);
        SimpleDateFormat tosdf = new SimpleDateFormat(toFormat);
        Date fromDate = fromsdf.parse(date);
        String toDate = tosdf.format(fromDate);
        return tosdf.parse(toDate);
    }

    public static String futureDate(int count, int time, String date, String format) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            calendar.setTime(sdf.parse(date));
            calendar.add(time, count);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(calendar.getTime());
    }

    public static String pastDate(int count, int time, String date, String format) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            calendar.setTime(sdf.parse(date));
            calendar.add(time, -count);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(calendar.getTime());
    }

}
