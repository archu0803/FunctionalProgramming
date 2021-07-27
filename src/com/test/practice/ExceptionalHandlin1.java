package com.test.practice;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ExceptionalHandlin1 {
    public static void main(String arg[]) {
        int[] someNumber = {1, 2, 3, 4};
        int key = 0;
         process(someNumber, key);

        processingInLamda(someNumber, key, (v, k) -> System.out.println(v / k));//Single line Lamda expressiom
        processingInLamda(someNumber, key, (v, k) -> {
            try {
                System.out.println(v/k);
            } catch (ArithmeticException e) {
                System.out.println(" An Arithmetic Exception" + e.getMessage());
            }
        });//Multiline line Lamda expression
    }



    private static void process(int[] someNumber, int key) {
        for (int k : someNumber) {
            System.out.println(k + key);

        }
    }

    //Lamda way  of doing  1. Add the Biconsumer and pass the param and run the SOP
    private static void processingInLamda(int[] someNumber, int key, BiConsumer<Integer, Integer> consumer) {

            for (int k : someNumber) {
                consumer.accept(k, key);
            }

    }

    //wrap lamda in another lamda
    private static BiConsumer<Integer, Integer>  wrapperLamda(BiConsumer<Integer,Integer> consumer){
        return consumer;


    }
}

