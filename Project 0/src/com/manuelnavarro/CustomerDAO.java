package com.manuelnavarro;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer customer) throws SQLException;
    void updateCustomer(Customer customer) throws SQLException;
    void deleteCustomer(int id) throws SQLException;
    List<Customer> getCustomers() throws SQLException;
    Customer customerByName() throws SQLException;
    boolean verifyLogin(String username, String password) throws SQLException;
    Customer currentCustomer(String username, String password) throws SQLException;
}
