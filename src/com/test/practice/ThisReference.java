package com.test.practice;

public class ThisReference {
    public void doProcess(int i, ClosuresExample.Process p) {
        p.process(i);
    }

    public void execute() {
        doProcess(10, i -> {
            System.out.println("Value :" + i);
            System.out.println(this);//This will point to
            // the calling instance
        });
    }

    public static void main(String arg[]) {

        ThisReference thisReferencen = new ThisReference();
        thisReferencen.doProcess(10, new ClosuresExample.Process() {
            @Override
            public void process(int i) {
                System.out.println("Valiue of :" + i);
                System.out.println(this);
            }
        });


//Lamda way
//        thisReferencen.doProcess(10, i -> {
//                    System.out.println("Value :" + i);
//                 //   System.out.println(this);//This will not work
//
//                }
//        );
        thisReferencen.execute();

    }

    @Override
    public String toString() {
        return "this is the main this referefbce class instance";
    }
}
