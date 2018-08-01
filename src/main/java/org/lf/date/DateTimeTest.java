package org.lf.date;

import java.time.LocalTime;

public class DateTimeTest {

    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time.getSecond());
    }
}
