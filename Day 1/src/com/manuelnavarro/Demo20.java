package com.manuelnavarro;

class Calculator {

    int a = 10;
    int b = 20;

    public Calculator() {
        System.out.println("Parameter less constructor");
    }

    public Calculator(int x, int y) {
        this.a = x;
        this.b = y;
    }

    public void addNumbers() {
        System.out.println(a + b);
    }
}

public class Demo20 {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addNumbers();

        Calculator calculator1 = new Calculator(100, 200);
        calculator1.addNumbers();
    }
}
