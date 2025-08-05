package com.antipatterns.featureenvy;

/**
 * Customer class with data for Feature Envy demonstration
 */
public class Customer {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private double creditLimit;
    private double currentBalance;
    
    public Customer(String name, String email, String address, String phoneNumber, 
                   double creditLimit, double currentBalance) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creditLimit = creditLimit;
        this.currentBalance = currentBalance;
    }
    
    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public double getCreditLimit() { return creditLimit; }
    public double getCurrentBalance() { return currentBalance; }
    
    // Setters
    public void setCurrentBalance(double currentBalance) { 
        this.currentBalance = currentBalance; 
    }
}
