package com.manuelnavarro;

import java.util.PriorityQueue;

public class Demo13 {

    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Manuel");
        queue.add("Sara");
        queue.add("Leah");
        queue.add("Myron");

        for (String name: queue) {
            System.out.println(name);
        }

        System.out.println("Head: " +queue.element());
        System.out.println("Head: " +queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.poll());

        System.out.println("******************");
        for (String name: queue) {
            System.out.println(name);
        }
    }
}
