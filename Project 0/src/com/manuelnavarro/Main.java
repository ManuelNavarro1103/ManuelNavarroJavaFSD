package com.manuelnavarro;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Menus menus = new Menus();
        Employee employee = new Employee();
        int welcomeOtion = 0;
        Scanner scanner = new Scanner(System.in);

        while (welcomeOtion != 4) {
            int loggedInOption = 0;
            menus.startingMenu();
            welcomeOtion = scanner.nextInt();
            switch (welcomeOtion) {
                case 1:
                    menus.createCustAccountMenu();
                    break;
                case 2:
                    if (menus.customerLogin()) {
                        while (loggedInOption != 3) {
                            scanner = new Scanner(System.in);
                            menus.custLoggedInMenu();
                            loggedInOption  = scanner.nextInt();
                            switch (loggedInOption) {
                                case 1:
                                    menus.accountApplication();
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    System.out.println("\nLogging out...");
                                    break;
                                default:
                                    System.out.println("Invalid entry please try again");
                            }
                        }
                    }
                    break;
                case 3:
                    if (menus.employeeLogin()) {
                        while (loggedInOption != 6) {
                            scanner = new Scanner(System.in);
                            menus.empLoggedInMenu();
                            loggedInOption  = scanner.nextInt();
                            switch (loggedInOption) {
                                case 1:
                                    menus.accountApplicationsMenu();
                                    break;
                                case 2:
                                    menus.allCustomersMenu();
                                    break;
                                case 3:
                                    menus.customerAccountsMenu();
                                    break;
                                case 4:
                                    menus.addEmployeeMenu();
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    System.out.println("\nLogging out...");
                                    break;
                                default:
                                    System.out.println("Invalid entry please try again");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nThank you! Exiting...");
                    break;
                default:
                    System.out.println("Invalid entry.");
            }
        }
        //menus.employeeLogin();
        //menus.customerLogin();
        //menus.startingMenu();
        //menus.custLoginMenu();

//        System.out.println("********************");
//        System.out.println("* Select an option *");
//        System.out.println("********************");
//        System.out.println("1 - Add Employee");
//        System.out.println("2 - Update Employee");
//        System.out.println("3 - Delete Employee");
//        System.out.println("4 - View all Employees");
//        System.out.println("5 - View an Employee by Id");
//        System.out.println("6 - Exit");
//        Scanner scanner = new Scanner(System.in);
//        optionsInt = scanner.nextInt();
//        while (optionsInt < 1 || optionsInt > 6) {
//            System.out.println("Invalid input please try again.");
//            scanner = new Scanner(System.in);
//            optionsInt = scanner.nextInt();
//        }
//        switch (optionsInt) {
//            case 1:
//                Scanner scan = new Scanner(System.in);
//                System.out.println("\nEnter Employee First Name");
//                employee.setFname(scan.next());
//                System.out.println("Enter Employee Last Name");
//                employee.setLname(scan.next());
//                System.out.println("Enter Employee Email");
//                employee.setEmail(scan.next());
//                dao.addEmployee(employee);
//                break;
//            case 2:
//                Scanner scan1 = new Scanner(System.in);
//                System.out.println("\nEnter Employee First Name");
//                employee.setFname(scan1.next());
//                System.out.println("Enter Employee Last Name");
//                employee.setLname(scan1.next());
//                System.out.println("Enter Employee Email");
//                employee.setEmail(scan1.next());
//                System.out.println("Enter Employee Id");
//                optionsInt = scan1.nextInt();
//                employee.setId(optionsInt);
//                dao.updateEmployee(employee);
//                break;
//            case 3:
//                Scanner scan2 = new Scanner(System.in);
//                System.out.println("\nEnter Id of the Employee");
//                optionsInt = scan2.nextInt();
//                dao.deleteEmployee(optionsInt);
//                break;
//            case 4:
//                dao.getEmployees();
//                break;
//            case 5:
//                Scanner scan3 = new Scanner(System.in);
//                System.out.println("\nEnter Employee Id");
//                optionsInt = scan3.nextInt();
//                dao.employeeById(optionsInt);
//                break;
//            case 6:
//                System.out.println("\nThank you!");
//                System.out.println("Exiting...");
//        }
    }
}