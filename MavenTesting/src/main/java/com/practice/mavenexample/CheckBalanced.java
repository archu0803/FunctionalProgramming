package com.practice.mavenexample;

public class CheckBalanced {

    public static void main(String arg[]) {
        String a1 = "()()()()";
        checkBalanced(a1);
    }

    private static void checkBalanced(String a1) {
        int a = 0;
        int b = 0;
        boolean notBalanced = false;
        for (int i = 0; i < a1.length(); i++) {
            if (a1.charAt(i) == '(') {
                a++;
            } else if (a1.charAt(i) == ')') {
                if (i % 2 == 0) {
                    notBalanced = true;
                }
                b++;
            }
            if (a == b && !notBalanced) {
                System.out.println(" Balanced:  openBracket = openBracket =" + a + ", ClosedBracket =" + b);
            } else {
                System.out.println(" Not Balanced:  openBracket =" + a + ", ClosedBracket =" + b);
            }
        }
    }

    private boolean isEven(int c) {
        return c % 2 == 0;
    }
}
