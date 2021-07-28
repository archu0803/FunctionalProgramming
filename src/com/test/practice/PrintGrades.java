package com.test.practice;

public class PrintGrades {
    public String print(int grade){
        if(grade>91){
            return "A+";
        }else if(grade>83){
            return "B";
        }else if(grade>73){
            return "C";
        }else{
            return "Study more";
        }
    }
}
