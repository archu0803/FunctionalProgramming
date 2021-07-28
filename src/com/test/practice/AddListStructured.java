package com.test.practice;

import java.util.List;

public class AddListStructured {

    public static void main(String[] str) {

        List<Integer> numbers = List.of(12, 9, 4, 5, 6, 9);

        int sum = addListStructured(numbers);

        System.out.println(sum);

    }

    private static int addListStructured(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int sum(int aggregate, int nextNumver) {
        return aggregate + nextNumver;
    }

    private static int addListStructured1(List<Integer> numbers) {
    //    return numbers.stream().reduce(0,AddListStructured::sum);
    //  return  numbers.stream().reduce(Integer.MAX_VALUE,Integer::sum);
      return  numbers.stream().reduce(Integer.MAX_VALUE,(x,y)->x+y);
    }
}
