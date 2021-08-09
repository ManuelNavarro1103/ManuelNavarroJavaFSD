package com.manuelnavarro;

import java.util.Date;

public class Account {

    private int id;
    private double balance;
    private String type;

    public Account() {}

    public Account(int id, double balance, String type) {
        this.id = id;
        this.balance = balance;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
