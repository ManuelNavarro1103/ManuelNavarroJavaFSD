package com.manuelnavarro;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImpl implements EmployeeDAO{

    private static Statement statement = null;
    Connection connection = null;

    public EmployeeDAOImpl() {
        try {
            this.connection = DBConnetion.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "Insert into employees (EmployeeFName, EmployeeLName, EmpUsername, EmpPassword, EmployeeEmail) " +
                "values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getFname());
        preparedStatement.setString(2, employee.getLname());
        preparedStatement.setString(3, employee.getUsername());
        preparedStatement.setString(4, employee.getPassword());
        preparedStatement.setString(5, employee.getEmail());
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("\nEmployee saved.");
        else
            System.out.println("\nOops! Something went wrong.");
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "Update employees set EmployeeFName = ?, EmployeeLName = ?, EmpUsername = ?, EmpPassword = " +
                "?, EmployeeEmail = " +
                "? where EmployeeId " +
                "=" +
                " ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getFname());
        preparedStatement.setString(2, employee.getLname());
        preparedStatement.setString(3, employee.getUsername());
        preparedStatement.setString(4, employee.getPassword());
        preparedStatement.setString(5, employee.getEmail());
        preparedStatement.setInt(6, employee.getId());
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("\nEmployee updated.");
        else
            System.out.println("\nOops! Something went wrong.");
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "Delete from employees where EmployeeId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("\nEmployee deleted");
        else
            System.out.println("\nOops! Something went wrong.");
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from employees");
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                    resultSet.getString(6));
            employees.add(employee);
        }
        for (Employee emp : employees) {
            System.out.println("\nId: "+emp.getId()+"\nName: "+emp.getFname()+" "+emp.getLname()+"\nEmail: "+emp.getEmail());
        }
        return null;
    }

    @Override
    public Employee employeeById(int id) throws SQLException {
        String sql = "Select * from employees where EmployeeId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("\nId: "+resultSet.getInt(1)+"\nName: "+resultSet.getString(2)+
                    " "+resultSet.getString(3)+"\nEmail: "+resultSet.getString(4));
        }

        return null;
    }

    @Override
    public boolean verifyLogin(String username, String password) throws SQLException {
        String sql = "Select * from employees where EmpUsername = ? AND EmpPassword = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return true;
        else
            return false;
    }
}
