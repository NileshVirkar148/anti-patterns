package com.antipatterns.godclass.refactored;

/**
 * USER DATA ACCESS OBJECT
 * 
 * Handles all database operations for users.
 * Single responsibility: Database operations only.
 */
public class UserDAO {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    
    public UserDAO(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }
    
    public void createUser(User user) {
        System.out.println("Connecting to database: " + dbUrl);
        System.out.println("Creating user: " + user.getFullName());
        insertUserRecord(user);
        updateUserStatistics();
    }
    
    public void updateUser(User user) {
        System.out.println("Updating user in database: " + user.getFullName());
        updateUserRecord(user);
        updateUserStatistics();
    }
    
    public void deleteUser(User user) {
        System.out.println("Deleting user from database: " + user.getFullName());
        deleteUserRecord(user);
        updateUserStatistics();
        archiveUserData(user);
    }
    
    public User findUserByEmail(String email) {
        System.out.println("Finding user by email: " + email);
        // Simulate database lookup
        return new User("John", "Doe", email);
    }
    
    private void insertUserRecord(User user) {
        System.out.println("Inserting user record into database...");
    }
    
    private void updateUserRecord(User user) {
        System.out.println("Updating user record in database...");
    }
    
    private void deleteUserRecord(User user) {
        System.out.println("Deleting user record from database...");
    }
    
    private void updateUserStatistics() {
        System.out.println("Updating user statistics...");
    }
    
    private void archiveUserData(User user) {
        System.out.println("Archiving user data...");
    }
}
