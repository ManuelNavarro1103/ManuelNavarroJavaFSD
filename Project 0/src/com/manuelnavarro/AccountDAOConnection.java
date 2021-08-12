package com.manuelnavarro;

public class AccountDAOConnection {

    private static AccountDAO dao;

    private AccountDAOConnection() {}

    public static AccountDAO getAccountDao() {
        if(dao == null)
            dao = new AccountDAOImpl();
        return dao;
    }
}
