package com.manuelnavarro;

import java.util.HashSet;
import java.util.Iterator;

public class Demo9 {
    public static void main(String[] args) {
        // create HashSet and add elements
        HashSet<String> set = new HashSet<>();
        set.add("Manuel");
        set.add("Sara");
        set.add("Leah");
        set.add("Myron");
        set.add(null);
        set.add(null);
        set.add(null);
        set.add(null);
        set.add("Manuel");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // remove()
        set.remove("Myron");
        System.out.println(set);

        // removeAll()
        // removeIf()
        // clear()

    }
}
