package com.antipatterns.enhanced;

import java.util.*;
import com.antipatterns.fatinterface.*;

/**
 * COMPREHENSIVE ANTI-PATTERN DEMONSTRATION
 * 
 * This class demonstrates all enhanced anti-patterns that exceed
 * the detection thresholds specified in apconfig.xml:
 * 
 * 1. MegaApplicationManager - God Class (LOC > 195, WMC > 47, CBO > 30)
 * 2. ComplexDataProcessor - Brain Method (LOC > 80, Cyclomatic Complexity > 20)
 * 3. AccountAnalyzer - Feature Envy (ATFD > 4, FDP < 4, LAA < 0.33)
 * 4. CorporateHierarchyNavigator - Message Chain (NORCOM > 10)
 * 5. MediaPlayerFatInterface - Fat Interface (NOM Count > 10)
 * 
 * Expected detection results:
 * - All anti-patterns should be detected by tools using the config thresholds
 * - Metrics should significantly exceed minimum detection values
 * - Real-world complexity that mirrors actual problematic code
 */
public class AntiPatternDemonstration {
    
    public static void main(String[] args) {
        System.out.println("=== ENHANCED ANTI-PATTERN DEMONSTRATIONS ===\n");
        
        demonstrateGodClass();
        demonstrateBrainMethod();
        demonstrateFeatureEnvy();
        demonstrateMessageChain();
        demonstrateFatInterface();
        
        System.out.println("\n=== ALL DEMONSTRATIONS COMPLETED ===");
        System.out.println("These examples are designed to exceed the following thresholds:");
        System.out.println("- God Class: CBO Count > 30");
        System.out.println("- Brain Method: LOC > 80, Cyclomatic Complexity > 20");
        System.out.println("- Feature Envy: ATFD > 4, FDP < 4, LAA < 0.33");
        System.out.println("- Message Chain: NORCOM > 10");
        System.out.println("- Fat Interface: NOM Count > 10");
        System.out.println("- LOC Class (VeryHigh): > 195");
        System.out.println("- WMC Class (VeryHigh): > 47");
    }
    
