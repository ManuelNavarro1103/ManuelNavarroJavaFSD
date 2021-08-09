package com.manuelnavarro;

import java.sql.SQLException;
import java.util.List;

public interface CustomerAccountsDAO {

    void addAccountRelationship(int customerId, int accountId) throws SQLException;
    List<CustomerAccounts> allCustomersAccounts(int customerId) throws SQLException;
    void accountHistory(int id) throws SQLException;
}
