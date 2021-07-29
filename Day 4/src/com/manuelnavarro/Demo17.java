package com.manuelnavarro;

import java.util.Hashtable;
import java.util.Map;

public class Demo17 {

    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "Manuel");
        hashtable.put(2, "Sara");
        hashtable.put(3, "Leah");
        hashtable.put(4, "Myron");

        for (Map.Entry entry: hashtable.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
