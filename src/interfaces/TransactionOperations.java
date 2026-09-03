package interfaces;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import model.BankAccount;

public interface TransactionOperations {

    void deposit(double amount)
            throws InvalidAmountException;

    void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException;

    void transfer(BankAccount receiver, double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException;
}