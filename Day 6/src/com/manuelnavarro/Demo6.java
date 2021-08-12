package com.manuelnavarro;

interface ICar {
    void getCarModel();

    void getCarColor();
}

class Audi implements ICar {

    @Override
    public void getCarModel() {
        System.out.println("Audi A6");
    }

    @Override
    public void getCarColor() {
        System.out.println("Black");
    }
}

class Bmw implements ICar {

    @Override
    public void getCarModel() {
        System.out.println("5 Series");
    }

    @Override
    public void getCarColor() {
        System.out.println("White");
    }
}

class CarFactory {
    public static ICar getCarInstance(int id) {
        switch (id) {
            case 1:
                return new Audi();

            case 2:
                return new Bmw();
            default:
                return null;
        }
    }
}


public class Demo6 {
    public static void main(String[] args) {
//        Audi car1 = new Audi();
//        car1.getCarModel();
//        car1.getCarColor();
//
//        Bmw car2 = new Bmw();
//        car2.getCarModel();
//        car2.getCarColor();

        ICar car1 = CarFactory.getCarInstance(1);
        car1.getCarModel();
        car1.getCarColor();
    }
}
