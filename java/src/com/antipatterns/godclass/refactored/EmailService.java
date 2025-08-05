package com.antipatterns.godclass.refactored;

/**
 * EMAIL SERVICE
 * 
 * Handles all email operations.
 * Single responsibility: Email sending only.
 */
public class EmailService {
    private String smtpServer;
    private int smtpPort;
    private String emailUser;
    private String emailPassword;
    
    public EmailService(String smtpServer, int smtpPort, String emailUser, String emailPassword) {
        this.smtpServer = smtpServer;
        this.smtpPort = smtpPort;
        this.emailUser = emailUser;
        this.emailPassword = emailPassword;
    }
    
    public void sendWelcomeEmail(User user) {
        System.out.println("Connecting to SMTP server: " + smtpServer + ":" + smtpPort);
        System.out.println("Sending welcome email to: " + user.getEmail());
        String message = composeWelcomeMessage(user);
        sendEmail(user.getEmail(), "Welcome!", message);
    }
    
    public void sendPasswordResetEmail(User user, String resetToken) {
        System.out.println("Sending password reset email to: " + user.getEmail());
        String message = composeResetMessage(user, resetToken);
        sendEmail(user.getEmail(), "Password Reset", message);
    }
    
    public void sendNewsletterEmail(User user) {
        System.out.println("Sending newsletter to: " + user.getEmail());
        String message = composeNewsletterMessage(user);
        sendEmail(user.getEmail(), "Newsletter", message);
    }
    
    private String composeWelcomeMessage(User user) {
        System.out.println("Composing welcome message for: " + user.getFullName());
        return "Welcome " + user.getFullName() + "! Thank you for joining us.";
    }
    
    private String composeResetMessage(User user, String resetToken) {
        System.out.println("Composing reset message for: " + user.getFullName());
        return "Hello " + user.getFullName() + ", your reset token is: " + resetToken;
    }
    
    private String composeNewsletterMessage(User user) {
        System.out.println("Composing newsletter message for: " + user.getFullName());
        return "Hello " + user.getFullName() + ", here's our latest newsletter!";
    }
    
    private void sendEmail(String to, String subject, String message) {
        System.out.println("Sending email via SMTP...");
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