    /**
     * Demonstrates God Class Anti-Pattern
     * - 800+ lines of code (LOC >> 195)
     * - 60+ methods (WMC >> 47)
     * - 35+ coupled classes (CBO >> 30)
     */
    private static void demonstrateGodClass() {
        System.out.println("1. GOD CLASS DEMONSTRATION");
        System.out.println("   Class: MegaApplicationManager");
        System.out.println("   Metrics: LOC ~800+, WMC ~60+, CBO ~35+");
        System.out.println("   Responsibilities: Database, Files, Network, Security, Concurrency, etc.");
        
        try {
            MegaApplicationManager manager = new MegaApplicationManager();
            manager.logOperation("God Class demonstration initialized");
            System.out.println("   ✓ God Class created successfully");
        } catch (Exception e) {
            System.out.println("   ⚠ God Class creation encountered expected complexity: " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates Brain Method Anti-Pattern
     * - 120+ lines in single method (LOC >> 80)
     * - 25+ cyclomatic complexity (CC >> 20)
     * - Deep nesting and complex logic
     */
    private static void demonstrateBrainMethod() {
        System.out.println("2. BRAIN METHOD DEMONSTRATION");
        System.out.println("   Class: ComplexDataProcessor");
        System.out.println("   Method: processComplexBusinessLogic()");
        System.out.println("   Metrics: LOC ~120+, Cyclomatic Complexity ~25+");
        
        ComplexDataProcessor processor = new ComplexDataProcessor();
        
        String testData = "# Test data\nuser001,create,100,active\nuser002,update,200,pending";
        Map<String, String> params = new HashMap<>();
        params.put("email", "test@example.com");
        params.put("age", "25");
        
        List<String> rules = Arrays.asList("min_length:10", "pattern:.*user.*");
        Set<String> operations = new HashSet<>(Arrays.asList("create", "update", "delete"));
        
        try {
            Map<String, Object> result = processor.processComplexBusinessLogic(
                testData, params, rules, operations, true, 3
            );
            System.out.println("   ✓ Brain Method executed with " + result.size() + " result fields");
        } catch (Exception e) {
            System.out.println("   ⚠ Brain Method complexity demonstrated: " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates Feature Envy Anti-Pattern
     * - 29+ foreign attribute accesses (ATFD >> 4)
     * - 3 foreign data providers (FDP < 4)
     * - Minimal local attribute usage (LAA << 0.33)
     */
    private static void demonstrateFeatureEnvy() {
        System.out.println("3. FEATURE ENVY DEMONSTRATION");
        System.out.println("   Class: AccountAnalyzer");
        System.out.println("   Method: analyzeCustomerAccount()");
        System.out.println("   Metrics: ATFD ~29+, FDP = 3, LAA ~0.07");
        
        // Create test objects
        Customer customer = new Customer("John", "Doe", "john.doe@example.com");
        customer.setAnnualIncome(75000);
        customer.setCreditScore("720");
        customer.setDateOfBirth(new Date(System.currentTimeMillis() - (25L * 365 * 24 * 60 * 60 * 1000))); // 25 years ago
        
        Account account = new Account("ACC-12345", "CHECKING");
        account.setCurrentBalance(15000);
        account.setMinimumBalance(500);
        account.setInterestRate(0.02);
        account.addAccountFeature("PREMIUM");
        
        Transaction transaction = new Transaction("TXN-001", 500.0, "DEBIT");
        transaction.setDescription("ATM Withdrawal");
        transaction.setLocation("Downtown Branch");
        
        AccountAnalyzer analyzer = new AccountAnalyzer();
        
        try {
            Map<String, Object> analysis = analyzer.analyzeCustomerAccount(customer, account, transaction);
            System.out.println("   ✓ Feature Envy method analyzed " + analysis.size() + " data points");
            System.out.println("   ✓ Extensive foreign data access demonstrated");
        } catch (Exception e) {
            System.out.println("   ⚠ Feature Envy complexity: " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * Demonstrates Message Chain Anti-Pattern
     * - 15+ method call chains (NORCOM >> 10)
     * - Deep object navigation
     * - Law of Demeter violations
     */
    private static void demonstrateMessageChain() {
        System.out.println("4. MESSAGE CHAIN DEMONSTRATION");
        System.out.println("   Class: CorporateHierarchyNavigator");
        System.out.println("   Methods: getDeepEmployeeInformation(), getEmployeeCompleteProfile()");
        System.out.println("   Metrics: NORCOM ~17+ method chains");
        
        // Note: Due to the complexity of setting up the full object hierarchy,
        // this would typically result in null pointer exceptions in a real demo.
        // The important part is the code structure showing the long method chains.
        
        Company company = new Company();
        CorporateHierarchyNavigator navigator = new CorporateHierarchyNavigator(company);
        
        System.out.println("   ✓ Message Chain class created");
        System.out.println("   ✓ Long method call chains defined (15+ levels deep)");
        System.out.println("   ✓ Law of Demeter extensively violated");
        System.out.println("   Note: Full execution would require complex object setup");
        System.out.println();
    }
    
    /**
     * Demonstrates Fat Interface Anti-Pattern
     * - 60+ methods in interface (NOM >> 10)
     * - Clients forced to implement unused methods
     * - Interface segregation principle violation
     */
    private static void demonstrateFatInterface() {
        System.out.println("5. FAT INTERFACE DEMONSTRATION");
        System.out.println("   Interface: MediaPlayerFatInterface");
        System.out.println("   Implementations: AudioOnlyPlayer, SimpleImageViewer");
        System.out.println("   Metrics: NOM Count ~60+ methods");
        
        // Create implementations that are forced to implement many unused methods
        MediaPlayerFatInterface audioPlayer = new AudioOnlyPlayer();
        MediaPlayerFatInterface imageViewer = new SimpleImageViewer();
        
        try {
            // AudioPlayer should handle audio but throws exceptions for video/image
            audioPlayer.playAudio("test.mp3");
            audioPlayer.setAudioVolume(50);
            System.out.println("   ✓ Audio player handles audio methods");
            
            try {
                audioPlayer.displayImage("test.jpg"); // Should fail for audio player
            } catch (UnsupportedOperationException e) {
                System.out.println("   ✓ Audio player correctly rejects image operations");
            }
            
            // ImageViewer should handle images but throws exceptions for audio/video
            imageViewer.displayImage("test.jpg");
            imageViewer.zoomIn();
            System.out.println("   ✓ Image viewer handles image methods");
            
            try {
                imageViewer.playAudio("test.mp3"); // Should fail
            } catch (UnsupportedOperationException e) {
                System.out.println("   ✓ Image viewer correctly rejects audio operations");
            }
            
            System.out.println("   ✓ Fat Interface forces clients to implement 60+ unused methods");
            
        } catch (Exception e) {
            System.out.println("   ⚠ Fat Interface complexity: " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * Summary method showing the metrics that should trigger detection
     */
    private static void printDetectionSummary() {
        System.out.println("=== DETECTION THRESHOLD SUMMARY ===");
        System.out.println("Based on apconfig.xml configuration:");
        System.out.println();
        
        System.out.println("MegaApplicationManager (God Class):");
        System.out.println("  - LOC: ~800 (threshold: > 195) ✓");
        System.out.println("  - WMC: ~60 (threshold: > 47) ✓");
        System.out.println("  - CBO: ~35 (threshold: > 30) ✓");
        System.out.println();
        
        System.out.println("ComplexDataProcessor.processComplexBusinessLogic (Brain Method):");
        System.out.println("  - LOC: ~120 (threshold: > 80) ✓");
        System.out.println("  - Cyclomatic Complexity: ~25 (threshold: > 20) ✓");
        System.out.println();
        
        System.out.println("AccountAnalyzer.analyzeCustomerAccount (Feature Envy):");
        System.out.println("  - ATFD: ~29 (threshold: > 4) ✓");
        System.out.println("  - FDP: 3 (threshold: < 4) ✓");
        System.out.println("  - LAA: ~0.07 (threshold: < 0.33) ✓");
        System.out.println();
        
        System.out.println("CorporateHierarchyNavigator (Message Chain):");
        System.out.println("  - NORCOM: ~17 (threshold: > 10) ✓");
        System.out.println();
        
        System.out.println("MediaPlayerFatInterface (Fat Interface):");
        System.out.println("  - NOM Count: ~60 (threshold: > 10) ✓");
        System.out.println();
        
        System.out.println("All anti-patterns should be detected by analysis tools!");
    }
}
