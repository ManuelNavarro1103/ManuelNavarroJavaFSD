package com.manuelnavarro;

import java.util.ArrayList;

public class Demo6 {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Manuel");
        names.add("Sara");
        names.add("Leah");
        names.add("Myron");
        System.out.println(names);

        // getting element on a specified index
        System.out.println(names.get(3));
        System.out.println(names.get(0));

        // adding the element on a specific index
        names.add(1, "John");
        names.add(1, "Sasha");
        names.add(1, "Daniel");
        System.out.println(names);

        // merge two list
        ArrayList<String> newNames = new ArrayList<>();
        newNames.add("Rangel");
        newNames.add("Smith");
        //names.addAll(newNames);

        // adding second list element to the specified position
        names.addAll(0, newNames);

        System.out.println(names);

        //remove
        names.remove("Manuel");
        System.out.println(names);

        // remote
        names.remove(0);
        System.out.println(names);

        names.removeAll(newNames);
        System.out.println(names);

        // removing an element based on condition
        names.removeIf(name -> name.contains("Sara"));
        System.out.println(names);
    }
}
