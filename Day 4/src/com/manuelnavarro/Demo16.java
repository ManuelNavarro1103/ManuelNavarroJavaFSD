package com.manuelnavarro;

import java.util.HashMap;
import java.util.Map;

public class Demo16 {

    public static void main(String[] args) {
        Map<Integer, String> student = new HashMap<>();
        student.put(1, "Manuel");
        student.put(2, "Sara");
        student.put(3, "Leah");

        System.out.println(student);
    }
}
