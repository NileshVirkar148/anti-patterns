package com.antipatterns.enhanced.model;

public class Employee {
    private ContactInformation contactInfo = new ContactInformation();
    private Employee directManager = new Employee();
    private Project currentProject = new Project();
    private SkillProfile skillProfile = new SkillProfile();
    private Equipment assignedEquipment = new Equipment();
    private ExecutiveAssistant executiveAssistant = new ExecutiveAssistant();
    private OfficeAssignment officeAssignment = new OfficeAssignment();
    
    public ContactInformation getContactInformation() { return contactInfo; }
    public Employee getDirectManager() { return directManager; }
    public Project getCurrentProject() { return currentProject; }
    public SkillProfile getSkillProfile() { return skillProfile; }
    public Equipment getAssignedEquipment() { return assignedEquipment; }
    public ExecutiveAssistant getExecutiveAssistant() { return executiveAssistant; }
    public OfficeAssignment getOfficeAssignment() { return officeAssignment; }
}
