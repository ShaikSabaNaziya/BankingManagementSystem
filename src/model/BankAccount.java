package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.TransactionOperations;

public abstract class BankAccount implements TransactionOperations {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    private List<Transaction> transactions;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;

        this.transactions = new ArrayList<>();
    }
    
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println(
                    "Deposit amount must be greater than zero."
            );
            return;
        }

        balance += amount;

        transactions.add(
                new Transaction("DEPOSIT", amount)
        );

        System.out.println("Amount deposited successfully.");
        System.out.println("Current balance: ₹" + balance);
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

    public void displayTransactionHistory() {

        System.out.println("\n----- Transaction History -----");

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {
            transaction.displayTransaction();
        }
    }

    protected void addTransaction(String type, double amount) {

        transactions.add(
                new Transaction(type, amount)
        );
    }

}
