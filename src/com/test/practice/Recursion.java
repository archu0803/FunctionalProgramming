package com.test.practice;

public class Recursion {
    public static void main(String arg[]) {
        countDown(10);
    }

    private static void countDown(int num) {
        if (num == 0) {
            System.out.println("Off " + num);
        } else {
            System.out.println("Print" + num);
            countDown(num - 1);
        }

    }
}
