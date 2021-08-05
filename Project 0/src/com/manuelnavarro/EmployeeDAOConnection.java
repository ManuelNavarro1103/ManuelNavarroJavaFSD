package com.manuelnavarro;

public class EmployeeDAOConnection {

    private static EmployeeDAO dao;

    private EmployeeDAOConnection() {}

    public static EmployeeDAO getEmployeeDao() {
        if(dao == null)
            dao = new EmployeeDAOImpl();
        return dao;
    }
}
