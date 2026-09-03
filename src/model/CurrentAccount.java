package model;

import interfaces.TransactionOperations;

public class CurrentAccount extends BankAccount  {

    private static final double MINIMUM_BALANCE = 1000.0;

    public CurrentAccount(int accountNumber,
                          String accountHolderName,
                          double balance) {

        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        if (getBalance() - amount < MINIMUM_BALANCE) {
            System.out.println(
                "Withdrawal failed. Minimum balance of ₹"
                + MINIMUM_BALANCE
                + " must be maintained."
            );
            return;
        }

        setBalance(getBalance() - amount);

        System.out.println("Withdrawal successful.");
        System.out.println("Current balance: ₹" + getBalance());
    }

    @Override
    public void transfer(BankAccount receiver, double amount) {

        if (amount <= 0) {
            System.out.println(
                    "Transfer amount must be greater than zero."
            );
            return;
        }

        if (amount > getBalance()) {
            System.out.println(
                    "Insufficient balance for transfer."
            );
            return;
        }

        setBalance(getBalance() - amount);

        addTransaction("TRANSFER TO ACCOUNT "
                + receiver.getAccountNumber(), amount);

        receiver.deposit(amount);

        System.out.println(
                "Transfer successful."
        );
    }

    @Override
    public double calculateInterest() {
        return 0;
    }
}