package com.manuelnavarro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountApplicationsImpl implements AccountApplicationsDAO{

    private static Statement statement = null;
    Connection connection = null;

    public AccountApplicationsImpl() {
        try {
            this.connection = DBConnetion.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void applyAccount(AccountApplications application) throws SQLException {
        String sql = "Insert into accountapplications (CustomerId, CustFname, CustLname, StartBalance, AccountType) " +
                "values" +
                "(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, application.getCustomerId());
        preparedStatement.setString(2, application.getCustFname());
        preparedStatement.setString(3, application.getCustLname());
        preparedStatement.setDouble(4, application.getStartBalance());
        preparedStatement.setString(5, application.getAccountType());
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("\nApplication saved.");
        else
            System.out.println("\nOops! Something went wrong.");
    }

    @Override
    public List<AccountApplications> getApplications() throws SQLException {
        List<AccountApplications> applications = new ArrayList<>();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from accountapplications");
        while (resultSet.next()) {
            AccountApplications application = new AccountApplications(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getDouble(4), resultSet.getString(5), resultSet.getInt(6));
            applications.add(application);
        }
        return applications;
    }

    @Override
    public AccountApplications getApplicationById(int id) throws SQLException {
        String sql = "Select * from accountapplications where ApplicationId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            AccountApplications application = new AccountApplications(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getDouble(4), resultSet.getString(5), resultSet.getInt(6));
            return application;
        }
        else
            System.out.println("Application does not exist.");
            return null;
    }

    @Override
    public void deleteApplication(int id) throws SQLException {
        String sql = "Delete from accountapplications where ApplicationId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0){

        }
        else
            System.out.println("\nOops! Something went wrong.");
    }
}
