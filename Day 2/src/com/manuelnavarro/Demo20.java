package com.manuelnavarro;

interface IBankAccount{

    boolean deposit(double amount);
    boolean withdraw(double amount);
    void getBalance();
}

class SavingAccount implements IBankAccount{

    private double _balance;
    private  double _perDayLimit;

    @Override
    public boolean deposit(double amount) {
        _balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if(_balance <amount){
            System.out.println("Insufficient balance!");
            return false;
        }
        // limit 5000
        else if(_perDayLimit + amount > 100){
            System.out.println("\nWithdraw attempt failed");
            return false;
        }
        else{
            _balance -= amount;
            _perDayLimit += amount;
            System.out.println("Successfully withdrew: "+ amount);
            return true;
        }
    }

    @Override
    public void getBalance() {
        System.out.println("Saving Account Balance: " + _balance);
    }
}

class CurrentAccount implements IBankAccount{

    private double _balance;

    @Override
    public boolean deposit(double amount) {
        _balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if(_balance < amount){
            System.out.println("\nInsufficient balance!");
            return false;
        }else{
            _balance -= amount;
            System.out.println("\nSuccessfully withdrew: "+ amount);
            return true;
        }
    }

    @Override
    public void getBalance() {
        System.out.println("Current Account Balance: " + _balance);
    }
}


public class Demo20 {
    public static void main(String[] args) {
        IBankAccount savingAccount = new SavingAccount();
        IBankAccount currentAccount = new CurrentAccount();

        savingAccount.deposit(2000);
        savingAccount.withdraw(1000);
        savingAccount.getBalance();

        currentAccount.deposit(5000);
        currentAccount.withdraw(6000);
        currentAccount.withdraw(2000);
        currentAccount.getBalance();
    }
}