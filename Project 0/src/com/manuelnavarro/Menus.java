package com.manuelnavarro;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menus {
    Customer customer = new Customer();
    AccountApplications applications = new AccountApplications();
    CustomerDAO dao = CustomerDAOConnection.getCustomerDao();
    EmployeeDAO dao1 = EmployeeDAOConnection.getEmployeeDao();
    AccountApplicationsDAO dao2 = AccountApplicationsDAOConnection.getAccountApplicationsDao();
    AccountDAO dao3 = AccountDAOConnection.getAccountDao();
    CustomerAccountsDAO dao4 = CustomerAccountsDAOConnection.getCustomerAccountsDao();

    public void startingMenu() {
        System.out.println("\n*************************************");
        System.out.println("* Welcome to my Banking Application *");
        System.out.println("*************************************");
        System.out.println("Please select an option!");
        System.out.println("\n1 - Create Customer Account");
        System.out.println("2 - Customer Login");
        System.out.println("3 - Employee Login");
        System.out.println("4 - Exit");
    }

    public void createCustAccountMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String street;
        System.out.println("\n*****************************");
        System.out.println("* Customer Account Creation *");
        System.out.println("*****************************");
        System.out.println("Enter your first name");
        customer.setFname(scanner.next());
        System.out.println("Enter your last name");
        customer.setLname(scanner.next());
        System.out.println("Enter your Phone Number in this format XXX-XXX-XXXX");
        customer.setPhoneNum(scanner.next());
        System.out.println("Enter your email");
        customer.setEmail(scanner.next());
        System.out.println("Enter a username");
        customer.setUsername(scanner.next());
        System.out.println("Enter a password");
        customer.setPassword(scanner.next());
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter your address street");
        customer.setAddressStreet(scanner1.nextLine());
        System.out.println("Enter your address city");
        customer.setAddressCity(scanner.next());
        System.out.println("Enter your address state");
        customer.setAddressState(scanner.next());
        System.out.println("Enter your 5 digit zip code");
        customer.setAddressZip(scanner.nextInt());
        dao.addCustomer(customer);
    }

    public boolean customerLogin() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        System.out.println("\n******************");
        System.out.println("* Customer Login *");
        System.out.println("******************");
        System.out.println("Enter Username");
        String username = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        while (dao.verifyLogin(username, password) == false && attempts < 3) {
            System.out.println("\nInvalid Login!");
            System.out.println("\nEnter Username");
            username = scanner.next();
            System.out.println("Enter password");
            password = scanner.next();
            attempts++;
        }
        if (attempts == 3) {
            System.out.println("\nToo many attempts.");
            return false;
        }
        else
            customer.setCurrentCustomer(dao.currentCustomer(username, password));
            return true;
    }

    public boolean employeeLogin() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        System.out.println("\n******************");
        System.out.println("* Employee Login *");
        System.out.println("******************");
        System.out.println("Enter Username");
        String username = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        while (dao1.verifyLogin(username, password) == false && attempts < 3) {
            System.out.println("\nInvalid Login!");
            System.out.println("\nEnter Username");
            username = scanner.next();
            System.out.println("Enter password");
            password = scanner.next();
            attempts++;
        }
        if (attempts == 3) {
            System.out.println("\nToo many attempts.");
            return false;
        }
        else
            return true;
    }

    public void custLoggedInMenu() {
        System.out.println("\n**********************");
        System.out.println("* Customer Logged In *");
        System.out.println("**********************");
        System.out.println("Please select an option!");
        System.out.println("\n1 - Apply for New Bank Account");
        System.out.println("2 - Select a Bank Account");
        System.out.println("3 - Exit");
    }
    public void accountApplication() throws SQLException {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        while (option != 3) {
            System.out.println("\n*************************");
            System.out.println("* Apply for New Account *");
            System.out.println("*************************");
            System.out.println("Please select an option!");
            System.out.println("\n1 - Apply for a Checking Account");
            System.out.println("2 - Apply for a Savings Account");
            System.out.println("3 - Exit");
            option = scanner.nextInt();
            int balanceOption;
            switch (option) {
                case 1:
                    applications.setAccountType("Checking");
                    System.out.println("\nSelect a Starting Balance!");
                    System.out.println("1 - Starting balance $100");
                    System.out.println("2 - Starting balance $1000");
                    System.out.println("3 - Starting balance $10000");
                    Scanner scanner1 = new Scanner(System.in);
                    balanceOption = scanner1.nextInt();
                    applicationSet(balanceOption);
                    break;
                case 2:
                    applications.setAccountType("Saving");
                    System.out.println("\nSelect a Starting Balance!");
                    System.out.println("1 - Starting balance $100");
                    System.out.println("2 - Starting balance $1000");
                    System.out.println("3 - Starting balance $10000");
                    Scanner scanner2 = new Scanner(System.in);
                    balanceOption = scanner2.nextInt();
                    applicationSet(balanceOption);
                    break;
                case 3:
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("Invalid entry");
                }

            }
        }

    private void applicationSet(int option) throws SQLException {
        Customer customer1 = customer.getCurrentCustomer();
        switch (option) {
            case 1:
                applications.setCustomerId(customer1.getId());
                applications.setCustFname(customer1.getFname());
                applications.setCustLname(customer1.getLname());
                applications.setStartBalance(100);
                dao2.applyAccount(applications);
                break;
            case 2:
                applications.setCustomerId(customer1.getId());
                applications.setCustFname(customer1.getFname());
                applications.setCustLname(customer1.getLname());
                applications.setStartBalance(1000);
                dao2.applyAccount(applications);
                break;
            case 3:
                applications.setCustomerId(customer1.getId());
                applications.setCustFname(customer1.getFname());
                applications.setCustLname(customer1.getLname());
                applications.setStartBalance(10000);
                dao2.applyAccount(applications);
                break;
            default:
                System.out.println("\nInvalid entry");
        }
    }

    public void empLoggedInMenu() {
        System.out.println("\n**********************");
        System.out.println("* Employee Logged In *");
        System.out.println("**********************");
        System.out.println("Please select an option!");
        System.out.println("\n1 - View Account Applications");
        System.out.println("2 - View All Customers");
        System.out.println("3 - View Customer's Accounts By Id");
        System.out.println("4 - Add a New Employee");
        System.out.println("5 - View All Logs");
        System.out.println("6 - Exit");
    }

    public void accountApplicationsMenu() throws SQLException {
        AccountApplications applications1 = new AccountApplications();
        System.out.println("\n************************");
        System.out.println("* Pending Applications *");
        System.out.println("************************");
        List<AccountApplications> applications = dao2.getApplications();
        if (applications.isEmpty()){
            System.out.println("\nThere are no current applications.");
        }else {
            System.out.println("Please select an application by Id!");
            for (AccountApplications application : applications) {
                //System.out.println(application);
                System.out.println("\nApplicationId: " + application.getId() + "\nCustomerId: " + application.getCustomerId() +
                        "\nCustomer Name: " + application.getCustFname() + " " + application.getCustLname() +
                        "\nStart Balance Request: " + application.getStartBalance() + "\nAccount Type: " + application.getAccountType());
            }
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            applications1 = dao2.getApplicationById(id);
            System.out.println("\n**************************************************************");
            System.out.println("\nApplicationId: "+applications1.getId()+"\nCustomerId: "+applications1.getCustomerId()+
                    "\nCustomer Name: "+applications1.getCustFname()+" "+applications1.getCustLname()+
                    "\nStart Balance Request: "+applications1.getStartBalance()+"\nAccount Type: "+applications1.getAccountType());
            System.out.println("\nPlease select an option");
            System.out.println("1 - Approve Application");
            System.out.println("2 - Deny Application");
            int option = 0;
            scanner = new Scanner(System.in);
            option = scanner.nextInt();
            while (option < 1 || option > 2) {
                System.out.println("\nOption not valid please try again.");
                scanner = new Scanner(System.in);
                option = scanner.nextInt();
            }
            switch (option) {
                case 1:
                    Account account = new Account();
                    account.setBalance(applications1.getStartBalance());
                    account.setType(applications1.getAccountType());
                    dao3.addAccount(account);
                    System.out.println("\nApplication Approved!");
                    dao4.addAccountRelationship(applications1.getCustomerId(), dao3.getNewAccountId());
                    dao2.deleteApplication(applications1.getId());
                    break;
                case 2:
                    dao2.deleteApplication(applications1.getId());
                    System.out.println("\nApplication Denied!");
                    break;
            }
        }
    }
    public void allCustomersMenu() throws SQLException {
        System.out.println("\n*************************");
        System.out.println("* All Current Customers *");
        System.out.println("*************************");
        List<Customer> customers = dao.getCustomers();
        for (Customer customer: customers) {
            System.out.println("\nId: "+customer.getId()+" | Name: "+customer.getFname()+" "+customer.getLname()+" | " +
                    "Phone:" +
                    " "+customer.getPhoneNum()+" | Email: "+customer.getEmail()+" | Address: "+customer.getAddressStreet()+", "+customer.getAddressCity()+", "+customer.getAddressState());
        }
    }

    public void customerAccountsMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter a Customer Id.");
        int id = scanner.nextInt();
        System.out.println("\n***********************");
        System.out.println("* Customer's Accounts *");
        System.out.println("***********************");
        System.out.println("Please select an Account by AccountId to view ALl Transactions.");
        List<CustomerAccounts> customerAccounts = dao4.allCustomersAccounts(id);
        for (CustomerAccounts accounts: customerAccounts) {
            System.out.println("\nCustomerId: "+accounts.getCustomerId()+" | AccountId: "+accounts.getAccountId()+" |" +
                    " Account Balance: "+accounts.getAccountBalance()+" | Account Type: "+accounts.getAccountType()+
                    " | Creation Date: "+accounts.getDate());
        }
        id = scanner.nextInt();

        System.out.println("\n****************************");
        System.out.println("* All Account Transactions *");
        System.out.println("****************************");
        dao4.accountHistory(id);
    }

    public void addEmployeeMenu() throws SQLException {
        Employee employee = new Employee();
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter Employee First Name");
        employee.setFname(scan.next());
        System.out.println("Enter Employee Last Name");
        employee.setLname(scan.next());
        System.out.println("Enter Employee Username");
        employee.setUsername(scan.next());
        System.out.println("Enter Employee Password");
        employee.setPassword(scan.next());
        System.out.println("Enter Employee Email");
        employee.setEmail(scan.next());
        dao1.addEmployee(employee);
    }
}
