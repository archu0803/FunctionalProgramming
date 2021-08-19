package com.practice.mavenexample;

import org.apache.commons.math3.util.Precision;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrecisonFromApache {


    //1. USE apache
    private static double rounded = Precision.round(0.912385, 2, BigDecimal.ROUND_HALF_UP);
    // double rounded1 = Precision.round(0.912385, 5,  RoundingMode.HALF_UP);

    private static Double toBeTruncated = 0.912385;

    private static Double truncatedDouble = new BigDecimal(toBeTruncated).setScale(2, RoundingMode.HALF_UP).doubleValue();


    public static void main(String arg[]) {
        PrecisonFromApache sumProductEvaluation = new PrecisonFromApache();
//        try {
//            System.out.println("Round : " + sumProductEvaluation.round(0.912385, 2));
//        } catch (Exception e) {
//            System.out.println("Error Message : " + e.getLocalizedMessage());
//        }
        System.out.println("Roundapache : " + rounded);
        System.out.println("Round bigdeciMl : " + truncatedDouble);

    }

}
