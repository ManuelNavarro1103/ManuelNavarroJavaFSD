package com.manuelnavarro;

import java.util.ArrayList;
import java.util.ListIterator;

public class Demo4 {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Manuel");
        names.add("Sara");
        names.add("leah");

        for (int i=0; i<names.size(); i++) {
            System.out.println(names.get(i));
        }

        names.forEach(name -> {
            System.out.println(name);
        });
    }
}
