package com.manuelnavarro;

public class Demo7 {
    public static void main(String[] args) {
        String message = "This is a random sentence to test index";

        System.out.println(message.indexOf('i'));  // 4
        System.out.println(message.indexOf('e', 15));
        System.out.println(message.indexOf("de"));  // 2
    }
}