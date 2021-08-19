package com.test.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FloatingPointPrecision {

    private static final int EXCEL_MAX_DIGITS = 17;


    private static double fixFloatingPointPrecision(double value) {
        BigDecimal original = new BigDecimal(value);
        BigDecimal fixed = new BigDecimal(original.unscaledValue(), original.precision())
                .setScale(EXCEL_MAX_DIGITS, RoundingMode.HALF_UP);
        int newScale = original.scale() - original.precision() + EXCEL_MAX_DIGITS;
        return new BigDecimal(fixed.unscaledValue(), newScale).doubleValue();
    }

    // double rounded = Precision.round(0.912385, 5, BigDecimal.ROUND_HALF_UP);

    public static void main(String arg[]) {
        FloatingPointPrecision floatingPointPrecision = new FloatingPointPrecision();
        System.out.println(floatingPointPrecision.fixFloatingPointPrecision(-130.98903999999565323));
        System.out.println(floatingPointPrecision.fixFloatingPointPrecision(130.9899999945494444444234299068677425384521484375));
    }
}
