package com.manuelnavarro;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo14 {

    public static void main(String[] args) {

        Deque<String> deque = new ArrayDeque<>();
        deque.add("Manuel");
        deque.add("Sara");
        deque.add("Leah");

        for (String names: deque) {
            System.out.println(names);
        }
    }
}
