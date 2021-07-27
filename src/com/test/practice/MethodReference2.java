package com.test.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReference2 {

    public static void main(String arg[]) {
        List<Person> list = Arrays.asList(
                new Person("arc", "Gan", 34),
                new Person("prabhu", "Chi", 37),
                new Person("Kushi", "Yad", 8));
        // sort(list);
//Lamda way
        Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        System.out.println("Print All " + list);
//        printConditionallyConsumer(list,p->p.getFirstName().toUpperCase().startsWith("A"),
//                p->System.out.println("Names = "+p.getFirstName().toUpperCase()+" : "+p.getLastName().toUpperCase()));
//
        printConditionallyConsumer(list, p -> p.getFirstName().toUpperCase().startsWith("A"),
                System.out::println);//P->method(p);
    }

    private static void printConditionallyConsumer(List<Person> personList, Predicate<Person> predicate,
                                                   Consumer<Person> condition2)
    {
        for (Person person :personList) {
            if (predicate.test(person)){
                condition2.accept(person);
            }
        }

    }
}
