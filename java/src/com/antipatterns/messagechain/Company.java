package com.antipatterns.messagechain;

/**
 * Company class for Message Chain demonstration
 */
public class Company {
    private String name;
    private Department department;
    
    public Company(String name, Department department) {
        this.name = name;
        this.department = department;
    }
    
    public String getName() { return name; }
    public Department getDepartment() { return department; }
}
