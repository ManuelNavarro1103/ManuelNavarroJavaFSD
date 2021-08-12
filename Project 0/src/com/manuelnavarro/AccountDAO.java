package com.manuelnavarro;

import java.sql.SQLException;

public interface AccountDAO {
    void addAccount(Account account) throws SQLException;
    int getNewAccountId() throws SQLException;
    void getAccountById(int custId, int accountId) throws SQLException;
    boolean accountExists(int custId, int accountId) throws SQLException;
    void deposit(double amount, int accountId) throws SQLException;
    void withdraw(double amount, int accountId) throws SQLException;
    void allTransactionHistory() throws SQLException;
}
