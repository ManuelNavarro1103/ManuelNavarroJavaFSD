package com.manuelnavarro;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class AccountDAOImpl implements AccountDAO{
    private static final Logger logger = Logger.getLogger(String.valueOf(AccountDAOImpl.class));

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

    @Override
    public void getAccountById(int custId, int accountId) throws SQLException {
        String sql = "select customeraccounts.CustomerId, accounts.AccountId, accounts.AccountBalance, accounts" +
                ".AccountType, " +
                "accounts" +
                ".CreationDate from customeraccounts right join accounts on customeraccounts.AccountId = accounts" +
                ".AccountId where (CustomerId = ? AND accounts.AccountId = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, custId);
        preparedStatement.setInt(2, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int acctId = resultSet.getInt(2);
            double balance = resultSet.getDouble(3);
            String type = resultSet.getString(4);
            Date date = resultSet.getDate(5);
            System.out.println("\nAccountId: "+acctId+" |" +
                    " Account Balance: "+balance+" | Account Type: "+type+
                    " | Creation Date: "+date);
        }
        else
            System.out.println("Account does not exist.");
    }

    @Override
    public boolean accountExists(int custId, int accountId) throws SQLException {
        String sql = "select customeraccounts.CustomerId, accounts.AccountId, accounts.AccountBalance, accounts" +
                ".AccountType, " +
                "accounts" +
                ".CreationDate from customeraccounts right join accounts on customeraccounts.AccountId = accounts" +
                ".AccountId where (CustomerId = ? AND accounts.AccountId = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, custId);
        preparedStatement.setInt(2, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return true;
        }
        else
            return false;
    }

    @Override
    public void deposit(double amount, int accountId) throws SQLException {
        if (amount < 0) {
            System.out.println("\nCannot deposit a negative amount.");
        }
        else if (amount == 0) {
            System.out.println("Cannot deposit nothing.");
        }
        else {
            double curAmount = 0;
            String sql = "select AccountBalance from accounts where AccountId = ?";
            String sql1 = "update accounts set AccountBalance = ? where AccountId = ?";
            String sql2 = "insert into accounthistory (AccountId, TransactionAmt, TransactionDate) values (?,?,CURRENT_DATE)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                curAmount = resultSet.getDouble(1);
                double newAmount = curAmount + amount;
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
                preparedStatement1.setDouble(1, newAmount);
                preparedStatement1.setInt(2, accountId);
                int count = preparedStatement1.executeUpdate();
                if (count > 0) {
                    System.out.println("\nDeposit saved.");
                }
                String sAmount = String.valueOf(amount);
                String plus = "+"+sAmount;
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                preparedStatement2.setInt(1, accountId);
                preparedStatement2.setString(2, plus);
                preparedStatement2.executeUpdate();
            }
        }
    }

    @Override
    public void withdraw(double amount, int accountId) throws SQLException {
        if (amount < 0) {
            System.out.println("\nCannot withdraw a negative amount.");
        }
        else if (amount == 0) {
            System.out.println("Cannot withdraw nothing.");
        }
        else {
            double curAmount = 0;
            String sql = "select AccountBalance from accounts where AccountId = ?";
            String sql1 = "update accounts set AccountBalance = ? where AccountId = ?";
            String sql2 = "insert into accounthistory (AccountId, TransactionAmt, TransactionDate) values (?,?,CURRENT_DATE)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                curAmount = resultSet.getDouble(1);
                double newAmount = curAmount - amount;
                if (newAmount > 0) {
                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
                    preparedStatement1.setDouble(1, newAmount);
                    preparedStatement1.setInt(2, accountId);
                    int count = preparedStatement1.executeUpdate();
                    if (count > 0) {
                        System.out.println("\nWithdraw saved.");
                    }
                    String sAmount = String.valueOf(amount);
                    String minus ="-"+sAmount;
                    PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                    preparedStatement2.setInt(1, accountId);
                    preparedStatement2.setString(2, minus);
                    preparedStatement2.executeUpdate();
                }
                else
                    System.out.println("\nInsufficient funds.");
            }
        }
    }

    @Override
    public void allTransactionHistory() throws SQLException {
        String sql = "select * from accounthistory";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("\nAccountId: "+resultSet.getInt(1)+" | Transaction Amount: "+resultSet.getString(2)+
                    " | Date: "+resultSet.getDate(3));
        }
    }

}
