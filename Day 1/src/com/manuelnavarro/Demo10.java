package com.manuelnavarro;

public class Demo10 {

    public static void main(String[] args) {
        for (int i=1; i<=5; i++) {
            for (int j=5; j>=i; j--) {
                System.out.println("* ");
            }
            System.out.println();
        }
    }
}
