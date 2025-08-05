package com.antipatterns.godclass.refactored;

/**
 * SECURITY SERVICE
 * 
 * Handles all security-related operations.
 * Single responsibility: Security operations only.
 */
public class SecurityService {
    
    public String hashPassword(String password) {
        System.out.println("Hashing password...");
        // In real implementation, use proper hashing like BCrypt
        return "hashed_" + password + "_" + System.currentTimeMillis();
    }
    
    public String generateResetToken(User user) {
        System.out.println("Generating reset token for: " + user.getEmail());
        return "reset_token_" + user.getEmail() + "_" + System.currentTimeMillis();
    }
    
    public String generateSessionToken(User user) {
        System.out.println("Generating session token for: " + user.getEmail());
        return "session_token_" + user.getEmail() + "_" + System.currentTimeMillis();
    }
    
    public boolean validateToken(String token) {
        System.out.println("Validating token: " + token);
        // Simple validation - in real implementation, verify token signature/expiry
        return token != null && token.startsWith("session_token_");
    }
    
    public boolean validateResetToken(String token) {
        System.out.println("Validating reset token: " + token);
        return token != null && token.startsWith("reset_token_");
    }
}
