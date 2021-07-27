package com.test.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionIterationExample {

    public static void main(String arg[]) {
        List<Person> list = Arrays.asList(
                new Person("arc", "Gan", 34),
                new Person("prabhu", "Chi", 37),
                new Person("Kushi", "Yad", 8));

        System.out.println("Uses For Loop ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Uses ForEach Loop ");
        for (Person p : list) {
            System.out.println(p);
        }
        System.out.println("Using Lamda  ForEach Loop ");
        //list.forEach(p -> System.out.println("Lamda" + p));
        list.forEach(System.out::println);
    }
    }
