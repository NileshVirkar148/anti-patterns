package com.antipatterns.messagechain;

/**
 * MESSAGE CHAIN ANTI-PATTERN EXAMPLE
 * 
 * This demonstrates the "Message Chain" anti-pattern where client code
 * navigates through a chain of objects to get information, creating
 * tight coupling and violating the Law of Demeter.
 * 
 * Problems with this approach:
 * - Violates Law of Demeter (Don't talk to strangers)
 * - Creates tight coupling
 * - Fragile code - breaks when intermediate structure changes
 * - Hard to maintain and modify
 */

/**
 * MESSAGE CHAIN ANTI-PATTERN: This class demonstrates long chains
 * of method calls that violate the Law of Demeter.
 */
public class ProjectReportMessageChain {
    
    /**
     * MESSAGE CHAIN: Long chain of getters to access deeply nested data
     * project.getProjectManager().getCompany().getDepartment().getAddress().getCity()
     */
    public void generateProjectLocationReport(Project project) {
        System.out.println("=== Generating Project Location Report (Message Chain) ===");
        
        // MESSAGE CHAIN VIOLATION: Long chain of method calls
        // This violates the Law of Demeter - we're talking to "strangers"
        String projectName = project.getName();
        String managerName = project.getProjectManager().getName();
        String managerEmail = project.getProjectManager().getEmail();
        String companyName = project.getProjectManager().getCompany().getName();
        String departmentName = project.getProjectManager().getCompany().getDepartment().getName();
        String building = project.getProjectManager().getCompany().getDepartment().getBuilding();
        String street = project.getProjectManager().getCompany().getDepartment().getAddress().getStreet();
        String city = project.getProjectManager().getCompany().getDepartment().getAddress().getCity();
        String state = project.getProjectManager().getCompany().getDepartment().getAddress().getState();
        String zipCode = project.getProjectManager().getCompany().getDepartment().getAddress().getZipCode();
        
        System.out.println("Project: " + projectName);
        System.out.println("Manager: " + managerName + " (" + managerEmail + ")");
        System.out.println("Company: " + companyName);
        System.out.println("Department: " + departmentName);
        System.out.println("Building: " + building);
        System.out.println("Address: " + street + ", " + city + ", " + state + " " + zipCode);
    }
    
    /**
     * MESSAGE CHAIN: Multiple long chains in conditional logic
     */
    public boolean isProjectInCalifornia(Project project) {
        System.out.println("=== Checking if project is in California (Message Chain) ===");
        
        // Another message chain violation
        String state = project.getProjectManager().getCompany().getDepartment().getAddress().getState();
        boolean inCalifornia = "California".equalsIgnoreCase(state) || "CA".equalsIgnoreCase(state);
        
        System.out.println("Project " + project.getName() + " is in California: " + inCalifornia);
        return inCalifornia;
    }
    
    /**
     * MESSAGE CHAIN: Calculating tax based on deeply nested location data
     */
    public double calculateProjectTax(Project project, double amount) {
        System.out.println("=== Calculating Project Tax (Message Chain) ===");
        
        // Multiple message chains in complex logic
        String state = project.getProjectManager().getCompany().getDepartment().getAddress().getState();
        String city = project.getProjectManager().getCompany().getDepartment().getAddress().getCity();
        String zipCode = project.getProjectManager().getCompany().getDepartment().getAddress().getZipCode();
        
        double taxRate = 0.0;
        
        // Tax calculation based on location (using message chains)
        if ("California".equalsIgnoreCase(state) || "CA".equalsIgnoreCase(state)) {
            taxRate = 0.10;
            if ("San Francisco".equalsIgnoreCase(city)) {
                taxRate += 0.02; // Additional city tax
            } else if ("Los Angeles".equalsIgnoreCase(city)) {
                taxRate += 0.015; // Additional city tax
            }
        } else if ("Texas".equalsIgnoreCase(state) || "TX".equalsIgnoreCase(state)) {
            taxRate = 0.0625;
        } else if ("New York".equalsIgnoreCase(state) || "NY".equalsIgnoreCase(state)) {
            taxRate = 0.08;
            if ("New York City".equalsIgnoreCase(city) || zipCode.startsWith("100")) {
                taxRate += 0.045; // NYC tax
            }
        }
        
        double tax = amount * taxRate;
        System.out.println("Tax calculation for " + project.getName() + ":");
        System.out.println("  Location: " + city + ", " + state + " " + zipCode);
        System.out.println("  Tax rate: " + (taxRate * 100) + "%");
        System.out.println("  Tax amount: $" + tax);
        
        return tax;
    }
    
