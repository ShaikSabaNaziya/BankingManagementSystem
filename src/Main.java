
import java.util.Scanner;

import exception.AccountNotFoundException;
import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

import model.AccountType;
import model.BankAccount;

import service.Bank;

import util.InputValidator;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();

        boolean running = true;

        while (running) {

            displayMenu();

            int choice =
                InputValidator.readInt(
                        scanner,
                        "Enter your choice: "
                );
            switch (choice) {

                case 1:
                    createAccount(scanner, bank);
                    break;

                case 2:
                    depositMoney(scanner, bank);
                    break;

                case 3:
                    withdrawMoney(scanner, bank);
                    break;

                case 4:
                    checkBalance(scanner, bank);
                    break;

                case 5:
                    bank.displayAllAccounts();
                    break;

                case 6:
                    transferMoney(scanner, bank);
                    break;

                case 7:
                    displayTransactions(scanner, bank);
                    break;

                case 8:
                    System.out.println(
                            "\nThank you for using the Banking Management System."
                    );
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n================================");
        System.out.println("       BANKING MANAGEMENT SYSTEM");
        System.out.println("================================");

        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Display All Accounts");
        System.out.println("6. Transfer Money");
        System.out.println("7. Transaction History");
        System.out.println("8. Exit");

        System.out.println("================================");
    }

    private static void createAccount(
            Scanner scanner,
            Bank bank) {

        System.out.println("\n===== CREATE ACCOUNT =====");

        String name =
                InputValidator.readString(
                        scanner,
                        "Enter customer name: "
                );

        String phone =
                InputValidator.readString(
                        scanner,
                        "Enter phone number: "
                );

        System.out.println("\nSelect account type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");

        int typeChoice =
                InputValidator.readInt(
                        scanner,
                        "Enter choice: "
                );

        AccountType accountType;

        if (typeChoice == 1) {

            accountType = AccountType.SAVINGS;

        } else if (typeChoice == 2) {

            accountType = AccountType.CURRENT;

        } else {

            System.out.println(
                    "Invalid account type."
            );

            return;
        }

        double initialDeposit =
                InputValidator.readDouble(
                        scanner,
                        "Enter initial deposit: "
                );

        BankAccount account =
                bank.createAccount(
                        name,
                        phone,
                        accountType,
                        initialDeposit
                );

        if (account != null) {

            System.out.println(
                    "Account Number: " +
                    account.getAccountNumber()
            );
        }
    }

    private static void depositMoney(
            Scanner scanner,
            Bank bank) {

        System.out.println("\n===== DEPOSIT MONEY =====");

        System.out.print(
                "Enter account number: "
        );

        int accountNumber =
                InputValidator.readInt(
                        scanner,
                        "Enter account number: "
                );

        try {

            BankAccount account =
                    bank.findAccount(accountNumber);

            System.out.print(
                    "Enter amount: "
            );

            double amount =
                InputValidator.readDouble(
                        scanner,
                        "Enter amount: "
                );
            account.deposit(amount);

        } catch (AccountNotFoundException |
                 InvalidAmountException e) {

            System.out.println(
                    "Deposit failed: " +
                    e.getMessage()
            );
        }
    }

    private static void withdrawMoney(
            Scanner scanner,
            Bank bank) {

        System.out.println("\n===== WITHDRAW MONEY =====");

        System.out.print(
                "Enter account number: "
        );

        int accountNumber =
                InputValidator.readInt(
                        scanner,
                        "Enter account number: "
                );
        try {

            BankAccount account =
                    bank.findAccount(accountNumber);

            System.out.print(
                    "Enter amount: "
            );

            double amount =
                InputValidator.readDouble(
                        scanner,
                        "Enter amount: "
                );

            account.withdraw(amount);

        } catch (AccountNotFoundException |
                 InvalidAmountException |
                 InsufficientBalanceException e) {

            System.out.println(
                    "Withdrawal failed: " +
                    e.getMessage()
            );
        }
    }

    private static void checkBalance(
            Scanner scanner,
            Bank bank) {

        System.out.println("\n===== CHECK BALANCE =====");

        System.out.print(
                "Enter account number: "
        );

        int accountNumber = scanner.nextInt();

        try {

            BankAccount account =
                    bank.findAccount(accountNumber);

            System.out.println(
                    "\nAccount Holder: " +
                    account.getAccountHolderName()
            );

            System.out.println(
                    "Account Number: " +
                    account.getAccountNumber()
            );

            System.out.println(
                    "Balance: ₹" +
                    account.getBalance()
            );

        } catch (AccountNotFoundException e) {

            System.out.println(
                    "Account lookup failed: " +
                    e.getMessage()
            );
        }
    }

    private static void transferMoney(
            Scanner scanner,
            Bank bank) {

        System.out.println("\n===== TRANSFER MONEY =====");

        System.out.print(
                "Enter sender account number: "
        );

        int senderNumber =
                InputValidator.readInt(
                        scanner,
                        "Enter sender account number: "
                );
                
        System.out.print(
                "Enter receiver account number: "
        );

        int receiverNumber =
                InputValidator.readInt(
                        scanner,
                        "Enter receiver account number: "
                );

        try {

            BankAccount sender =
                    bank.findAccount(senderNumber);

            BankAccount receiver =
                    bank.findAccount(receiverNumber);

            System.out.print(
                    "Enter transfer amount: "
            );

            double amount =
                InputValidator.readDouble(
                        scanner,
                        "Enter transfer amount: "
                );
                
            sender.transfer(
                    receiver,
                    amount
            );

        } catch (AccountNotFoundException |
                 InvalidAmountException |
                 InsufficientBalanceException e) {

            System.out.println(
                    "Transfer failed: " +
                    e.getMessage()
            );
        }
    }

    private static void displayTransactions(
            Scanner scanner,
            Bank bank) {

        System.out.println(
                "\n===== TRANSACTION HISTORY ====="
        );

        System.out.print(
                "Enter account number: "
        );

        int accountNumber = scanner.nextInt();

        try {

            BankAccount account =
                    bank.findAccount(accountNumber);

            account.displayTransactionHistory();

        } catch (AccountNotFoundException e) {

            System.out.println(
                    "Transaction history failed: " +
                    e.getMessage()
            );
        }
    }
}

