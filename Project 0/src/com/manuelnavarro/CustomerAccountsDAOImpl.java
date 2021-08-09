package com.manuelnavarro;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerAccountsDAOImpl implements CustomerAccountsDAO{

    private static Statement statement = null;
    Connection connection = null;

    public CustomerAccountsDAOImpl() {
        try {
            this.connection = DBConnetion.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addAccountRelationship(int customerId, int accountId) throws SQLException {
        String sql = "Insert into customeraccounts (CustomerId, AccountId) " +
                "values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);
        preparedStatement.setInt(2, accountId);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
        }
        else
            System.out.println("\nOops! Something went wrong.");

    }

    @Override
    public List<CustomerAccounts> allCustomersAccounts(int customerId) throws SQLException {
        List<CustomerAccounts> customerAccounts = new ArrayList<>();
        String sql = "select customeraccounts.CustomerId, accounts.AccountId, accounts.AccountBalance, accounts" +
                ".AccountType, " +
                "accounts" +
                ".CreationDate from customeraccounts right join accounts on customeraccounts.AccountId = accounts" +
                ".AccountId where CustomerId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            CustomerAccounts accounts = new CustomerAccounts(resultSet.getInt(1), resultSet.getInt(2),
                    resultSet.getDouble(3), resultSet.getString(4), resultSet.getDate(5));
            customerAccounts.add(accounts);
        }
        return customerAccounts;
    }

    @Override
    public void accountHistory(int id) throws SQLException {
        String sql = "select * from accounthistory";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String amount = resultSet.getString(2);
            Date date = resultSet.getDate(3);
            System.out.println("\nTransaction: "+amount+" | Date: "+date);
        }
        else
            System.out.println("\nThere is no transaction history");
    }
}
