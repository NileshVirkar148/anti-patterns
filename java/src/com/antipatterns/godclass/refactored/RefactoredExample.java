package com.antipatterns.godclass.refactored;

/**
 * REFACTORED SOLUTION DEMO
 * 
 * This demonstrates how to properly structure code to avoid the God Class anti-pattern.
 * Each class has a single responsibility and they work together through composition.
 */
public class RefactoredExample {
    
    public static void main(String[] args) {
        System.out.println("=== Refactored Solution (No God Class) ===\n");
        
        // Create individual service instances with dependency injection
        UserDAO userDAO = new UserDAO("jdbc:mysql://localhost:3306/users", "admin", "password123");
        EmailService emailService = new EmailService("smtp.gmail.com", 587, "admin@company.com", "emailpass123");
        UserValidator validator = new UserValidator();
        SecurityService securityService = new SecurityService();
        
        // Create the coordinator service
        UserService userService = new UserService(userDAO, emailService, validator, securityService);
        
        // Create a user
        User user = new User("John", "Doe", "john.doe@example.com");
        user.setPhoneNumber("1234567890");
        user.setAddress("123 Main St, City, State");
        
        // Use the service to perform operations
        userService.createUser(user, "password123");
        
        System.out.println("\n--- Additional operations ---");
        user.setPhoneNumber("0987654321");
        userService.updateUser(user);
        userService.sendPasswordReset(user);
        
        System.out.println("\n--- Benefits of this refactored approach ---");
        System.out.println("1. Single Responsibility Principle: Each class has one job");
        System.out.println("2. Easy to test: Each component can be tested independently");
        System.out.println("3. Easy to maintain: Changes are localized to specific classes");
        System.out.println("4. Flexible: Easy to swap implementations (e.g., different email service)");
        System.out.println("5. Reusable: Services can be used in different contexts");
        System.out.println("6. Low coupling: Classes depend on abstractions, not concrete implementations");
        
        System.out.println("\n--- Class responsibilities ---");
        System.out.println("• User: Holds user data only");
        System.out.println("• UserDAO: Database operations only");
        System.out.println("• EmailService: Email sending only");
        System.out.println("• UserValidator: Validation logic only");
        System.out.println("• SecurityService: Security operations only");
        System.out.println("• UserService: Coordinates other services");
    }
}
