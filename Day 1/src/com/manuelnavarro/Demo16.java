package com.manuelnavarro;

class Book1 {
    private String title;
    private String author;
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printInfo() {
        System.out.println("\nBook: \nTitle: " +title+ ", Author: " +author+ ", Price: " +price);
    }
}

public class Demo16 {

    public static void main(String[] args) {
        Book1 book1 = new Book1();
        book1.setTitle("Title 1");
        book1.setAuthor("Author 1");
        book1.setPrice(100);

        book1.printInfo();
    }
}
