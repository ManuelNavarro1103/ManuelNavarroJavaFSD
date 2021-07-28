package com.manuelnavarro;

class A1{
    public final void test(){
        System.out.println("A1 : test");
    }
}

class B1 extends A1{
    public void test2(){
        test();
    }
}


public class Demo14 {
    public static void main(String[] args) {
//        A1 a1 = new A1();
//        a1.test();

        B1 b1 = new B1();
        b1.test2();
    }
}
