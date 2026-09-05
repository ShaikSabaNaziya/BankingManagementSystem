package model;

import java.util.ArrayList;
import java.util.List;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import interfaces.TransactionOperations;

public abstract class BankAccount
        implements TransactionOperations {

    private int accountNumber;
    private Customer customer;
    private double balance;

    private List<Transaction> transactions;

    public BankAccount(
            int accountNumber,
            Customer customer,
            double balance) {

        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;

        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero."
            );
        }

        balance += amount;

        addTransaction(
                TransactionType.DEPOSIT,
                amount,
                "Cash deposit"
        );

        System.out.println(
                "Amount deposited successfully."
        );

        System.out.println(
                "Current balance: ₹" +
                balance
        );
    }

    public abstract void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException;

    public abstract double calculateInterest();

    @Override
    public abstract void transfer(
            BankAccount receiver,
            double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException;

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void addTransaction(
            TransactionType type,
            double amount,
            String description) {

        transactions.add(
                new Transaction(
                        type,
                        amount,
                        description
                )
        );
    }

    public void displayAccountDetails() {

        System.out.println(
                "\n----- Account Details -----"
        );

        System.out.println(
                "Account Number : " +
                accountNumber
        );

        System.out.println(
                "Customer ID    : " +
                customer.getCustomerId()
        );

        System.out.println(
                "Account Holder : " +
                customer.getName()
        );

        System.out.println(
                "Phone          : " +
                customer.getPhone()
        );

        System.out.println(
                "Balance        : ₹" +
                balance
        );
    }

    public void displayTransactionHistory() {

        System.out.println(
                "\n----- Transaction History -----"
        );

        if (transactions.isEmpty()) {

            System.out.println(
                    "No transactions found."
            );

            return;
        }

        for (Transaction transaction :
                transactions) {

            transaction.displayTransaction();
        }
    }
}
