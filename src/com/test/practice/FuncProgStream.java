package com.test.practice;

import java.util.List;

public class FuncProgStream {

    public static final List<Integer> INTEGERS = List.of(1, 2, 8, 9, 10, 22, 4, 6);
    public static final List<String> courses = List.of("Spring", "AWS", "React", "Docker", "Kubernetes", "Spring boot");

    public static void main(String arg[]) {
        //  printAllNumInList(INTEGERS);
        System.out.println("--Even Number--");
        printAllEvenNumInList(INTEGERS);
        System.out.println("--Old Number--");
        printAllOddNumInList(INTEGERS);
        printSpringCourses(courses);
        printSquaresOfEvenNumber(INTEGERS);//using Mapping
    }

    private static void printSquaresOfEvenNumber(List<Integer> numbers) {
        System.out.println("--Square Number--");
        numbers.stream().filter(p -> p % 2 != 0).map(p -> p * p).forEach(FuncProgStream::print);
        System.out.println("--Cubic Number--");
        numbers.stream().filter(p -> p % 2 != 0).map(p -> p * p *  p).forEach(FuncProgStream::print);
    }

    private static void printSpringCourses(List<String> courses) {
        System.out.println("--All Courses--");
        courses.stream().forEach(System.out::println);
        System.out.println("\n---Print only Spring Courses--");
        courses.stream().filter(p -> p.equalsIgnoreCase("Spring")).forEach(System.out::print);
        System.out.println("\n---Print only Spring Courses--");
        courses.stream().filter(p -> p.contains("Spring")).forEach(System.out::print);
        System.out.println("\n---Print Courses more than 4 character--");
        courses.stream().filter(p -> p.length() > 4).forEach(System.out::println);
    }

    private static void printAllEvenNumInList(List<Integer> numbers) {
        numbers.stream().filter(p -> p % 2 == 0).forEach(FuncProgStream::print);
    }

    private static void printAllOddNumInList(List<Integer> numbers) {
        numbers.stream().filter(p -> p % 2 != 0).forEach(FuncProgStream::print);
    }

    private static void printAllNumInList(List<Integer> integers) {//Lamda
        integers.stream().forEach(System.out::println);
        integers.stream().forEach(FuncProgStream::print);//Methods Reference
    }

    private static void print(Integer integer) {
        System.out.println(integer);
    }
}
