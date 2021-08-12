package com.manuelnavarro;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Menus menus = new Menus();
        int welcomeOption = 0;
        Scanner scanner = new Scanner(System.in);

        while (welcomeOption != 4) {
            int loggedInOption = 0;
            menus.startingMenu();
            do {
                try {
                    welcomeOption = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\nIncorrect entry please try again.");
                }
                scanner.nextLine();
            } while (welcomeOption == 0);
            switch (welcomeOption) {
                case 1:
                    menus.createCustAccountMenu();
                    break;
                case 2:
                    if (menus.customerLogin()) {
                        loggedInOption = 0;
                        while (loggedInOption != 3) {
                            scanner = new Scanner(System.in);
                            menus.custLoggedInMenu();
                            do {
                                try {
                                    loggedInOption = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("\nIncorrect entry please try again.");
                                }
                                scanner.nextLine();
                            } while (loggedInOption == 0);
                            switch (loggedInOption) {
                                case 1:
                                    menus.accountApplication();
                                    loggedInOption = 0;
                                    break;
                                case 2:
                                    int accountId = menus.customerAcctSelectionMenu();
                                    if (accountId == 0) {

                                    }
                                    else {
                                        int accountOption = 0;
                                        while (accountOption != 6) {
                                            menus.customerAccountMenu(accountId);
                                            scanner = new Scanner(System.in);
                                            do {
                                                try {
                                                    accountOption = scanner.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("\nIncorrect entry please try again.");
                                                }
                                                scanner.nextLine();
                                            } while (accountOption == 0);
                                            switch (accountOption) {
                                                case 1:
                                                    menus.depositMenu(accountId);
                                                    accountOption = 0;
                                                    break;
                                                case 2:
                                                    menus.withdrawMenu(accountId);
                                                    accountOption = 0;
                                                    break;
                                                case 3:
                                                    menus.customerAccountHistory(accountId);
                                                    accountOption = 0;
                                                    break;
                                                case 4:
                                                    menus.transferMoneyMenu(accountId);
                                                    accountOption = 0;
                                                    break;
                                                case 5:
                                                    menus.incomingTransferMenu(accountId);
                                                    accountOption = 0;
                                                    break;
                                                case 6:
                                                    System.out.println("\nExiting...");
                                                    break;
                                                default:
                                                    System.out.println("\nInvalid option please try again.");
                                            }
                                        }
                                    }
                                    loggedInOption = 0;
                                    break;
                                case 3:
                                    System.out.println("\nLogging out...");
                                    break;
                                default:
                                    System.out.println("\nInvalid entry please try again.");
                            }
                        }
                    }
                    break;
                case 3:
                    if (menus.employeeLogin()) {
                        loggedInOption = 0;
                        while (loggedInOption != 6) {
                            scanner = new Scanner(System.in);
                            menus.empLoggedInMenu();
                            do {
                                try {
                                    loggedInOption = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("\nIncorrect entry please try again.");
                                }
                                scanner.nextLine();
                            } while (loggedInOption == 0);
                            switch (loggedInOption) {
                                case 1:
                                    menus.accountApplicationsMenu();
                                    loggedInOption = 0;
                                    break;
                                case 2:
                                    menus.allCustomersMenu();
                                    loggedInOption = 0;
                                    break;
                                case 3:
                                    menus.customerAccountsMenu();
                                    loggedInOption = 0;
                                    break;
                                case 4:
                                    menus.addEmployeeMenu();
                                    loggedInOption = 0;
                                    break;
                                case 5:
                                    menus.allTransactionsMenu();
                                    loggedInOption = 0;
                                    break;
                                case 6:
                                    System.out.println("\nLogging out...");
                                    break;
                                default:
                                    System.out.println("\nInvalid entry please try again");
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
    }
}