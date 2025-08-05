package com.antipatterns.messagechain;

/**
 * Project class for Message Chain demonstration
 */
public class Project {
    private String name;
    private Employee projectManager;
    
    public Project(String name, Employee projectManager) {
        this.name = name;
        this.projectManager = projectManager;
    }
    
    public String getName() { return name; }
    public Employee getProjectManager() { return projectManager; }
}
