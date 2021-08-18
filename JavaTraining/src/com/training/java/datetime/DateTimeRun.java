package com.training.java.datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeRun {

    public static void main(final String[] args) {
        // Old
        Date dateLoc = new Date();
        GregorianCalendar calendarLoc = new GregorianCalendar();

        SimpleDateFormat dateFormatLoc = new SimpleDateFormat("yyyyMMdd");

        long currentTimeMillisLoc = System.currentTimeMillis();


        // New
        LocalDate date2Loc = LocalDate.now();
        date2Loc.minusDays(2);
        date2Loc.minusYears(2);

        LocalDateTime dateTimeLoc = LocalDateTime.now();
        LocalDateTime withMinuteLoc = dateTimeLoc.plusDays(5)
                                                 .withHour(10)
                                                 .withMinute(10);

        ZonedDateTime dateTime2Loc = ZonedDateTime.now();

        DateTimeFormatter dateTimeFormatterLoc = DateTimeFormatter.ofPattern("yyyyMMdd");
    }
}
