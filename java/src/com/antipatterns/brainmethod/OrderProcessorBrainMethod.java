package com.antipatterns.brainmethod;

import java.util.*;

/**
 * BRAIN METHOD ANTI-PATTERN EXAMPLE
 * 
 * This class demonstrates the "Brain Method" anti-pattern where a single method
 * is overly complex, doing too many things, and has high cyclomatic complexity.
 * 
 * Problems with this approach:
 * - Hard to understand and maintain
 * - Difficult to test all code paths
 * - High cyclomatic complexity
 * - Violates Single Responsibility Principle at method level
 * - Prone to bugs
 */
public class OrderProcessorBrainMethod {
    
    /**
     * BRAIN METHOD: This method does EVERYTHING related to order processing
     * Cyclomatic complexity: Very high (many decision points)
     * Lines of code: Too many
     * Responsibilities: Too many
     */
    public String processOrder(Map<String, Object> orderData) {
        System.out.println("=== Processing order (Brain Method) ===");
        
        // Extract and validate customer data
        String customerName = (String) orderData.get("customerName");
        String customerEmail = (String) orderData.get("customerEmail");
        String customerPhone = (String) orderData.get("customerPhone");
        String customerAddress = (String) orderData.get("customerAddress");
        String customerType = (String) orderData.get("customerType");
        
        // Complex validation logic embedded in the method
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("ERROR: Customer name is required");
            return "FAILED: Invalid customer name";
        }
        
        if (customerEmail == null || !customerEmail.contains("@") || !customerEmail.contains(".")) {
            System.out.println("ERROR: Valid email is required");
            return "FAILED: Invalid email";
        }
        
        if (customerPhone == null || customerPhone.length() < 10) {
            System.out.println("ERROR: Valid phone number is required");
            return "FAILED: Invalid phone";
        }
        
        if (customerAddress == null || customerAddress.length() < 10) {
            System.out.println("ERROR: Complete address is required");
            return "FAILED: Invalid address";
        }
        
        // Extract and validate order items
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> items = (List<Map<String, Object>>) orderData.get("items");
        if (items == null || items.isEmpty()) {
            System.out.println("ERROR: Order must contain at least one item");
            return "FAILED: No items";
        }
        
        double totalAmount = 0.0;
        double totalWeight = 0.0;
        boolean hasFragileItems = false;
        boolean hasHazardousItems = false;
        int totalQuantity = 0;
        
        // Complex item processing logic
        for (Map<String, Object> item : items) {
            String itemName = (String) item.get("name");
            Integer quantity = (Integer) item.get("quantity");
            Double price = (Double) item.get("price");
            Double weight = (Double) item.get("weight");
            String category = (String) item.get("category");
            Boolean fragile = (Boolean) item.get("fragile");
            Boolean hazardous = (Boolean) item.get("hazardous");
            
            // Validate each item
            if (itemName == null || itemName.trim().isEmpty()) {
                System.out.println("ERROR: Item name is required");
                return "FAILED: Invalid item name";
            }
            
            if (quantity == null || quantity <= 0) {
                System.out.println("ERROR: Valid quantity is required for " + itemName);
                return "FAILED: Invalid quantity";
            }
            
            if (price == null || price <= 0) {
                System.out.println("ERROR: Valid price is required for " + itemName);
                return "FAILED: Invalid price";
            }
            
            if (weight == null || weight <= 0) {
                System.out.println("ERROR: Valid weight is required for " + itemName);
                return "FAILED: Invalid weight";
            }
            
            // Check item availability
            if (category != null && category.equals("electronics") && quantity > 5) {
                System.out.println("ERROR: Electronics limited to 5 per order");
                return "FAILED: Electronics quantity limit exceeded";
            }
            
            if (category != null && category.equals("books") && quantity > 20) {
                System.out.println("ERROR: Books limited to 20 per order");
                return "FAILED: Books quantity limit exceeded";
            }
            
            // Calculate totals
            totalAmount += price * quantity;
            totalWeight += weight * quantity;
            totalQuantity += quantity;
            
            // Check special item types
            if (fragile != null && fragile) {
                hasFragileItems = true;
            }
            
            if (hazardous != null && hazardous) {
                hasHazardousItems = true;
            }
            
            // Apply category-specific logic
            if (category != null) {
                switch (category.toLowerCase()) {
                    case "electronics":
                        totalAmount += 5.0; // Electronics handling fee
                        break;
                    case "books":
                        if (quantity > 10) {
                            totalAmount *= 0.95; // 5% discount for bulk books
                        }
                        break;
                    case "clothing":
                        if (totalAmount > 100) {
                            totalAmount *= 0.9; // 10% discount for clothing over $100
                        }
                        break;
                    case "food":
                        // Food items expire quickly, check if in stock
                        if (Math.random() > 0.8) { // Simulate 20% chance of out of stock
                            System.out.println("ERROR: Food item " + itemName + " is out of stock");
                            return "FAILED: Food item out of stock";
                        }
                        break;
                }
            }
        }
        
