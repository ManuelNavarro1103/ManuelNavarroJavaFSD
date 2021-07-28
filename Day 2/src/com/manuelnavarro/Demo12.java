package com.manuelnavarro;

class Bike{
    public final void drive(){
        System.out.println("driving...");
    }
}

class Honda extends Bike{

    //CANNOT OVERRIDE A FINAL METHOD
//    public void drive(){
//        System.out.println("driving...");
//    }
}



public class Demo12 {
    public static void main(String[] args) {

    }
}
