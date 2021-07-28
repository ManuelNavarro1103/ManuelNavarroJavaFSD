package com.manuelnavarro;

class Car {
    public String name;
    public String color;
    public int price;
    public String engineType;

    public Car(String name, String color, int price, String engineType) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.engineType = engineType;

    }

    public Car(Car car) {
        this.name = car.name;
        this.color = car.color;
        this.price = car.price;
        this.engineType = car.engineType;

    }

    public Car(Car car, int price) {
        this.name = car.name;
        this.color = car.color;
        this.price = car.price;
        this.engineType = car.engineType;
    }
}

public class Demo21 {

    public static void main(String[] args) {
        Car car = new Car("Audi", "White", 10000, "Petrol");
        Car car1 = new Car(car);
        Car car2 = new Car(car, 20000);
    }
}
