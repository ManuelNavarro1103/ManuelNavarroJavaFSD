package com.manuelnavarro;

public class CustomerDAOConnection {

    private static CustomerDAO dao;

    private CustomerDAOConnection() {}

    public static CustomerDAO getCustomerDao() {
        if(dao == null)
            dao = new CustomerDAOImpl();
        return dao;
    }
}