    /**
     * MESSAGE CHAIN: Sending notifications using long chains
     */
    public void sendProjectNotification(Project project, String message) {
        System.out.println("=== Sending Project Notification (Message Chain) ===");
        
        // Long message chain to get manager's email
        String managerEmail = project.getProjectManager().getEmail();
        String managerName = project.getProjectManager().getName();
        String companyName = project.getProjectManager().getCompany().getName();
        String departmentName = project.getProjectManager().getCompany().getDepartment().getName();
        
        System.out.println("Sending notification to:");
        System.out.println("  Manager: " + managerName);
        System.out.println("  Email: " + managerEmail);
        System.out.println("  Company: " + companyName);
        System.out.println("  Department: " + departmentName);
        System.out.println("  Message: " + message);
        
        // Simulate email sending
        System.out.println("Email sent successfully!");
    }
    
    /**
     * MESSAGE CHAIN: Complex validation using multiple chains
     */
    public boolean validateProjectSetup(Project project) {
        System.out.println("=== Validating Project Setup (Message Chain) ===");
        
        boolean isValid = true;
        
        // Multiple message chains for validation
        if (project.getName() == null || project.getName().trim().isEmpty()) {
            System.out.println("ERROR: Project name is required");
            isValid = false;
        }
        
        if (project.getProjectManager() == null) {
            System.out.println("ERROR: Project manager is required");
            isValid = false;
        } else {
            // Nested message chains in validation
            if (project.getProjectManager().getName() == null || 
                project.getProjectManager().getName().trim().isEmpty()) {
                System.out.println("ERROR: Project manager name is required");
                isValid = false;
            }
            
            if (project.getProjectManager().getEmail() == null || 
                !project.getProjectManager().getEmail().contains("@")) {
                System.out.println("ERROR: Valid project manager email is required");
                isValid = false;
            }
            
            if (project.getProjectManager().getCompany() == null) {
                System.out.println("ERROR: Project manager's company is required");
                isValid = false;
            } else {
                // Even deeper message chains
                if (project.getProjectManager().getCompany().getName() == null ||
                    project.getProjectManager().getCompany().getName().trim().isEmpty()) {
                    System.out.println("ERROR: Company name is required");
                    isValid = false;
                }
                
                if (project.getProjectManager().getCompany().getDepartment() == null) {
                    System.out.println("ERROR: Department is required");
                    isValid = false;
                } else {
                    // Very deep message chains
                    if (project.getProjectManager().getCompany().getDepartment().getAddress() == null) {
                        System.out.println("ERROR: Department address is required");
                        isValid = false;
                    } else {
                        // Deepest message chains
                        if (project.getProjectManager().getCompany().getDepartment().getAddress().getCity() == null ||
                            project.getProjectManager().getCompany().getDepartment().getAddress().getCity().trim().isEmpty()) {
                            System.out.println("ERROR: City is required");
                            isValid = false;
                        }
                        
                        if (project.getProjectManager().getCompany().getDepartment().getAddress().getState() == null ||
                            project.getProjectManager().getCompany().getDepartment().getAddress().getState().trim().isEmpty()) {
                            System.out.println("ERROR: State is required");
                            isValid = false;
                        }
                    }
                }
            }
        }
        
        System.out.println("Project validation result: " + (isValid ? "VALID" : "INVALID"));
        return isValid;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Message Chain Anti-Pattern Example ===\n");
        
        // Create test data with nested structure
        Address address = new Address("123 Tech Street", "San Francisco", "California", "94105");
        Department department = new Department("Engineering", "Building A", address);
        Company company = new Company("Tech Corp", department);
        Employee manager = new Employee("John Doe", "john.doe@techcorp.com", company);
        Project project = new Project("Mobile App Development", manager);
        
        ProjectReportMessageChain reporter = new ProjectReportMessageChain();
        
        // Demonstrate message chains
        reporter.generateProjectLocationReport(project);
        System.out.println();
        
        reporter.isProjectInCalifornia(project);
        System.out.println();
        
        reporter.calculateProjectTax(project, 10000.0);
        System.out.println();
        
        reporter.sendProjectNotification(project, "Project milestone completed!");
        System.out.println();
        
        reporter.validateProjectSetup(project);
        
        System.out.println("\n--- Problems with Message Chains ---");
        System.out.println("1. Violates Law of Demeter (Don't talk to strangers)");
        System.out.println("2. Creates tight coupling between classes");
        System.out.println("3. Fragile code - breaks when intermediate structure changes");
        System.out.println("4. Hard to test and mock dependencies");
        System.out.println("5. Difficult to maintain and refactor");
        System.out.println("6. Long chains like: project.getManager().getCompany().getDepartment().getAddress().getCity()");
    }
}
