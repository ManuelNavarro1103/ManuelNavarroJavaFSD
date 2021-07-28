package com.manuelnavarro;

interface X{
    void print();
    interface Y{
        void display();
    }
}

class Z implements X, X.Y{

    @Override
    public void print() {

    }

    @Override
    public void display() {

    }
}

public class Demo24 {
    public static void main(String[] args) {

        //methods implemented from interface and nested interface
        Z z = new Z();
        z.display();
        z.print();

    }
}
