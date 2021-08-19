package com.test.practice;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamBehavParameterization {

    private static List<Integer> numbers = List.of(1, 12, 3, 45, 6, 8);

    private static List<String> strLists = List.of("Azure", "AWS", "REACT", "Python", "Spring Boot", "Docker");
    private static Consumer<Integer> sysOut = System.out::println;

    public static void main(String arg[]) {
        List<Integer> numbers = List.of(1, 12, 3, 45, 6, 8);
        Predicate<Integer> evenPredicate = X -> X % 2 == 0;
        // filterAndPrint(numbers, evenPredicate); //works as well
        filterAndPrint(numbers, X -> X % 2 == 0); //passing the code as  parameter
        System.out.println("");
        filterAndPrint(numbers, X -> X % 3 == 0); //passing the code as  parameter

    }

    public static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
        numbers.stream().filter(predicate).forEach(sysOut);
    }
}
