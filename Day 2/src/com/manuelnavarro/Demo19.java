package com.manuelnavarro;

interface IEmployee{
    void print();
    void print1();
}

class Employee2 implements IEmployee{

    @Override
    public void print() {
        System.out.println("Interface print method");
    }

    @Override
    public void print1() {
        System.out.println("Method used from interface");

    }
}

public class Demo19 {
    public static void main(String[] args) {
        Employee2 emp = new Employee2();
        emp.print();
        emp.print1();
    }
}
