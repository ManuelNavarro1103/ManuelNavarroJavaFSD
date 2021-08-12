package com.manuelnavarro;

public class Customer {

    private int id;
    private String fname;
    private String lname;
    private String phoneNum;
    private String email;
    private String username;
    private String password;
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private int addressZip;
    private Customer currentCustomer;

    public Customer() {

    }

    public Customer(int id, String fname, String lname, String phoneNum, String email,
                    String username, String password, String addressStreet,
                    String addressCity, String addressState, int addressZip) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phoneNum = phoneNum;
        this.email = email;
        this.username = username;
        this.password = password;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressZip = addressZip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public int getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(int addressZip) {
        this.addressZip = addressZip;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
