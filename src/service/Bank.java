package service;

import java.util.HashMap;
import java.util.Map;

import exception.AccountNotFoundException;
import model.AccountType;
import model.BankAccount;
import model.CurrentAccount;
import model.Customer;
import model.SavingsAccount;

public class Bank {

    private Map<Integer, BankAccount> accounts;

    private static int nextAccountNumber = 1001;
    private static int nextCustomerId = 1;

    public Bank() {
        accounts = new HashMap<>();
    }

    public int generateAccountNumber() {
        return nextAccountNumber++;
    }

    public int generateCustomerId() {
        return nextCustomerId++;
    }

    public boolean addAccount(BankAccount account) {

        if (accounts.containsKey(
                account.getAccountNumber())) {

            System.out.println(
                    "Account number already exists."
            );

            return false;
        }

        accounts.put(
                account.getAccountNumber(),
                account
        );

        System.out.println(
                "Account created successfully."
        );

        return true;
    }

    public BankAccount findAccount(int accountNumber)
            throws AccountNotFoundException {

        BankAccount account =
                accounts.get(accountNumber);

        if (account == null) {

            throw new AccountNotFoundException(
                    "Account " +
                    accountNumber +
                    " not found."
            );
        }

        return account;
    }

    public BankAccount createAccount(
            String name,
            String phone,
            AccountType accountType,
            double initialDeposit) {

        if (name == null ||
                name.trim().isEmpty()) {

            System.out.println(
                    "Customer name cannot be empty."
            );

            return null;
        }

        if (phone == null ||
                phone.trim().isEmpty()) {

            System.out.println(
                    "Phone number cannot be empty."
            );

            return null;
        }

        if (accountType == null) {

            System.out.println(
                    "Account type is required."
            );

            return null;
        }

        if (initialDeposit <= 0) {

            System.out.println(
                    "Initial deposit must be greater than zero."
            );

            return null;
        }

        if (accountType == AccountType.CURRENT
                && initialDeposit < 1000) {

            System.out.println(
                    "Current Account requires a minimum " +
                    "initial deposit of ₹1000."
            );

            return null;
        }

        int customerId =
                generateCustomerId();

        Customer customer =
                new Customer(
                        customerId,
                        name,
                        phone
                );

        int accountNumber =
                generateAccountNumber();

        BankAccount account;

        if (accountType == AccountType.SAVINGS) {

            account =
                    new SavingsAccount(
                            accountNumber,
                            customer,
                            initialDeposit
                    );

        } else {

            account =
                    new CurrentAccount(
                            accountNumber,
                            customer,
                            initialDeposit
                    );
        }

        if (addAccount(account)) {
            return account;
        }

        return null;
    }

    public void displayAllAccounts() {

        System.out.println(
                "\n===== ALL BANK ACCOUNTS ====="
        );

        if (accounts.isEmpty()) {

            System.out.println(
                    "No accounts found."
            );

            return;
        }

        for (BankAccount account :
                accounts.values()) {

            account.displayAccountDetails();
        }
    }
}
