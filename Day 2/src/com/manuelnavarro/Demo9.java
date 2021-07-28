package com.manuelnavarro;

class Parent{
    public void greeting(String name){
        System.out.println("Welcome "+ name);
    }
}

class Child extends Parent{
    public void greeting(String name){
        System.out.println("Hello "+ name);
    }
}


public class Demo9 {
    public static void main(String[] args) {
        Child child = new Child();
        child.greeting("Manuel");
        Parent parent = new Parent();
        parent.greeting("Manuel");
    }
}
