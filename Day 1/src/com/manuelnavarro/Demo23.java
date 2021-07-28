package com.manuelnavarro;

class Parent {
    public Parent() {
        System.out.println("Parent constructor called");
    }
}

class Child extends Parent {
    public Child() {
        System.out.println("Child constructor called");
    }
}

public class Demo23 {

    public static void main(String[] args) {
        Child c = new Child();
    }
}
