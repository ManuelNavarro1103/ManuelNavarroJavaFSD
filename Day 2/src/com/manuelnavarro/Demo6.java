package com.manuelnavarro;

class A{
    static int a;

    static {
        a = 20;
        System.out.println(a +" Printed from static block");
    }
}


public class Demo6 {
    public static void main(String[] args) {
        A a1 = new A();
    }
}
