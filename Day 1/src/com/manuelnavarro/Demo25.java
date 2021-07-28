package com.manuelnavarro;

class X {
    public void test1() {
        System.out.println("X");
    }
}

class Y extends X {
    public void test2() {
        System.out.println("Y");
    }
}

class Z extends X {
    public void test3() {
        System.out.println("Z");
    }
}

public class Demo25 {

    public static void main(String[] args) {
        X x = new X();
        x.test1();

        Y y = new Y();
        y.test1();
        y.test2();

        Z z = new Z();
        z.test1();
        z.test3();
    }
}
