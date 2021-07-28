package com.test.practice;

import java.util.List;

public class FuncProgReduce {


    public static final List<Integer> NUMBERS = List.of(1, 2, 8, 9, 10, 22, 4, 6);
    public static final List<String> courses = List.of("Spring", "AWS", "React", "Docker", "Kubernetes", "Spring boot");

    public static void main(String arg[]) {
        int sum=addListFunction(NUMBERS);
    }

    private static int addListFunction(List<Integer> numbers) {
       return numbers.stream().reduce(0, FuncProgReduce::sum);
    }

    private static int sum(int a, int b) {
        return a+b;
    }
}
