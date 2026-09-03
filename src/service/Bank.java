package service;

import java.util.HashMap;
import java.util.Map;

import model.BankAccount;

public class Bank {

    private Map<Integer, BankAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account) {

        accounts.put(
                account.getAccountNumber(),
                account
        );

        System.out.println(
                "Account added successfully."
        );
    }

    public BankAccount findAccount(int accountNumber) {

        return accounts.get(accountNumber);
    }

    public void displayAllAccounts() {

        System.out.println("\n===== ALL BANK ACCOUNTS =====");

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (BankAccount account : accounts.values()) {

            account.displayAccountDetails();
        }
    }
}
