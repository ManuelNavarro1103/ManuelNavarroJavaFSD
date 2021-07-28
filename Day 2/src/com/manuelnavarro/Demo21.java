package com.manuelnavarro;

//interface I1{
//    void print();
//}
//
//interface I2 extends I1{
//    void display();
//}
//
//class Test5 implements I2{
//
//    @Override
//    public void print() {
//
//    }
//
//    @Override
//    public void display() {
//
//    }
//}

interface I1{
    void print();
}

interface I2{
    void display();
}

class Test5 implements I1, I2 {

    @Override
    public void print() {
        System.out.println("From interface");
    }

    @Override
    public void display() {
        System.out.println("From interface");
    }
}



public class Demo21 {
    public static void main(String[] args) {

        Test5 test5 = new Test5();
        test5.display();
        test5.print();

    }
}
