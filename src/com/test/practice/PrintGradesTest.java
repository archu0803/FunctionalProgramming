package com.test.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrintGradesTest {

    @Test
    void printTest() {
        PrintGrades printGrades= new PrintGrades();
        String result= printGrades.print(90);
        assertEquals("B",result);
    }
}