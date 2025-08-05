package com.antipatterns.messagechain;

/**
 * Employee class for Message Chain demonstration
 */
public class Employee {
    private String name;
    private String email;
    private Company company;
    
    public Employee(String name, String email, Company company) {
        this.name = name;
        this.email = email;
        this.company = company;
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Company getCompany() { return company; }
}
