package model;

public abstract class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    
    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Deposit amount must be greater than zero.");
            return;
        } 
            balance += amount;

            System.out.println("Amount deposited successfully");
            System.out.println("Current Balance: " + balance);
    }

    public abstract void withdraw(double amount);

    public abstract double calculateInterest();

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public double getBalance(){
        return balance;
    }

    protected void setBalance(double balance){
        this.balance = balance;
    }

    public void displayAccountDetails(){
        System.out.println("\n----------Account Details-----------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}
