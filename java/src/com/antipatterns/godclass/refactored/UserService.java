package com.antipatterns.godclass.refactored;

/**
 * USER SERVICE - COORDINATOR CLASS
 * 
 * This class coordinates between different services to provide
 * high-level user management operations. It demonstrates proper
 * separation of concerns and dependency injection.
 */
public class UserService {
    private final UserDAO userDAO;
    private final EmailService emailService;
    private final UserValidator validator;
    private final SecurityService securityService;
    
    public UserService(UserDAO userDAO, EmailService emailService, 
                      UserValidator validator, SecurityService securityService) {
        this.userDAO = userDAO;
        this.emailService = emailService;
        this.validator = validator;
        this.securityService = securityService;
    }
    
    public boolean createUser(User user, String password) {
        System.out.println("=== Creating user: " + user.getFullName() + " ===");
        
        // Validate user data
        if (!validator.validateUser(user)) {
            System.out.println("User validation failed!");
            return false;
        }
        
        // Hash password
        String hashedPassword = securityService.hashPassword(password);
        System.out.println("Password hashed successfully");
        
        // Save to database
        userDAO.createUser(user);
        
        // Send welcome email
        emailService.sendWelcomeEmail(user);
        
        System.out.println("User created successfully!");
        return true;
    }
    
    public boolean updateUser(User user) {
        System.out.println("=== Updating user: " + user.getFullName() + " ===");
        
        if (!validator.validateUser(user)) {
            System.out.println("User validation failed!");
            return false;
        }
        
        userDAO.updateUser(user);
        System.out.println("User updated successfully!");
        return true;
    }
    
    public void deleteUser(User user) {
        System.out.println("=== Deleting user: " + user.getFullName() + " ===");
        userDAO.deleteUser(user);
        System.out.println("User deleted successfully!");
    }
    
    public void sendPasswordReset(User user) {
        System.out.println("=== Sending password reset for: " + user.getFullName() + " ===");
        String resetToken = securityService.generateResetToken(user);
        emailService.sendPasswordResetEmail(user, resetToken);
        System.out.println("Password reset email sent!");
    }
    
    public User findUserByEmail(String email) {
        if (!validator.validateEmail(email)) {
            return null;
        }
        return userDAO.findUserByEmail(email);
    }
}
