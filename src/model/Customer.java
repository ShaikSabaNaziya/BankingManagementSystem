package model;

public class Customer{
    private int customerId;
    private String name;
    private String phone;

    public Customer(int customerId, String name, String phone){
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    public void displayCustomerDetails(){
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
    }
}

