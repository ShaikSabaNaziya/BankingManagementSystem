package model;

public class SavingsAccount extends BankAccount {

    private static final double INTEREST_RATE = 4.0;

    public SavingsAccount(int accountNumber,
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

        if (amount > getBalance()) {
            System.out.println("Insufficient balance.");
            return;
        }

        setBalance(getBalance() - amount);

        System.out.println("Withdrawal successful.");
        System.out.println("Current balance: ₹" + getBalance());
    }

    @Override
    public double calculateInterest() {

        return getBalance() * INTEREST_RATE / 100;
    }
}