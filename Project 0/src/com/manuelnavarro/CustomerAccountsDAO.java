package com.manuelnavarro;

import java.sql.SQLException;
import java.util.List;

public interface CustomerAccountsDAO {

    void addAccountRelationship(int customerId, int accountId) throws SQLException;
    List<CustomerAccounts> allCustomersAccounts(int customerId) throws SQLException;
    void accountHistory(int id) throws SQLException;
    void transferMoney (int transferId, double amount, int fromId, List<CustomerAccounts> accounts) throws SQLException;
    boolean viewTransfers(int accountId) throws SQLException;
    void viewTransferById(int accountId) throws SQLException;
    void acceptTransfer(int transferId) throws SQLException;
    void denyTransfer(int transferId) throws SQLException;
    void deleteTransfers(int transferId) throws SQLException;
}
