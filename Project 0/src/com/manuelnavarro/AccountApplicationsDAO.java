package com.manuelnavarro;

import java.sql.SQLException;
import java.util.List;

public interface AccountApplicationsDAO {
    void applyAccount(AccountApplications applications) throws SQLException;
    List<AccountApplications> getApplications() throws SQLException;
    AccountApplications getApplicationById(int id) throws SQLException;
    void deleteApplication(int id) throws SQLException;
}