        // Apply customer type discounts
        if (customerType != null) {
            switch (customerType.toLowerCase()) {
                case "premium":
                    totalAmount *= 0.85; // 15% discount
                    break;
                case "gold":
                    totalAmount *= 0.9; // 10% discount
                    break;
                case "silver":
                    totalAmount *= 0.95; // 5% discount
                    break;
                case "student":
                    totalAmount *= 0.92; // 8% discount
                    break;
                case "senior":
                    totalAmount *= 0.88; // 12% discount
                    break;
            }
        }
        
        // Calculate shipping
        double shippingCost = 0.0;
        if (totalWeight < 2.0) {
            shippingCost = 5.0;
        } else if (totalWeight < 5.0) {
            shippingCost = 10.0;
        } else if (totalWeight < 10.0) {
            shippingCost = 15.0;
        } else {
            shippingCost = 25.0;
        }
        
        // Apply shipping modifiers
        if (hasFragileItems) {
            shippingCost += 10.0; // Fragile handling
        }
        
        if (hasHazardousItems) {
            shippingCost += 20.0; // Hazardous handling
            // Check if hazardous shipping is allowed to this address
            if (customerAddress.toLowerCase().contains("po box")) {
                System.out.println("ERROR: Cannot ship hazardous items to PO Box");
                return "FAILED: Hazardous shipping restriction";
            }
        }
        
        // International shipping logic
        if (customerAddress.toLowerCase().contains("canada")) {
            shippingCost += 15.0;
        } else if (customerAddress.toLowerCase().contains("mexico")) {
            shippingCost += 12.0;
        } else if (customerAddress.toLowerCase().contains("uk") || 
                   customerAddress.toLowerCase().contains("united kingdom")) {
            shippingCost += 25.0;
        } else if (customerAddress.toLowerCase().contains("australia")) {
            shippingCost += 30.0;
        }
        
        // Apply order size modifiers
        if (totalAmount > 100) {
            shippingCost *= 0.5; // 50% off shipping for orders over $100
        }
        
        if (totalQuantity > 10) {
            shippingCost += 5.0; // Extra handling for large orders
        }
        
        // Calculate taxes
        double taxRate = 0.08; // Default 8%
        if (customerAddress.toLowerCase().contains("california")) {
            taxRate = 0.10;
        } else if (customerAddress.toLowerCase().contains("texas")) {
            taxRate = 0.0625;
        } else if (customerAddress.toLowerCase().contains("oregon")) {
            taxRate = 0.0; // No sales tax in Oregon
        } else if (customerAddress.toLowerCase().contains("new york")) {
            taxRate = 0.08;
        }
        
        double taxAmount = totalAmount * taxRate;
        double finalTotal = totalAmount + shippingCost + taxAmount;
        
        // Payment processing logic
        String paymentMethod = (String) orderData.get("paymentMethod");
        if (paymentMethod == null) {
            System.out.println("ERROR: Payment method is required");
            return "FAILED: No payment method";
        }
        
