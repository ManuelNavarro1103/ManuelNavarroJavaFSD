package com.manuelnavarro;

public class AccountApplicationsDAOConnection {

    private static AccountApplicationsDAO dao;

    private AccountApplicationsDAOConnection() {}

    public static AccountApplicationsDAO getAccountApplicationsDao() {
        if(dao == null)
            dao = new AccountApplicationsImpl();
        return dao;
    }
}
