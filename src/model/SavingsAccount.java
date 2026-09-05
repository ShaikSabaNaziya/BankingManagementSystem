package model;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public class SavingsAccount extends BankAccount {

    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(
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

        if (amount > getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient balance."
            );
        }

        setBalance(
                getBalance() - amount
        );

        addTransaction(
                TransactionType.WITHDRAW,
                amount,
                "Cash withdrawal"
        );

        System.out.println(
                "Amount withdrawn successfully."
        );

        System.out.println(
                "Current balance: ₹" +
                getBalance()
        );
    }

    @Override
    public double calculateInterest() {

        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void transfer(
            BankAccount receiver,
            double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (receiver == null) {

            throw new InvalidAmountException(
                    "Receiver account cannot be null."
            );
        }

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
                TransactionType.TRANSFER_SENT,
                amount,
                "To Account " +
                receiver.getAccountNumber()
        );

        receiver.addTransaction(
                TransactionType.TRANSFER_RECEIVED,
                amount,
                "From Account " +
                getAccountNumber()
        );

        receiver.setBalance(
                receiver.getBalance() + amount
        );

        System.out.println(
                "Transfer completed successfully."
        );

        System.out.println(
                "Transferred ₹" +
                amount +
                " to Account " +
                receiver.getAccountNumber()
        );

        System.out.println(
                "Current balance: ₹" +
                getBalance()
        );
    }
}