        switch (paymentMethod.toLowerCase()) {
            case "credit":
                String creditCardNumber = (String) orderData.get("creditCardNumber");
                if (creditCardNumber == null || creditCardNumber.length() != 16) {
                    System.out.println("ERROR: Valid credit card number required");
                    return "FAILED: Invalid credit card";
                }
                // Simulate credit card processing
                if (Math.random() > 0.95) { // 5% chance of failure
                    System.out.println("ERROR: Credit card declined");
                    return "FAILED: Payment declined";
                }
                break;
            case "paypal":
                String paypalEmail = (String) orderData.get("paypalEmail");
                if (paypalEmail == null || !paypalEmail.contains("@")) {
                    System.out.println("ERROR: Valid PayPal email required");
                    return "FAILED: Invalid PayPal email";
                }
                break;
            case "bank":
                String bankAccount = (String) orderData.get("bankAccount");
                if (bankAccount == null || bankAccount.length() < 10) {
                    System.out.println("ERROR: Valid bank account required");
                    return "FAILED: Invalid bank account";
                }
                break;
            default:
                System.out.println("ERROR: Unsupported payment method: " + paymentMethod);
                return "FAILED: Unsupported payment method";
        }
        
        // Generate order confirmation
        String orderId = "ORD-" + System.currentTimeMillis();
        StringBuilder confirmation = new StringBuilder();
        confirmation.append("ORDER PROCESSED SUCCESSFULLY\n");
        confirmation.append("Order ID: ").append(orderId).append("\n");
        confirmation.append("Customer: ").append(customerName).append("\n");
        confirmation.append("Email: ").append(customerEmail).append("\n");
        confirmation.append("Items: ").append(totalQuantity).append("\n");
        confirmation.append("Subtotal: $").append(String.format("%.2f", totalAmount)).append("\n");
        confirmation.append("Shipping: $").append(String.format("%.2f", shippingCost)).append("\n");
        confirmation.append("Tax: $").append(String.format("%.2f", taxAmount)).append("\n");
        confirmation.append("Total: $").append(String.format("%.2f", finalTotal)).append("\n");
        confirmation.append("Payment: ").append(paymentMethod).append("\n");
        
        // Send confirmation email (simulated)
        System.out.println("Sending confirmation email to: " + customerEmail);
        
        // Update inventory (simulated)
        System.out.println("Updating inventory for " + items.size() + " items");
        
        // Log order for analytics (simulated)
        System.out.println("Logging order for analytics: " + orderId);
        
        return confirmation.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Brain Method Anti-Pattern Example ===\n");
        
        OrderProcessorBrainMethod processor = new OrderProcessorBrainMethod();
        
        // Create sample order data
        Map<String, Object> orderData = new HashMap<>();
        orderData.put("customerName", "John Doe");
        orderData.put("customerEmail", "john.doe@example.com");
        orderData.put("customerPhone", "1234567890");
        orderData.put("customerAddress", "123 Main St, California, USA");
        orderData.put("customerType", "premium");
        orderData.put("paymentMethod", "credit");
        orderData.put("creditCardNumber", "1234567890123456");
        
        // Create items
        List<Map<String, Object>> items = new ArrayList<>();
        
        Map<String, Object> item1 = new HashMap<>();
        item1.put("name", "Laptop");
        item1.put("quantity", 1);
        item1.put("price", 999.99);
        item1.put("weight", 3.5);
        item1.put("category", "electronics");
        item1.put("fragile", true);
        item1.put("hazardous", false);
        items.add(item1);
        
        Map<String, Object> item2 = new HashMap<>();
        item2.put("name", "Book");
        item2.put("quantity", 3);
        item2.put("price", 15.99);
        item2.put("weight", 0.5);
        item2.put("category", "books");
        item2.put("fragile", false);
        item2.put("hazardous", false);
        items.add(item2);
        
        orderData.put("items", items);
        
        // Process the order using the brain method
        String result = processor.processOrder(orderData);
        System.out.println("\nResult:\n" + result);
        
        System.out.println("\n--- Problems with this Brain Method ---");
        System.out.println("1. Very high cyclomatic complexity (many if/else, switch statements)");
        System.out.println("2. Too many responsibilities in one method");
        System.out.println("3. Hard to test all code paths");
        System.out.println("4. Difficult to maintain and modify");
        System.out.println("5. Hard to understand the flow");
        System.out.println("6. Prone to bugs due to complexity");
        System.out.println("7. Violates Single Responsibility Principle");
    }
}
