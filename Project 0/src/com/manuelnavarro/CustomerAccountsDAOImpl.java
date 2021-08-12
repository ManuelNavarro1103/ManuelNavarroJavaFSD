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
        String sql = "select * from accounthistory where AccountId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next() == false) {
            System.out.println("\nThere is no transaction history");
        }
        else {
            String amount = resultSet.getString(2);
            Date date = resultSet.getDate(3);
            System.out.println("\nTransaction: "+amount+" | Date: "+date);
        }
        while (resultSet.next()) {
            String amount = resultSet.getString(2);
            Date date = resultSet.getDate(3);
            System.out.println("\nTransaction: "+amount+" | Date: "+date);
        }
    }

    @Override
    public void transferMoney(int transferId, double amount, int fromId, List<CustomerAccounts> accounts) throws SQLException {
        if (amount < 0) {
            System.out.println("\nCannot transfer a negative amount.");
        }
        else if (amount == 0) {
            System.out.println("Cannot transfer nothing.");
        }
        else {
            List<Integer> accountIds = new ArrayList<>();
            for (CustomerAccounts account: accounts) {
                int id = account.getAccountId();
                accountIds.add(id);
            }
            double curAmount = 0;
            String sql = "Insert into accounttransfers(AccountToId, TransferAmount, AccountFromId) values (?,?,?)";
            String sql1 = "select AccountBalance from accounts where AccountId = ?";
            String sql2 = "update accounts set AccountBalance = ? where AccountId = ?";
            String sql3 = "insert into accounthistory (AccountId, TransactionAmt, TransactionDate) values (?,?," +
                    "CURRENT_DATE)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1, fromId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                curAmount = resultSet.getDouble(1);
                double newAmount = curAmount - amount;
                if (curAmount < 0) {
                    System.out.println("\nCannot transfer more than current balance.");
                }
                else if (!accountIds.contains(transferId)) {
                    System.out.println("\nAccount does not exist.");
                }
                else {
                    //updates accounts
                    PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                    preparedStatement2.setDouble(1, newAmount);
                    preparedStatement2.setInt(2, fromId);
                    preparedStatement2.executeUpdate();
                    String sAmount = String.valueOf(amount);
                    String minus ="-"+sAmount;

                    //inserts into accounthistory
                    PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
                    preparedStatement3.setInt(1, fromId);
                    preparedStatement3.setString(2, minus);
                    preparedStatement3.executeUpdate();

                    //inserts int accounts
                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
                    preparedStatement1.setInt(1, transferId);
                    preparedStatement1.setDouble(2, amount);
                    preparedStatement1.setInt(3, fromId);
                    int count = preparedStatement1.executeUpdate();
                    if (count > 0) {
                        System.out.println("\nTransfer saved.\nWaiting approval.");
                    }
                    else {
                        System.out.println("\nOops something went wrong.");
                    }

                }
            }
        }
    }

    @Override
    public boolean viewTransfers(int accountId) throws SQLException {
        String sql = "select * from accounttransfers where AccountToId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next() == false){
            System.out.println("\nThere are no incoming transfers.");
            return false;
        }
        else {
            System.out.println("\nTransferId: "+resultSet.getInt(4)+"\nFrom AccountId: "+resultSet.getInt(3)+
                    "\nAmmount: "+resultSet.getDouble(2));
            while (resultSet.next()) {
                System.out.println("\nTransferId: "+resultSet.getInt(4)+"\nFrom AccountId: "+resultSet.getInt(3)+
                        "\nAmmount: "+resultSet.getDouble(2));
            }
            return true;
        }
    }

    @Override
    public void viewTransferById(int transferId) throws SQLException {
        String sql = "select * from accounttransfers where TransferId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, transferId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next() == false){
            System.out.println("\nTransfer does not exist.");
        }
        else {
            System.out.println("\nTransferId: "+resultSet.getInt(4)+"\nFrom AccountId: "+resultSet.getInt(3)+
                    "\nAmmount: "+resultSet.getDouble(2));
        }

    }

    @Override
    public void acceptTransfer(int transferId) throws SQLException {
        String sql = "select * from accounttransfers where TransferId = ?";
        String sql1 = "insert into accounthistory (AccountId, TransactionAmt, TransactionDate) values (?,?," +
                "CURRENT_DATE)";
        String sql2 = "update accounts set AccountBalance = ? where AccountId = ?";
        String sql3 = "select AccountBalance from accounts where AccountId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, transferId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            double amount = resultSet.getDouble(2);
            String sAmount = String.valueOf(amount);
            String plus = "+"+sAmount;

            //gets current balance of account
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql3);
            preparedStatement2.setInt(1, id);
            ResultSet resultSet1 = preparedStatement2.executeQuery();
            while (resultSet1.next()) {
                double curAmount = resultSet1.getDouble(1);
                double newAmount = curAmount + amount;

                //update balance of accounts
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                preparedStatement1.setDouble(1, newAmount);
                preparedStatement1.setInt(2, id);
                preparedStatement1.executeUpdate();

                //inserts into accounthistory
                PreparedStatement preparedStatement3 = connection.prepareStatement(sql1);
                preparedStatement3.setInt(1, id);
                preparedStatement3.setString(2, plus);
                int count = preparedStatement3.executeUpdate();
                if (count > 0)
                    System.out.println("\nTransaction approved.");
                else
                    System.out.println("\nOops something went wrong.");
            }
        }
    }

    @Override
    public void denyTransfer(int transferId) throws SQLException {
        String sql = "select * from accounttransfers where TransferId = ?";
        String sql1 = "insert into accounthistory (AccountId, TransactionAmt, TransactionDate) values (?,?," +
                "CURRENT_DATE)";
        String sql2 = "update accounts set AccountBalance = ? where AccountId = ?";
        String sql3 = "select AccountBalance from accounts where AccountId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, transferId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(3);
            double amount = resultSet.getDouble(2);
            String sAmount = String.valueOf(amount);
            String plus = "+"+sAmount;

            //gets current balance of account
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql3);
            preparedStatement2.setInt(1, id);
            ResultSet resultSet1 = preparedStatement2.executeQuery();
            while (resultSet1.next()) {
                double curAmount = resultSet1.getDouble(1);
                double newAmount = curAmount + amount;

                //update balance of accounts
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                preparedStatement1.setDouble(1, newAmount);
                preparedStatement1.setInt(2, id);
                preparedStatement1.executeUpdate();

                //inserts into accounthistory
                PreparedStatement preparedStatement3 = connection.prepareStatement(sql1);
                preparedStatement3.setInt(1, id);
                preparedStatement3.setString(2, plus);
                int count = preparedStatement3.executeUpdate();
                if (count > 0)
                    System.out.println("\nTransaction denied.");
                else
                    System.out.println("\nOops something went wrong.");
            }
        }

    }

    @Override
    public void deleteTransfers(int transferId) throws SQLException {
        String sql = "Delete from accounttransfers where TransferId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, transferId);
        preparedStatement.executeUpdate();
    }
}
