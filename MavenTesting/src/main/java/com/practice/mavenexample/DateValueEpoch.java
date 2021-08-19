package com.practice.mavenexample;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateValueEpoch {

    public static void main(String arg[]) {

        DateValueEpoch dateValueEpoch = new DateValueEpoch();

        dateValueEpoch.printValue();


//        Scanner scanner =   new Scanner(System.in);
//        if(scanner.hasNext()){
//            printValue(scanner.nextBigDecimal());
//        }

    }

    private static void printValue(BigDecimal countFromEpoch) {
        final LocalDate EXCEL_EPOCH_REFERENCE = getLocalDate();

        long days = countFromEpoch.longValue();  // Extract the number of whole days, dropping the fraction.
        LocalDate localDate = EXCEL_EPOCH_REFERENCE.plusDays(days);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/DD/YYYY");
        String text = localDate.format(formatters);

        System.out.println("local Date Text to Date conversion : " + text);
    }

    private static LocalDate getLocalDate() {
        return LocalDate.of(1899, Month.DECEMBER, 30);
    }

    private void printValue() {

        final LocalDate EXCEL_EPOCH_REFERENCE = getLocalDate();

        BigDecimal countFromEpoch0 = new BigDecimal("43866");

        BigDecimal countFromEpoch1 = new BigDecimal("40729");//1900 date system
        BigDecimal countFromEpoch2 = new BigDecimal("39267");// 1904 date system

        long days = countFromEpoch0.longValue();  // Extract the number of whole days, dropping the fraction.
        LocalDate localDate = EXCEL_EPOCH_REFERENCE.plusDays(days);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String text = localDate.format(formatters);
        System.out.println("local Date Text to Date conversion : " + text);

        LocalDate localDate1 = EXCEL_EPOCH_REFERENCE.plusDays(countFromEpoch1.longValue());

        System.out.println("1900 date system default date : " + localDate1.format(formatters));
        //LocalDate localDate1 = EXCEL_EPOCH_REFERENCE.plusDays( countFromEpoch1.longValue() );
        System.out.println("1904 date system default date : " + localDate.format(formatters));

    }


}
