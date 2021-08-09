package com.manuelnavarro;

public class AccountApplications {

    private int customerId;
    private String custFname;
    private String custLname;
    private double startBalance;
    private String accountType;
    private int id;

    public AccountApplications() {}

    public AccountApplications(int customerId, String custFname, String custLname, double startBalance,
                               String accountType, int id) {
        this.customerId = customerId;
        this.custFname = custFname;
        this.custLname = custLname;
        this.startBalance = startBalance;
        this.accountType = accountType;
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustFname() {
        return custFname;
    }

    public void setCustFname(String custFname) {
        this.custFname = custFname;
    }

    public String getCustLname() {
        return custLname;
    }

    public void setCustLname(String custLname) {
        this.custLname = custLname;
    }

    public double getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(double startBalance) {
        this.startBalance = startBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
