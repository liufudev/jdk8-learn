package org.lf.communication;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateDemo {

    public static void main(String[] args) {
        Date date = new Date();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        System.out.println(localTime.plusMinutes(60));
        System.out.println(Date.from(localTime.atZone(zone).toInstant()));
    }
}
