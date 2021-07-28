package com.manuelnavarro;

class Parent1 {

    public void display() {
        System.out.println("Parent display");
    }
}

class Child1 extends Parent1 {

    public void display() {
        System.out.println("Child display");
    }
}

public class Demo26 {

    public static void main(String[] args) {
        Child1 child = new Child1();
        child.display();

        Parent1 parent1 = new Parent1();
        parent1.display();

    }
}
