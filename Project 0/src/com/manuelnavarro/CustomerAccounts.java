package com.manuelnavarro;

import java.util.Date;

public class CustomerAccounts {

    private int customerId;
    private int accountId;
    private double accountBalance;
    private String accountType;
    private Date date;

    public CustomerAccounts() {}

    public CustomerAccounts(int customerId, int accountId) {
        this.customerId = customerId;
        this.accountId = accountId;
    }

    public CustomerAccounts(int customerId, int accountId, double accountBalance, String accountType, Date date) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountbalance) {
        this.accountBalance = accountbalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
