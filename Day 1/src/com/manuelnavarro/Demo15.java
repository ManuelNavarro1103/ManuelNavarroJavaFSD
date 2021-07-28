package com.manuelnavarro;

class Book {
    public String title;
    public String author;
    public int price;

    public void printInfo() {
        System.out.println("\nBook: \nTitle: " +title+ ", Author: " +author+ ", Price: " +price);
    }
}

public class Demo15 {

    public static void main(String[] args) {
        Book book = new Book();
        book.title = "Java";
        book.author = "Author";
        book.price = 100;

        Book book1 = new Book();
        book1.title = "Angular";
        book1.author = "Author 1";
        book1.price = 200;

        book.printInfo();
        book1.printInfo();
    }
}
