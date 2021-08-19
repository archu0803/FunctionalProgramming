package com.practice.mavenexample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateTimeFormat {
    public static void main(String arg[]) {

        LocalDate date = LocalDate.now();

        LocalDate date1 = LocalDate.of(1970, 12, 1);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String text = date.format(formatters);
        LocalDate parsedDate = LocalDate.parse(text, formatters);

        System.out.println("date: " + date);
        System.out.println("Text format " + text);
        System.out.println("parsedDate: " + parsedDate.format(formatters));


        LocalDateTime ldt = LocalDateTime.of(date, LocalTime.now());
        //  LocalDateTime ldt = LocalDateTime.of (date, LocalTime.now());
//"0000-10-03 01:10:05"
//        Period period = Period.parse ( "P10M3D" );
//        Duration duration = Duration.parse ( "PT1H10M5S" );
        Period p = Period.between(date, date1);
        LocalDate result = date1.plus(p);
        System.out.println("result: " + result);

        //Using old Date

        List<LocalDate> localDates = new ArrayList<LocalDate>();
        localDates.add(date);
        localDates.add(date1);
        System.out.println("date: " + date);
        System.out.println("Add date1: " + date1);


        date.plusDays(date1.getDayOfMonth()).plusMonths(date1.getMonthValue()).plusYears(date1.getYear());
        System.out.println("new Day: " + sum(date1.getDayOfMonth(), date.getDayOfMonth()));
        System.out.println("new Month: " + sum(date1.getMonthValue(), date.getMonthValue()));
        System.out.println("new Year: " + sum(date1.getYear(), date.getYear()));

    }

    private static int sum(int i, int j) {
        return i + j;
    }

    private static LocalDate addLocalDate(LocalDate date, LocalDate date1) {
        return date.plusDays(date1.getDayOfMonth()).plusMonths(date1.getMonthValue()).plusYears(date1.getYear());

    }
}
