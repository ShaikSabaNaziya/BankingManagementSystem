import model.BankAccount;
import model.SavingsAccount;
import model.CurrentAccount;

public class Main {

    public static void main(String[] args) {

        // Runtime Polymorphism
        // Parent class reference pointing to child class objects

        BankAccount account1 =
                new SavingsAccount(1001, "Saba", 10000);

        BankAccount account2 =
                new CurrentAccount(2001, "Saba", 20000);


        // =========================
        // SAVINGS ACCOUNT
        // =========================

        System.out.println("\n===== SAVINGS ACCOUNT =====");

        account1.displayAccountDetails();

        System.out.println("\nDepositing ₹5000...");
        account1.deposit(5000);

        System.out.println("\nWithdrawing ₹3000...");
        account1.withdraw(3000);

        System.out.println(
                "\nInterest: ₹" + account1.calculateInterest()
        );


        // =========================
        // CURRENT ACCOUNT
        // =========================

        System.out.println("\n===== CURRENT ACCOUNT =====");

        account2.displayAccountDetails();

        System.out.println("\nDepositing ₹5000...");
        account2.deposit(5000);

        System.out.println("\nWithdrawing ₹3000...");
        account2.withdraw(3000);

        System.out.println(
                "\nInterest: ₹" + account2.calculateInterest()
        );
    }
}