package com.manuelnavarro;

import java.util.TreeSet;

public class Demo12 {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(23);
        set.add(67);
        set.add(4567);
        set.add(9);

        for (int number: set) {
            System.out.println(number);
        }

        System.out.println("Highest: "+set.pollLast());
        System.out.println("Lowest: "+set.pollFirst());
    }
}
