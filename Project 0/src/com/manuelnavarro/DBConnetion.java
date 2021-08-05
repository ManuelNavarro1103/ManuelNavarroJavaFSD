package com.manuelnavarro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnetion {

    private static Connection connection = null;

    private  DBConnetion(){}

    public static Connection getConnection() throws SQLException {

        if(connection == null) {
            ResourceBundle bundle = ResourceBundle.getBundle("com/manuelnavarro/dbConfig");
            String url = bundle.getString("url");
            String username = bundle.getString("username");
            String password = bundle.getString("password");
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
