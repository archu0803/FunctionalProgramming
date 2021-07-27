package com.test.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lamdasort {

    public static void main(String arg[]) {
        List<String> names = Arrays.asList("zarc", "prabhu", "Kushi");
        //Sortin b4 java8
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(names);

        // Using Lamda Notation
        //    Collections.sort(names, (a,b)-> a.campareTo(b));

        //  Book Collection

        Book book1 = new Book("Harry Potter", "JK", "Rowling", 411);
        Book book2 = new Book("Magic Tree House", "Unknown", "Unknown", 122);
        Book book3 = new Book("The Cat in the Hat", "Dr", "Suess", 45);

        //use .collect for aggregate
        List<Book> books = Arrays.asList(book1, book2, book3);
        int total =books.stream().collect(Collectors.summingInt(Book::getPages));
        System.out.println("total :"+total);

        //Using Lamda
//        @FunctionalInterface
//         interface Lamda{
//            int compare(String a, String b);
//
//        }
    }
}
