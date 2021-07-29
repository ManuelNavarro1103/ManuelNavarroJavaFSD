package com.manuelnavarro;

import java.util.ArrayList;
import java.util.Collections;

public class Demo2 {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Manuel");
        names.add("Sara");
        names.add("Leah");

        System.out.println(names.get(0) + names.get(1) + names.get(2));

        names.set(1, "Sara Cavazos");
        for (String name: names) {
            System.out.println(name);
        }
    }
}
