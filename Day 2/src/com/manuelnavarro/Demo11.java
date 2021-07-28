package com.manuelnavarro;

class Car{

    public final int speedLimit = 90;

    public void drive(){
        System.out.println("car is driving at speed of "+ speedLimit);
    }
}

public class Demo11 {
    public static void main(String[] args) {

        Car car = new Car();
        car.drive();

    }
}
