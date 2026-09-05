package model;

import java.time.LocalDateTime;

public class Transaction {

    private TransactionType type;
    private double amount;
    private LocalDateTime dateTime;
    private String description;

    public Transaction(
            TransactionType type,
            double amount,
            String description) {

        this.type = type;
        this.amount = amount;
        this.description = description;
        this.dateTime = LocalDateTime.now();
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void displayTransaction() {

        System.out.println(
                dateTime +
                " | " +
                type +
                " | ₹" +
                amount +
                " | " +
                description
        );
    }
}