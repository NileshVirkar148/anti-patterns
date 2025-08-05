package com.antipatterns.featureenvy;

/**
 * FEATURE ENVY ANTI-PATTERN EXAMPLE
 * 
 * This demonstrates the "Feature Envy" anti-pattern where a method
 * accesses data and methods from another class more than its own class.
 * 
 * Problems with this approach:
 * - Violates encapsulation
 * - Creates tight coupling
 * - Method is in the wrong class
 * - Difficult to maintain
 */

/**
 * FEATURE ENVY: This class has methods that are obsessed with Customer data
 * and operations, suggesting they should belong to the Customer class instead.
 */
public class OrderProcessorFeatureEnvy {
    
    /**
     * FEATURE ENVY METHOD: This method is more interested in Customer
     * data than its own class data. It accesses Customer fields extensively.
     */
    public boolean validateCustomerCredit(Customer customer, Order order) {
        System.out.println("=== Validating customer credit (Feature Envy) ===");
        
        // This method is obsessed with Customer data!
        // It accesses customer fields more than its own class
        
        System.out.println("Checking credit for customer: " + customer.getName());
        System.out.println("Customer email: " + customer.getEmail());
        System.out.println("Customer address: " + customer.getAddress());
        System.out.println("Customer phone: " + customer.getPhoneNumber());
        
        // Multiple accesses to customer's financial data
        double availableCredit = customer.getCreditLimit() - customer.getCurrentBalance();
        System.out.println("Credit limit: $" + customer.getCreditLimit());
        System.out.println("Current balance: $" + customer.getCurrentBalance());
        System.out.println("Available credit: $" + availableCredit);
        
        // More customer data access
        if (customer.getCurrentBalance() < 0) {
            System.out.println("ERROR: Customer has negative balance!");
            return false;
        }
        
        if (customer.getCreditLimit() <= 0) {
            System.out.println("ERROR: Customer has no credit limit!");
            return false;
        }
        
        // Even more customer-focused logic
        if (availableCredit < order.getAmount()) {
            System.out.println("ERROR: Insufficient credit. Available: $" + availableCredit + 
                             ", Required: $" + order.getAmount());
            return false;
        }
        
        System.out.println("Credit validation passed for " + customer.getName());
        return true;
    }
    
    /**
     * FEATURE ENVY METHOD: This method calculates customer discounts
     * but it's in the wrong class - it should be in Customer class.
     */
    public double calculateCustomerDiscount(Customer customer, Order order) {
        System.out.println("=== Calculating customer discount (Feature Envy) ===");
        
        // This method is obsessed with Customer data and calculations!
        double baseAmount = order.getAmount();
        double discount = 0.0;
        
        // Accessing customer data extensively
        System.out.println("Calculating discount for: " + customer.getName());
        System.out.println("Customer email domain: " + customer.getEmail().split("@")[1]);
        
        // Customer-specific business logic (should be in Customer class)
        double currentBalance = customer.getCurrentBalance();
        double creditLimit = customer.getCreditLimit();
        
        // Complex customer-focused calculations
        if (currentBalance < creditLimit * 0.1) {
            discount += 0.05; // 5% discount for low balance customers
            System.out.println("Low balance discount applied: 5%");
        }
        
        if (creditLimit > 10000) {
            discount += 0.03; // 3% discount for high credit limit customers
            System.out.println("High credit limit discount applied: 3%");
        }
        
        // More customer data access for business rules
        String email = customer.getEmail();
        if (email.endsWith(".edu")) {
            discount += 0.10; // 10% student discount
            System.out.println("Student email discount applied: 10%");
        }
        
        if (email.endsWith(".gov")) {
            discount += 0.05; // 5% government discount
            System.out.println("Government email discount applied: 5%");
        }
        
        // Customer address-based discounts
        String address = customer.getAddress();
        if (address.toLowerCase().contains("california")) {
            discount += 0.02; // 2% California resident discount
            System.out.println("California resident discount applied: 2%");
        }
        
        // Customer loyalty calculation based on customer data
        double loyaltyRatio = currentBalance / creditLimit;
        if (loyaltyRatio > 0.8) {
            discount += 0.07; // 7% high utilization loyalty discount
            System.out.println("High utilization loyalty discount applied: 7%");
        }
        
        // Cap discount at 25%
        if (discount > 0.25) {
            discount = 0.25;
        }
        
        double discountAmount = baseAmount * discount;
        System.out.println("Total discount: " + (discount * 100) + "% ($" + discountAmount + ")");
        
        return discountAmount;
    }
    
