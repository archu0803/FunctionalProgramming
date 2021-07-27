package com.test.practice;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String arg[]) {
        List<Person> list = Arrays.asList(
                new Person("arc", "Gan", 34),
                new Person("prabhu", "Chi", 37),
                new Person("Kushi", "Yad", 8));

        long count = list.stream().filter(p -> p.getLastName().startsWith("C")).count();
        System.out.println(count);
        //terminal excution
          list.stream().filter(p->p.getLastName().startsWith("C"))
           .forEach(p->System.out.println(p.getFirstName()+":"+p.getAge()+"\n"));


    }
}
