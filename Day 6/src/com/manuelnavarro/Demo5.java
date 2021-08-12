package com.manuelnavarro;

class Calculator{

    public static int count = 0;

    // instance of the class
    private static Calculator instance = null;

    private Calculator(){
        count++;
        System.out.println("Count: "+ count);
        System.out.println("Constructor called");
    }

    public static Calculator getInstance(){
        if(instance == null)
            instance = new Calculator();
        return instance;
    }


}



public class Demo5 {
    public static void main(String[] args) {
//        Calculator calculator1  =new Calculator();
//        Calculator calculator2 = new Calculator();
//        Calculator calculator3 = new Calculator();

        Calculator calculator1 = Calculator.getInstance();
        Calculator calculator2 = Calculator.getInstance();
        Calculator calculator3 = Calculator.getInstance();

    }


}
