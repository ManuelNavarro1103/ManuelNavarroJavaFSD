package com.manuelnavarro;

// multilevel inheritance
class A{
    public void test1(){
        System.out.println("A");
    }
}

class B extends  A{
    public void test2(){
        System.out.println("B");
    }
}

class C extends B{
    public void test3(){
        System.out.println("C");
    }
}

public class Demo24 {
    public static void main(String[] args) {
        C c = new C();
        c.test1();
        c.test2();
        c.test3();

        B b = new B();
        b.test1();
        b.test2();

        A a = new A();
        a.test1();
    }
}