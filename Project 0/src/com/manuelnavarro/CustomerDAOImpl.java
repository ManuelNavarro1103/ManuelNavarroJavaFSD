package com.manuelnavarro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{

    private static Statement statement = null;
    Connection connection = null;

    public CustomerDAOImpl() {
        try {
            this.connection = DBConnetion.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        String sql = "Insert into customers (CustomerFName, CustomerLName, CustomerPhone, CustomerEmail, " +
                "CustUsername, CustPassword, AddressStreet, AddressCity, AddressState, AddressZip) " +
                "values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getFname());
        preparedStatement.setString(2, customer.getLname());
        preparedStatement.setString(3, customer.getPhoneNum());
        preparedStatement.setString(4, customer.getEmail());
        preparedStatement.setString(5, customer.getUsername());
        preparedStatement.setString(6, customer.getPassword());
        preparedStatement.setString(7, customer.getAddressStreet());
        preparedStatement.setString(8, customer.getAddressCity());
        preparedStatement.setString(9, customer.getAddressState());
        preparedStatement.setInt(10, customer.getAddressZip());
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("\nCustomer saved.");
        else
            System.out.println("\nOops! Something went wrong.");

    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {

    }

    @Override
    public void deleteCustomer(int id) throws SQLException {

    }

    @Override
    public List<Customer> getCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("call getcustomers()");
        while (resultSet.next()) {
            Customer customer = new Customer(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10),
                    resultSet.getInt(11));
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customer customerByName() throws SQLException {
        return null;
    }

    @Override
    public boolean verifyLogin(String username, String password) throws SQLException {
        String sql = "Select * from customers where CustUsername = ? AND CustPassword = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return true;
        else
            return false;
    }

    @Override
    public Customer currentCustomer(String username, String password) throws SQLException {
        Customer customer = new Customer();
        String sql = "Select * from customers where CustUsername = ? AND CustPassword = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            customer.setId(resultSet.getInt(1));
            customer.setFname(resultSet.getString(2));
            customer.setLname(resultSet.getString(3));
            customer.setPhoneNum(resultSet.getString(4));
            customer.setEmail(resultSet.getString(5));
            customer.setUsername(resultSet.getString(6));
            customer.setPassword(resultSet.getString(7));
            customer.setAddressStreet(resultSet.getString(8));
            customer.setAddressCity(resultSet.getString(9));
            customer.setAddressState(resultSet.getString(10));
            customer.setAddressZip(resultSet.getInt(11));
        }
        return customer;
    }
}
