package com.manuelnavarro;

import java.util.TreeSet;

public class Demo11 {

    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Manuel");
        treeSet.add("Sara");
        treeSet.add("Leah");
        treeSet.add("Myron");

        for (String name: treeSet) {
            System.out.println(name);
        }
    }
}
