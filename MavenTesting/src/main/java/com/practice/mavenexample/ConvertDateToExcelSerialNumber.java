package com.practice.mavenexample;

public class ConvertDateToExcelSerialNumber {

    public static final int SECONDS_PER_MINUTE = 60;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int HOURS_PER_DAY = 24;
    public static final int SECONDS_PER_DAY = (HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
    public static final long DAY_MILLISECONDS = SECONDS_PER_DAY * 1000L;
    // used to specify that date is invalid
    private static final int BAD_LOCALDATE = -1;

    private static double getExcelSerialNumber(int year, int dayOfYear, int hour, int minute, int second, int milliSecond, boolean use1904windowing) {
        if ((!use1904windowing && year < 1900) ||
                (use1904windowing && year < 1904)) {
            return BAD_LOCALDATE;
        }


        // Because of daylight time saving we cannot use
        //     date.getTime() - calStart.getTimeInMillis()
        // as the difference in milliseconds between 00:00 and 04:00
        // can be 3, 4 or 5 hours but Excel expects it to always
        // be 4 hours.
        // E.g. 2004-03-28 04:00 CEST - 2004-03-28 00:00 CET is 3 hours
        // and 2004-10-31 04:00 CET - 2004-10-31 00:00 CEST is 5 hours
        double fraction = (((hour * 60.0
                + minute
        ) * 60.0 + second
        ) * 1000.0 + milliSecond
        ) / DAY_MILLISECONDS;

        double value = fraction + absoluteDay(year, dayOfYear, use1904windowing);

        if (!use1904windowing && value >= 60) {
            value++;
        } else if (use1904windowing) {
            value--;
        }

        return value;
    }


    /**
     * Given a year and day of year,
     * return the number of days since 1900/12/31.
     *
     * @param dayOfYear the day of the year
     * @param year      the year
     * @return days number of days since 1900/12/31
     * @throws IllegalArgumentException if date is invalid
     */
    private static int absoluteDay(int year, int dayOfYear, boolean use1904windowing) {
        return dayOfYear + daysInPriorYears(year, use1904windowing);
    }


    /**
     * Return the number of days in prior years since 1900
     *
     * @param yr               a year (1900 < yr < 4000)
     * @param use1904windowing
     * @return days  number of days in years prior to yr.
     * @throws IllegalArgumentException if year is outside of range.
     */

    static int daysInPriorYears(int yr, boolean use1904windowing) {
        if ((!use1904windowing && yr < 1900) || (use1904windowing && yr < 1904)) {
            throw new IllegalArgumentException("'year' must be 1900 or greater");
        }

        int yr1 = yr - 1;
        int leapDays = yr1 / 4   // plus julian leap days in prior years
                - yr1 / 100 // minus prior century years
                + yr1 / 400 // plus years divisible by 400
                - 460;      // leap days in previous 1900 years

        return 365 * (yr - (use1904windowing ? 1904 : 1900)) + leapDays;
    }

}
