import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import model.BankAccount;
import model.SavingsAccount;
import model.CurrentAccount;
import service.Bank;

public class Main {

    public static void main(String[] args) {

        // Create Bank
        Bank bank = new Bank();


        // =========================
        // CREATE ACCOUNTS
        // =========================

        BankAccount account1 =
                new SavingsAccount(
                        1001,
                        "Saba",
                        10000
                );

        BankAccount account2 =
                new CurrentAccount(
                        2001,
                        "Saba",
                        20000
                );


        // Add accounts to bank
        bank.addAccount(account1);
        bank.addAccount(account2);


        // =========================
        // DISPLAY ALL ACCOUNTS
        // =========================

        bank.displayAllAccounts();


        // =========================
        // FIND ACCOUNT
        // =========================

        System.out.println("\n===== ACCOUNT SEARCH =====");

        BankAccount searchedAccount =
                bank.findAccount(1001);

        if (searchedAccount != null) {

            searchedAccount.displayAccountDetails();

        } else {

            System.out.println(
                    "Account not found."
            );
        }


        // =========================
        // DEPOSIT
        // =========================

        System.out.println("\n===== DEPOSIT =====");

        try {

            searchedAccount.deposit(5000);

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Deposit failed: " +
                    e.getMessage()
            );
        }


        // =========================
        // WITHDRAW
        // =========================

        System.out.println("\n===== WITHDRAW =====");

        try {

            searchedAccount.withdraw(2000);

        } catch (InvalidAmountException |
                 InsufficientBalanceException e) {

            System.out.println(
                    "Withdrawal failed: " +
                    e.getMessage()
            );
        }


        // =========================
        // TRANSFER
        // =========================

        System.out.println("\n===== TRANSFER =====");

        BankAccount receiver =
                bank.findAccount(2001);

        try {

            searchedAccount.transfer(
                    receiver,
                    2000
            );

        } catch (InvalidAmountException |
                 InsufficientBalanceException e) {

            System.out.println(
                    "Transfer failed: " +
                    e.getMessage()
            );
        }


        // =========================
        // FINAL ACCOUNT DETAILS
        // =========================

        System.out.println(
                "\n===== FINAL ACCOUNT DETAILS ====="
        );

        bank.displayAllAccounts();
    }
}