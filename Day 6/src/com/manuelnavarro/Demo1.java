package com.manuelnavarro;

import java.util.ArrayList;
import java.util.Collections;

public class Demo1 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(8);
        numbers.add(32);
        numbers.add(9);
        numbers.add(865);
        numbers.add(23);

        System.out.println("Before sorting...");
        for (int num: numbers) {
            System.out.println(num);
        }

        Collections.sort(numbers);
        System.out.println("After sorting...");
        for (int num: numbers) {
            System.out.println(num);
        }
    }
}
