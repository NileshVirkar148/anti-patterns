package com.antipatterns;

import com.antipatterns.godclass.UserManagerGodClass;
import com.antipatterns.godclass.refactored.*;
import com.antipatterns.brainmethod.OrderProcessorBrainMethod;
import com.antipatterns.featureenvy.OrderProcessorFeatureEnvy;
import com.antipatterns.featureenvy.Customer;
import com.antipatterns.featureenvy.Order;
import com.antipatterns.messagechain.*;
import com.antipatterns.fatinterface.*;

import java.util.*;

/**
 * COMPREHENSIVE JAVA ANTI-PATTERNS DEMONSTRATION
 * 
 * This class demonstrates multiple anti-patterns found in Java codebases
 * as documented by Embold: https://docs.embold.io/anti-patterns/
 * 
 * Anti-patterns included:
 * 1. God Class
 * 2. Brain Method  
 * 3. Feature Envy
 * 4. Message Chain
 * 5. Fat Interface
 */
public class AntiPatternsDemo {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║              JAVA ANTI-PATTERNS DEMONSTRATION               ║");
        System.out.println("║         Based on https://docs.embold.io/anti-patterns/      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        runGodClassDemo();
        runBrainMethodDemo();
        runFeatureEnvyDemo();
        runMessageChainDemo();
        runFatInterfaceDemo();
        
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                        SUMMARY                               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("✅ All anti-pattern examples demonstrated successfully!");
        System.out.println();
        System.out.println("📚 Key Takeaways:");
        System.out.println("• Anti-patterns make code harder to maintain and understand");
        System.out.println("• They often violate SOLID principles");
        System.out.println("• Refactoring can significantly improve code quality");
        System.out.println("• Each anti-pattern has specific symptoms and solutions");
        System.out.println();
        System.out.println("🔧 How to avoid these anti-patterns:");
        System.out.println("• Follow Single Responsibility Principle");
        System.out.println("• Apply Interface Segregation Principle");
        System.out.println("• Use proper encapsulation");
        System.out.println("• Follow Law of Demeter");
        System.out.println("• Regular code reviews and refactoring");
        System.out.println("• Use static analysis tools like Embold");
    }
    
    private static void runGodClassDemo() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                    1. GOD CLASS ANTI-PATTERN                │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        System.out.println("🔴 PROBLEM: God Class (UserManagerGodClass)");
        System.out.println("A class that knows too much and does too much");
        System.out.println();
        
        // Demonstrate God Class
        UserManagerGodClass godClass = new UserManagerGodClass("Jane", "Smith", "jane.smith@example.com");
        
        System.out.println();
        System.out.println("🟢 SOLUTION: Refactored with separated concerns");
        System.out.println();
        
        // Demonstrate refactored solution
        UserDAO userDAO = new UserDAO("jdbc:mysql://localhost:3306/users", "admin", "password123");
        EmailService emailService = new EmailService("smtp.gmail.com", 587, "admin@company.com", "emailpass123");
        UserValidator validator = new UserValidator();
        SecurityService securityService = new SecurityService();
        UserService userService = new UserService(userDAO, emailService, validator, securityService);
        
        User user = new User("Jane", "Smith", "jane.smith@example.com");
        userService.createUser(user, "password123");
        
