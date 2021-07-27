package com.test.practice;

public class ClosuresExample {
    public static void main(String[] str) {
        int a = 10;
        int b = 20;

        //In Java 8, the variable is always final
//    doProcess(0, new Process() {
//        @Override
//        public void process(int i) {
//            System.out.println("value"+a+b);
//        }
//    });


        //Chnage abv to Lamda
       // doProcess(0, i -> System.out.println("value by closure" + a + b));
        doProcess(0, i -> System.out.println("value by closure" + a + b));//*** Always b's value is 20

    }
    public static void doProcess(int i, Process p) {
        p.process(i);
    }

    interface Process {
        void process(int i);
    }
}
