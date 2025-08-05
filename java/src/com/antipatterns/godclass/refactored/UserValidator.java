package com.antipatterns.godclass.refactored;

/**
 * USER VALIDATOR
 * 
 * Handles all validation logic for users.
 * Single responsibility: Validation only.
 */
public class UserValidator {
    
    public boolean validateUser(User user) {
        return validateEmail(user.getEmail()) && 
               validatePhoneNumber(user.getPhoneNumber()) && 
               validateName(user.getFirstName(), user.getLastName());
    }
    
    public boolean validateEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid email format: " + email);
            return false;
        }
        return true;
    }
    
    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() < 10) {
            System.out.println("Invalid phone number: " + phoneNumber);
            return false;
        }
        return true;
    }
    
    public boolean validateName(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty() || 
            lastName == null || lastName.trim().isEmpty()) {
            System.out.println("Invalid name: firstName='" + firstName + "', lastName='" + lastName + "'");
            return false;
        }
        return true;
    }
    
    public boolean validateAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            System.out.println("Invalid address: " + address);
            return false;
        }
        return true;
    }
}