        System.out.println();
        separator();
    }
    
    private static void runBrainMethodDemo() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                   2. BRAIN METHOD ANTI-PATTERN              │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        System.out.println("🔴 PROBLEM: Brain Method (processOrder)");
        System.out.println("A method that is overly complex and does too many things");
        System.out.println();
        
        OrderProcessorBrainMethod processor = new OrderProcessorBrainMethod();
        
        // Create sample order data
        Map<String, Object> orderData = new HashMap<>();
        orderData.put("customerName", "Alice Johnson");
        orderData.put("customerEmail", "alice.johnson@example.com");
        orderData.put("customerPhone", "1234567890");
        orderData.put("customerAddress", "456 Oak St, New York, USA");
        orderData.put("customerType", "gold");
        orderData.put("paymentMethod", "credit");
        orderData.put("creditCardNumber", "1234567890123456");
        
        List<Map<String, Object>> items = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("name", "Smartphone");
        item.put("quantity", 1);
        item.put("price", 699.99);
        item.put("weight", 0.5);
        item.put("category", "electronics");
        item.put("fragile", true);
        item.put("hazardous", false);
        items.add(item);
        orderData.put("items", items);
        
        String result = processor.processOrder(orderData);
        System.out.println("Order processing result received (truncated for demo)");
        
        System.out.println();
        System.out.println("🟢 SOLUTION: Break down into smaller, focused methods");
        System.out.println("• Separate validation, calculation, and processing logic");
        System.out.println("• Use strategy pattern for different payment methods");
        System.out.println("• Create dedicated classes for each concern");
        
        System.out.println();
        separator();
    }
    
    private static void runFeatureEnvyDemo() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                  3. FEATURE ENVY ANTI-PATTERN               │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        System.out.println("🔴 PROBLEM: Feature Envy (OrderProcessor obsessed with Customer data)");
        System.out.println("Methods that access another class's data more than their own");
        System.out.println();
        
        Customer customer = new Customer("Bob Wilson", "bob.wilson@company.com", 
                                       "789 Pine St, California, USA", "555-0123", 
                                       8000.0, 2000.0);
        Order order = new Order("ORD-002", 500.0);
        
        OrderProcessorFeatureEnvy envyProcessor = new OrderProcessorFeatureEnvy();
        
        boolean creditValid = envyProcessor.validateCustomerCredit(customer, order);
        double discount = envyProcessor.calculateCustomerDiscount(customer, order);
        
        System.out.println();
        System.out.println("🟢 SOLUTION: Move methods to appropriate classes");
        System.out.println("• Customer validation logic should be in Customer class");
        System.out.println("• Customer discount calculation should be in Customer class");
        System.out.println("• Follow 'Tell, Don't Ask' principle");
        
        System.out.println();
        separator();
    }
    
    private static void runMessageChainDemo() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                 4. MESSAGE CHAIN ANTI-PATTERN               │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        System.out.println("🔴 PROBLEM: Message Chain (Long chains of method calls)");
        System.out.println("project.getManager().getCompany().getDepartment().getAddress().getCity()");
        System.out.println();
        
        // Create nested object structure
        Address address = new Address("321 Business Ave", "Austin", "Texas", "78701");
        Department department = new Department("Marketing", "Building B", address);
        Company company = new Company("Marketing Inc", department);
        Employee manager = new Employee("Carol Davis", "carol.davis@marketing.com", company);
        Project project = new Project("Website Redesign", manager);
        
        ProjectReportMessageChain chainReporter = new ProjectReportMessageChain();
        
        chainReporter.generateProjectLocationReport(project);
        boolean inCalifornia = chainReporter.isProjectInCalifornia(project);
        double tax = chainReporter.calculateProjectTax(project, 5000.0);
        
        System.out.println();
        System.out.println("🟢 SOLUTION: Add delegation methods");
        System.out.println("• Add getCity() method to Project class");
        System.out.println("• Add getState() method to Project class");
        System.out.println("• Follow Law of Demeter - only talk to immediate friends");
        
        System.out.println();
        separator();
    }
    
    private static void runFatInterfaceDemo() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                 5. FAT INTERFACE ANTI-PATTERN               │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        System.out.println("🔴 PROBLEM: Fat Interface (MediaPlayerFatInterface)");
        System.out.println("Interface with too many methods, forcing unnecessary implementations");
        System.out.println();
        
        AudioOnlyPlayer audioPlayer = new AudioOnlyPlayer();
        SimpleImageViewer imageViewer = new SimpleImageViewer();
        
        // Show what each can actually do
        System.out.println("AudioOnlyPlayer capabilities:");
        audioPlayer.playAudio("music.mp3");
        audioPlayer.setAudioVolume(80);
        
        System.out.println();
        System.out.println("SimpleImageViewer capabilities:");
        imageViewer.displayImage("picture.jpg");
        imageViewer.zoomIn();
        
        // Show what they can't do (throws exceptions)
        System.out.println();
        System.out.println("Trying to use unsupported features:");
        try {
            audioPlayer.playVideo("movie.mp4");
        } catch (UnsupportedOperationException e) {
            System.out.println("❌ AudioPlayer: " + e.getMessage());
        }
        
        try {
            imageViewer.playAudio("song.mp3");
        } catch (UnsupportedOperationException e) {
            System.out.println("❌ ImageViewer: " + e.getMessage());
        }
        
        System.out.println();
        System.out.println("🟢 SOLUTION: Interface Segregation");
        System.out.println("• Create separate interfaces: AudioPlayer, VideoPlayer, ImageViewer");
        System.out.println("• Each interface should have only methods relevant to its purpose");
        System.out.println("• Clients should not depend on interfaces they don't use");
        
        System.out.println();
        separator();
    }
    
    private static void separator() {
        System.out.println("════════════════════════════════════════════════════════════════");
        System.out.println();
    }
}
