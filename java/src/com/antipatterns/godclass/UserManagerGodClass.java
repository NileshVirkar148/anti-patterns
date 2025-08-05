package com.antipatterns.godclass;

/**
 * GOD CLASS ANTI-PATTERN EXAMPLE
 * 
 * This class demonstrates the "God Class" anti-pattern where a single class
 * has too many responsibilities and knows/does too much.
 * 
 * Problems with this approach:
 * - Violates Single Responsibility Principle
 * - Hard to maintain and test
 * - High coupling and low cohesion
 * - Difficult to understand
 */
public class UserManagerGodClass {
    
    // User data management
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    
    // Database connection fields
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    
    // Email configuration
    private String smtpServer;
    private int smtpPort;
    private String emailUser;
    private String emailPassword;
    
    // File handling
    private String logFilePath;
    private String configFilePath;
    
    // Constructor that does too much
    public UserManagerGodClass(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        
        // Initialize database connection
        this.dbUrl = "jdbc:mysql://localhost:3306/users";
        this.dbUser = "admin";
        this.dbPassword = "password123";
        
        // Initialize email settings
        this.smtpServer = "smtp.gmail.com";
        this.smtpPort = 587;
        this.emailUser = "admin@company.com";
        this.emailPassword = "emailpass123";
        
        // Initialize file paths
        this.logFilePath = "/var/log/user_manager.log";
        this.configFilePath = "/etc/user_manager.conf";
        
        // Auto-create user in database
        createUserInDatabase();
        
        // Auto-send welcome email
        sendWelcomeEmail();
        
        // Auto-log user creation
        logUserCreation();
    }
    
    // Database operations - should be in a separate DAO class
    public void createUserInDatabase() {
        // Simulate database connection and user creation
        System.out.println("Connecting to database: " + dbUrl);
        System.out.println("Creating user: " + firstName + " " + lastName);
        validateUserData();
        hashPassword();
        insertUserRecord();
        updateUserStatistics();
    }
    
    public void updateUserInDatabase() {
        System.out.println("Updating user in database...");
        validateUserData();
        updateUserRecord();
        updateUserStatistics();
    }
    
    public void deleteUserFromDatabase() {
        System.out.println("Deleting user from database...");
        deleteUserRecord();
        updateUserStatistics();
        archiveUserData();
    }
    
    // Email operations - should be in a separate EmailService class
    public void sendWelcomeEmail() {
        System.out.println("Connecting to SMTP server: " + smtpServer + ":" + smtpPort);
        System.out.println("Sending welcome email to: " + email);
        composeWelcomeMessage();
        sendEmail();
    }
    
    public void sendPasswordResetEmail() {
        System.out.println("Sending password reset email to: " + email);
        generateResetToken();
        composeResetMessage();
        sendEmail();
    }
    
    public void sendNewsletterEmail() {
        System.out.println("Sending newsletter to: " + email);
        composeNewsletterMessage();
        sendEmail();
    }
    
    // File operations - should be in a separate FileService class
    public void logUserCreation() {
        System.out.println("Logging user creation to: " + logFilePath);
        writeToLogFile("User created: " + firstName + " " + lastName);
    }
    
    public void saveUserToFile() {
        System.out.println("Saving user data to file...");
        formatUserData();
        writeToUserFile();
    }
    
    public void loadUserFromFile() {
        System.out.println("Loading user data from file...");
        readFromUserFile();
        parseUserData();
    }
    
    // Validation logic - should be in a separate Validator class
    public boolean validateUserData() {
        return validateEmail() && validatePhoneNumber() && validateName();
    }
    
    public boolean validateEmail() {
        if (email == null || !email.contains("@")) {
            System.out.println("Invalid email format");
            return false;
        }
        return true;
    }
    
    public boolean validatePhoneNumber() {
        if (phoneNumber == null || phoneNumber.length() < 10) {
            System.out.println("Invalid phone number");
            return false;
        }
        return true;
    }
    
    public boolean validateName() {
        if (firstName == null || firstName.trim().isEmpty() || 
            lastName == null || lastName.trim().isEmpty()) {
            System.out.println("Invalid name");
            return false;
        }
        return true;
    }
    
    // Security operations - should be in a separate SecurityService class
    public String hashPassword() {
        System.out.println("Hashing password...");
        return "hashed_password_" + System.currentTimeMillis();
    }
    
    public String generateResetToken() {
        System.out.println("Generating reset token...");
        return "reset_token_" + System.currentTimeMillis();
    }
    
    // Utility methods that make this class even more bloated
    private void insertUserRecord() {
        System.out.println("Inserting user record into database...");
    }
    
    private void updateUserRecord() {
        System.out.println("Updating user record in database...");
    }
    
    private void deleteUserRecord() {
        System.out.println("Deleting user record from database...");
    }
    
    private void updateUserStatistics() {
        System.out.println("Updating user statistics...");
    }
    
    private void archiveUserData() {
        System.out.println("Archiving user data...");
    }
    
    private void composeWelcomeMessage() {
        System.out.println("Composing welcome message...");
    }
    
    private void composeResetMessage() {
        System.out.println("Composing reset message...");
    }
    
    private void composeNewsletterMessage() {
        System.out.println("Composing newsletter message...");
    }
    
    private void sendEmail() {
        System.out.println("Sending email via SMTP...");
    }
    
    private void writeToLogFile(String message) {
        System.out.println("Writing to log file: " + message);
    }
    
    private void writeToUserFile() {
        System.out.println("Writing user data to file...");
    }
    
    private void readFromUserFile() {
        System.out.println("Reading user data from file...");
    }
    
    private void formatUserData() {
        System.out.println("Formatting user data for file output...");
    }
    
    private void parseUserData() {
        System.out.println("Parsing user data from file...");
    }
    
    // Getters and setters (adding to the bloat)
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    // Main method to demonstrate the God Class
    public static void main(String[] args) {
        System.out.println("=== God Class Anti-Pattern Example ===\n");
        
        UserManagerGodClass user = new UserManagerGodClass("John", "Doe", "john.doe@example.com");
        
        System.out.println("\n--- Additional operations ---");
        user.updateUserInDatabase();
        user.sendPasswordResetEmail();
        user.saveUserToFile();
        
        System.out.println("\n--- Problems with this God Class ---");
        System.out.println("1. Too many responsibilities (database, email, file, validation, security)");
        System.out.println("2. Hard to test individual components");
        System.out.println("3. Changes in one area might break another");
        System.out.println("4. Violates Single Responsibility Principle");
        System.out.println("5. High coupling, low cohesion");
    }
}
