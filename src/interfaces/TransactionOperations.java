package interfaces;

import model.BankAccount;

public interface TransactionOperations {

    void deposit(double amount);

    void withdraw(double amount);

    void transfer(BankAccount receiver, double amount);
}