package com.practice.mavenexample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateValueText {

    public static void main(String arg[]) {
        DateValueText dateValueText = new DateValueText();
        try {
            dateValueText.printValue();
        } catch (Exception e) {
            System.out.println("Error Message : " + e.getLocalizedMessage());
        }
    }

    private void printValue() {

        SerialToDate sd = new SerialToDate(43866);
        LocalDateTime dt = LocalDateTime.of(
                LocalDate.ofEpochDay(sd.toEpochDays()),
                LocalTime.ofSecondOfDay(sd.toDaySeconds()));
        System.out.println("PrintDate " + dt);//prints 1991-01-19T09:59

    }

    private class SerialToDate {

        //days from 1899-12-31 to Instant.EPOCH (1970-01-01T00:00:00Z)
        public static final long EPOCH = -25568L;


        private long serialDays;
        private double serialTime;
        private long epochDays;
        private long daySeconds;

        /**
         * @param date number of Excel-days since <i>January 0, 1899</i>
         */
        public SerialToDate(long date) {
            serialDays = date;
            if (date > 59)//Lotus123 bug
                --date;
            epochDays = EPOCH + date;
        }

        /**
         * @param date number of days since <i>January 0, 1899</i> with a time fraction
         */
        public SerialToDate(double date) {
            this((long) date);
            serialTime = date - serialDays;
            daySeconds = Math.round(serialTime * 24 * 60 * 60);

        }

        /**
         * @return days since 1970-01-01
         */
        public long toEpochDays() {
            return epochDays;
        }

        /**
         * @return seconds of the day for this SerialDate
         */
        public long toDaySeconds() {
            return daySeconds;
        }

        /**
         * @return a value suitable for an Excel date
         */
        public double getSerialDate() {
            return serialTime + serialDays;
        }
    }

}
