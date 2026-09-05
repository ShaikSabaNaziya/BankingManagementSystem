package model;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public class CurrentAccount extends BankAccount {

    private static final double MINIMUM_BALANCE = 1000.0;

    public CurrentAccount(
            int accountNumber,
            Customer customer,
            double balance) {

        super(
                accountNumber,
                customer,
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

        if (getBalance() - amount
                < MINIMUM_BALANCE) {

            throw new InsufficientBalanceException(
                    "Minimum balance of ₹"
                    + MINIMUM_BALANCE
                    + " must be maintained."
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

        return 0;
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

        if (getBalance() - amount
                < MINIMUM_BALANCE) {

            throw new InsufficientBalanceException(
                    "Transfer failed. Minimum balance of ₹"
                    + MINIMUM_BALANCE
                    + " must be maintained."
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