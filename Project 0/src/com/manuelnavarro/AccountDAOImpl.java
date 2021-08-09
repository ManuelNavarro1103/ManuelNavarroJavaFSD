package com.manuelnavarro;

import java.sql.*;

public class AccountDAOImpl implements AccountDAO{

    private static Statement statement = null;
    Connection connection = null;

    public AccountDAOImpl() {
        try {
            this.connection = DBConnetion.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addAccount(Account account) throws SQLException {
        String sql = "Insert into accounts (AccountBalance, AccountType, CreationDate) " +
                "values (?,?,CURRENT_DATE )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, account.getBalance());
        preparedStatement.setString(2, account.getType());
        int count = preparedStatement.executeUpdate();
        if (count > 0){

        }
        else
            System.out.println("\nOops! Something went wrong.");

    }

    @Override
    public int getNewAccountId() throws SQLException {
        int id = 0;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select max(AccountId) from accounts");
        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }
}
