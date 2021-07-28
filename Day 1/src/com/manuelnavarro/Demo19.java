package com.manuelnavarro;

class Test {

    int counter;

    public Test(int counter) {
        this.counter = counter;
        System.out.println(this.counter);
    }
}

public class Demo19 {

    public static void main(String[] args) {
        Test test = new Test(100);
    }
}
