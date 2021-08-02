package com.test.practice;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAllMthdExp {

    private static List<Integer> numbers = List.of(1, 12, 3, 45, 6, 8);

    private static List<String> strLists = List.of("Azure", "AWS", "REACT", "Python", "Spring Boot", "Docker");

    public static void main(String arg[]) {
        // List<Integer> numbers = List.of(1, 12, 3, 45, 6, 8);
        List<Integer> doubleList = squareList();
        numbers.stream().forEach(System.out::println);
        numbers.stream().forEach(StreamAllMthdExp::primeNumber);//Method Reference
        numbers.stream()
                .filter(number -> number % 2 == 0)//Lamda
                .forEach(System.out::println);

        numbers.stream()
                .filter(StreamAllMthdExp::isEven)//Lamda
                .forEach(System.out::println);

        numbers.stream()
                .filter(StreamAllMthdExp::isEven)//Lamda
                .map(number -> number * number)
                .forEach(System.out::println);

        System.out.println(getSum(numbers));

        //Using Lamda Predefined function
        Predicate<? super Integer> isEvenPredicate = x -> x % 2 == 0;

        Predicate<? super Integer> isEvenPredicate2 = new Predicate<Integer>() {// The above code is excuted like this in back of the scene
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        Function<Integer, Integer> squareFuction = x -> x % x; //Lamda
        Consumer<Integer> sysIntOut = System.out::println; // Integer o/p
        Consumer<String> sysStrPut = System.out::println;//String O/p

        numbers.stream().filter(isEvenPredicate).map(squareFuction).forEach(sysIntOut);

        System.out.println("sum");
        numbers.stream().map(x -> x * x).reduce(0, Integer::sum);// o/p in jshell

        System.out.println("distinct");
        numbers.stream().distinct().forEach(sysIntOut);

        System.out.println("sorted");
        numbers.stream().sorted().forEach(sysIntOut);

        System.out.println("Distinct sorted");
        numbers.stream().distinct().sorted().forEach(sysIntOut);// no duplicate
        numbers.stream().distinct().sorted(Comparator.naturalOrder()).forEach(sysIntOut);// Natural order

        System.out.println("Reverse order");
        numbers.stream().distinct().sorted(Comparator.reverseOrder()).forEach(sysIntOut);// Natural order
        strLists.stream().distinct().sorted(Comparator.reverseOrder()).forEach(sysStrPut);// Natural order

        System.out.println("String Sorting");
        strLists.stream().distinct().sorted(Comparator.comparing(str -> str.length())).forEach(sysStrPut);// String ordered by the length of the string

        //creating another list
        List<Integer> doubledNumbers = doubleList(numbers);
        System.out.println("doubledNumbers" + doubledNumbers);
        //  List<Integer> si =doubleList(numbers);
        List<Integer> eveNumbers = evenList(numbers);
        System.out.println("eveNumbers" + doubledNumbers); //not displaying EVEN// TODO:AG check

    }

    private static List<Integer> evenList(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }

    private static List<Integer> doubleList(List<Integer> numbers) {

        return numbers.stream().map(x -> x * x).collect(Collectors.toList());
    }

    private static List<Integer> squareList() {
        // collect all the result intp the list using collect method
        return numbers.stream().map(number -> number * number).collect(Collectors.toList());

    }

    private static int getSum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, StreamAllMthdExp::sum);//Lamda
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static boolean isEven(Integer i) {
        if (i % 2 == 0) {
            System.out.println("prime I=" + i);
            return true;
        }
        return false;
    }

    private static void primeNumber(Integer i) {
        if (i % 2 == 0) {
            System.out.println("prime I=" + i);
        }


    }
}
