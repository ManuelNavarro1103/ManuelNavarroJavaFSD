package com.manuelnavarro;

public class CustomerAccountsDAOConnection {

    private static CustomerAccountsDAO dao;

    private CustomerAccountsDAOConnection() {}

    public static CustomerAccountsDAO getCustomerAccountsDao() {
        if(dao == null)
            dao = new CustomerAccountsDAOImpl();
        return dao;
    }
}
