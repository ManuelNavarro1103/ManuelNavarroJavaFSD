package com.manuelnavarro;


class Employee1{

}

interface DB{
    void connection();
    interface MySQL{

    }

    interface MongoDB{

    }
}

class MyApp implements DB.MongoDB{



}
public class Demo27 {

    public static void main(String[] args) {

        MyApp myApp = new MyApp();
    }

}
