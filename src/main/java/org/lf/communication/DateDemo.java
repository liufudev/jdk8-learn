package org.lf.communication;

import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 可以使用Instant代替Date，
 *
 * LocalDateTime代替Calendar，
 *
 * DateTimeFormatter代替SimpleDateFormat，
 *
 * 官方给出的解释：simple beautiful strong immutable thread-safe。
 */
public class DateDemo {

    @Test
    public void clock() {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
    }

    /**
     * 年月日
     */
    @Test
    public void localDate() {
        final LocalDate date = LocalDate.now();
        System.out.println(date.getDayOfYear());
        System.out.println(date.isLeapYear());
        System.out.println(date.getMonth());
        System.out.println(date.getMonth().getValue());
    }

    /**
     * 时分秒
     */
    @Test
    public void localTime() {
        final LocalTime time = LocalTime.now();
        time.plusMinutes(10);
        System.out.println(time);
    }

    /**
     * localDate和localTime的并集
     */
    @Test
    public void localDateTime() {
        final LocalDateTime datetime = LocalDateTime.now();
        datetime.plusDays(10);
        System.out.println(datetime);
    }

    @Test
    public void dateConvert() {
        Date date = new Date();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        System.out.println(localTime.plusMinutes(60));
        System.out.println(Date.from(localTime.atZone(zone).toInstant()));
        System.out.println(LocalDate.now().getYear());
        System.out.println(LocalDate.now().getMonth().getValue());
    }


    @Test
    public void duration() {
        final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);
        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
    }

    @Test
    public void dateTimeFormatter() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTimeStr = now.format(formatter);
        System.out.println("After : " + formatDateTimeStr);

        String nowStr = "2019-11-09 10:30:00";
        LocalDateTime formatDateTime = LocalDateTime.parse(nowStr, formatter);
        System.out.println("After : " + formatDateTime.format(formatter));
    }
}
