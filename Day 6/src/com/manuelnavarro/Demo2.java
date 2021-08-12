package com.manuelnavarro;

import java.util.ArrayList;
import java.util.Collections;

public class Demo2 {

    public static void main(String[] args) {

        ArrayList<String > letters = new ArrayList<>();
        letters.add("R");
        letters.add("A");
        letters.add("B");
        letters.add("S");
        letters.add("O");
        letters.add("M");

        System.out.println("Before sorting...");
        for (String letter: letters) {
            System.out.println(letter);
        }

        Collections.sort(letters);
        System.out.println("After sorting...");
        for (String letter: letters) {
            System.out.println(letter);
        }
    }
}
