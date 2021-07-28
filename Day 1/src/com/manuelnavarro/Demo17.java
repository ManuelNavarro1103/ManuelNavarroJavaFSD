package com.manuelnavarro;

class Book2 {
    private String title;
    private String author;
    private int price;

    public Book2(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("\nBook: \nTitle: " +title+ ", Author: " +author+ ", Price: " +price);
    }
}

public class Demo17 {

    public static void main(String[] args) {
        Book2 book2 = new Book2("Title 1", "Author 1", 100);
        book2.printInfo();
    }

}
