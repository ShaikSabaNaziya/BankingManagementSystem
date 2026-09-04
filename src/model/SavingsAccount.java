package model;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public class SavingsAccount extends BankAccount {

    private static final double INTEREST_RATE = 4.0;

    public SavingsAccount(
            int accountNumber,
            String accountHolderName,
            double balance) {

        super(
                accountNumber,
                accountHolderName,
                balance
        );
    }

    @Override
    public void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient balance."
            );
        }

        setBalance(
                getBalance() - amount
        );

        addTransaction(
                "WITHDRAW",
                amount
        );

        System.out.println(
                "Withdrawal successful."
        );

        System.out.println(
                "Current balance: ₹" +
                getBalance()
        );
    }

    @Override
    public double calculateInterest() {

        return getBalance()
                * INTEREST_RATE
                / 100;
    }

    @Override
    public void transfer(
            BankAccount receiver,
            double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Transfer amount must be greater than zero."
            );
        }

        if (amount > getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient balance for transfer."
            );
        }

        setBalance(
                getBalance() - amount
        );

        addTransaction(
                "TRANSFER TO ACCOUNT " +
                receiver.getAccountNumber(),
                amount
        );

        receiver.deposit(amount);

        System.out.println(
                "Transfer successful."
        );
    }
}