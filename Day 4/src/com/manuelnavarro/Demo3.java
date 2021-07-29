package com.manuelnavarro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Demo3 {

    public static void main(String[] args) {

        ArrayList<String> colors = new ArrayList<>();
        colors.add("pink");
        colors.add("red");
        colors.add("blue");
        colors.add("coral");
        colors.add("green");

        System.out.println("\nBefore sorting: ");
        for (String color: colors) {
            System.out.println(color);
        }

        System.out.println("\nAfter sorting: ");
        Collections.sort(colors);
        for (String color: colors) {
            System.out.println(color);
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(123);
        numbers.add(56);

        System.out.println("\nBefore sorting: ");
        for (int number: numbers) {
            System.out.println(number);
        }

        System.out.println("\nAfter sorting: ");
        Collections.sort(numbers);
        for (int number: numbers) {
            System.out.println(number);
        }
    }
}