    /**
     * FEATURE ENVY METHOD: This method formats customer information
     * but accesses Customer data extensively.
     */
    public String generateCustomerReport(Customer customer) {
        System.out.println("=== Generating customer report (Feature Envy) ===");
        
        // This method is obsessed with formatting Customer data!
        StringBuilder report = new StringBuilder();
        
        // Extensive use of customer data (should be customer's responsibility)
        report.append("=== CUSTOMER REPORT ===\n");
        report.append("Name: ").append(customer.getName()).append("\n");
        report.append("Email: ").append(customer.getEmail()).append("\n");
        report.append("Phone: ").append(customer.getPhoneNumber()).append("\n");
        report.append("Address: ").append(customer.getAddress()).append("\n");
        
        // Customer financial information formatting
        report.append("Credit Limit: $").append(customer.getCreditLimit()).append("\n");
        report.append("Current Balance: $").append(customer.getCurrentBalance()).append("\n");
        
        // Customer-specific calculations
        double availableCredit = customer.getCreditLimit() - customer.getCurrentBalance();
        report.append("Available Credit: $").append(availableCredit).append("\n");
        
        // Customer status determination
        double utilizationRatio = customer.getCurrentBalance() / customer.getCreditLimit();
        report.append("Credit Utilization: ").append(String.format("%.1f%%", utilizationRatio * 100)).append("\n");
        
        // Customer risk assessment
        String riskLevel;
        if (utilizationRatio > 0.9) {
            riskLevel = "HIGH RISK";
        } else if (utilizationRatio > 0.7) {
            riskLevel = "MEDIUM RISK";
        } else {
            riskLevel = "LOW RISK";
        }
        report.append("Risk Level: ").append(riskLevel).append("\n");
        
        // Customer contact preferences based on email domain
        String emailDomain = customer.getEmail().split("@")[1];
        if (emailDomain.equals("gmail.com") || emailDomain.equals("yahoo.com")) {
            report.append("Preferred Contact: Personal Email\n");
        } else if (emailDomain.endsWith(".edu")) {
            report.append("Preferred Contact: Student Email\n");
        } else if (emailDomain.endsWith(".gov")) {
            report.append("Preferred Contact: Government Email\n");
        } else {
            report.append("Preferred Contact: Business Email\n");
        }
        
        return report.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Feature Envy Anti-Pattern Example ===\n");
        
        // Create test data
        Customer customer = new Customer(
            "John Doe",
            "john.doe@university.edu",
            "123 Main St, California, USA",
            "555-1234",
            5000.0,
            1500.0
        );
        
        Order order = new Order("ORD-001", 300.0);
        
        OrderProcessorFeatureEnvy processor = new OrderProcessorFeatureEnvy();
        
        // Demonstrate feature envy methods
        boolean creditValid = processor.validateCustomerCredit(customer, order);
        System.out.println("Credit validation result: " + creditValid + "\n");
        
        double discount = processor.calculateCustomerDiscount(customer, order);
        System.out.println("Calculated discount: $" + discount + "\n");
        
        String report = processor.generateCustomerReport(customer);
        System.out.println("Customer report:\n" + report);
        
        System.out.println("--- Problems with Feature Envy ---");
        System.out.println("1. OrderProcessor methods access Customer data more than their own");
        System.out.println("2. Customer-related logic is scattered outside Customer class");
        System.out.println("3. Violates encapsulation and Tell Don't Ask principle");
        System.out.println("4. Creates tight coupling between OrderProcessor and Customer");
        System.out.println("5. Makes Customer class anemic (data without behavior)");
        System.out.println("6. Hard to maintain - customer logic in multiple places");
    }
}
