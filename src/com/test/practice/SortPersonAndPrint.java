package com.test.practice;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SortPersonAndPrint {
    public static void main(String arg[]) {
        List<Person> list = Arrays.asList(
                new Person("arc", "Gan", 34),
                new Person("prabhu", "Chi", 37),
                new Person("Kushi", "Yad", 8));
       // sort(list);
//Lamda way
        Collections.sort(list, (p1,p2)-> p1.getLastName().compareTo(p2.getLastName()));
        System.out.println("Print "+list);
        printConditionallyConsumer(list,p->p.getFirstName().toUpperCase().startsWith("A"),
                p->System.out.println("Names = "+p.getFirstName().toUpperCase()+" : "+p.getLastName().toUpperCase()));
    }

    //Step 1: sort list by last name
    //Step2: create a method that prints all element in the list
    //Step3: Create a method that printlns all people that have last name begining with C
    private static void sort(List<Person> p) {
        Collections.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        print(p);
        printLastNameC(p);
    }

    private static void print(List<Person> printList) {
        for (Person p : printList) {
            System.out.println(p + "\n");
        }
    }

    private static void printLastNameC(List<Person> printList) {
        for (Person p : printList) {
            if (p.getLastName().startsWith("C")) {
                System.out.println(p + "\n");
            }
        }
    }
    private static void printConditionally(List<Person> personList, Predicate<Person> condition)
    {
        for (Person person :personList) {
            if(condition.test(person)){
                System.out.println("\n Print matches"+person);
            }
        }

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
