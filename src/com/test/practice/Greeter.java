package com.test.practice;

public class Greeter {
    public void greet(){// take i/p and do some thing here
        System.out.println("Hello world ");
    }

    public void greet(Greeting greeting){// Java 7 way of taking i/p and do some thing
       // greeting.perform();
    }



    public static void  main(String arg[]){
        Greeter greet = new Greeter();
        greet.greet();

 }
}
