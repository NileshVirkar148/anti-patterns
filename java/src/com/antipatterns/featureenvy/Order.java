package com.antipatterns.featureenvy;

/**
 * Order class for Feature Envy demonstration
 */
public class Order {
    private String orderId;
    private double amount;
    private String status;
    
    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = "PENDING";
    }
    
    public String getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
