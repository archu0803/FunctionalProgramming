package com.test.practice;

public class MethodReferences {

    public static void main(String arf[]) {
        //******No arg and exe********/
//      Thread t1= new Thread(()->printMessage());//No arg and execute param
//      t1.start();

//****method reference expressions******/
        Thread t1 = new Thread(MethodReferences::printMessage);
        t1.start();

    }

    public static void printMessage() {
        System.out.println("Hello");
    }
}
