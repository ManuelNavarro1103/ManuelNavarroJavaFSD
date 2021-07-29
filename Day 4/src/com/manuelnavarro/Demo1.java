package com.manuelnavarro;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo1 {

    public static void main(String[] args) {

        ArrayList<String> myList = new ArrayList<>();

        myList.add("Manuel");
        myList.add("Sara");
        myList.add("Leah");

        System.out.println(myList);

        Iterator iterator = myList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String names: myList) {
            System.out.println(names);
        }
    }
}
