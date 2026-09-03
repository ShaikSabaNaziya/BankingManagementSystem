package model;

public class CurrentAccount extends BankAccount {

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
    public double calculateInterest() {
        return 0;
    }
}