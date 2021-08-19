package com.practice.mavenexample;

import org.joda.time.Days;

import static org.junit.Assert.assertEquals;

public class DateTimeDifferenceInJoda {

    public static void main(String arg[]) {
        //givenTwoDatesInJodaTime_whenDifferentiating_thenWeGetSix() {
        org.joda.time.LocalDate now = org.joda.time.LocalDate.now();
        org.joda.time.LocalDate sixDaysBehind = now.minusDays(6);


        long diff = Math.abs(Days.daysBetween(now, sixDaysBehind).getDays());
        assertEquals(6, diff);
        System.out.println("Diff = " + diff);
    }
}
