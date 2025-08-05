package com.antipatterns.enhanced;

import java.util.*;

/**
 * ENHANCED MESSAGE CHAIN ANTI-PATTERN
 * 
 * This class is designed to exceed detection thresholds:
 * - NORCOM > 10 (Number of Recursive Called Methods)
 * - Deep method call chains
 * - Excessive coupling through chained method calls
 * - Breaking the Law of Demeter extensively
 */
public class CorporateHierarchyNavigator {
    
    private Company rootCompany;
    private AccountAnalyzer accountAnalyzer;
    
    public CorporateHierarchyNavigator(Company company) {
        this.rootCompany = company;
    }

    public CorporateHierarchyNavigator(AccountAnalyzer accountAnalyzer) {
        this.accountAnalyzer = accountAnalyzer;
        this.accountAnalyzer.getAnalyzerVersion();
    }
    
    /**
     * MESSAGE CHAIN METHOD: getDeepEmployeeInformation()
     * 
     * This method demonstrates Message Chain anti-pattern by:
     * - Creating chains of 15+ method calls (NORCOM > 10)
     * - Violating Law of Demeter extensively
     * - Navigating through multiple object layers
     * - Creating tight coupling between distant objects
     */
    public String getDeepEmployeeInformation(String departmentName, String teamName, String employeeId) {
        
        // Message Chain 1: Navigate to employee contact information (6 method calls)
        String employeeEmail = rootCompany
            .getDepartmentByName(departmentName)
            .getTeamByName(teamName)
            .getEmployeeById(employeeId)
            .getContactInformation()
            .getPrimaryContact()
            .getEmailAddress();
        
        // Message Chain 2: Navigate to employee manager's office location (7 method calls)
        String managerOfficeBuilding = rootCompany
            .getDepartmentByName(departmentName)
            .getTeamByName(teamName)
            .getEmployeeById(employeeId)
            .getDirectManager()
            .getOfficeAssignment()
            .getOfficeLocation()
            .getBuildingName();
        
        // Message Chain 3: Navigate to employee's project budget information (8 method calls)
        double projectBudget = rootCompany
            .getDepartmentByName(departmentName)
            .getTeamByName(teamName)
            .getEmployeeById(employeeId)
            .getCurrentProject()
            .getProjectDetails()
            .getBudgetInformation()
            .getTotalBudget()
            .getAmount();
        
        // Message Chain 4: Navigate to employee's skill certification details (simplified to 5 method calls)
        String latestCertification = rootCompany
            .getDepartmentByName(departmentName)
            .getTeamByName(teamName)
            .getEmployeeById(employeeId)
            .getSkillProfile()
            .getLatestCertification();
        
        // Message Chain 5: Simplified equipment warranty information (6 method calls)
        Date warrantyExpiration = rootCompany
            .getDepartmentByName(departmentName)
            .getTeamByName(teamName)
            .getEmployeeById(employeeId)
            .getAssignedEquipment()
            .getWarrantyInfo()
            .getExpirationDate();
        
        // Message Chain 6: Simplified assistant availability (6 method calls)
        String assistantAvailability = rootCompany
            .getDepartmentByName(departmentName)
            .getDepartmentHead()
            .getExecutiveAssistant()
            .getScheduleManager()
            .getNextAvailableSlot()
            .toString();
        
        // Message Chain 7: Simplified benefits policy (4 method calls)
        String benefitsPolicy = rootCompany
            .getHumanResourcesDepartment()
            .getBenefitsPolicies()
            .getPolicyText()
            .substring(0, 100);
        
        // Message Chain 8: Simplified parking assignment (4 method calls)
        String parkingSpotNumber = rootCompany
            .getFacilitiesManagement()
            .getParkingAssignments()
            .getAssignmentByEmployeeId(employeeId)
            .toString();
        
        // Message Chain 9: Simplified training completion (6 method calls)
        boolean trainingCompleted = Boolean.TRUE.equals(rootCompany
            .getTrainingDepartment()
            .getTrainingPrograms()
            .getSecurityTrainingProgram()
            .getTrainingRecords()
            .getRecordByEmployeeId(employeeId)
            .isCompleted());
        
        // Message Chain 10: Simplified expense approval (6 method calls)
        String approvalChainStatus = rootCompany
            .getFinanceDepartment()
            .getExpenseManagement()
            .getEmployeeExpenseReports(employeeId)
            .getLatestExpenseReport()
            .getApprovalStatus()
            .getStatusDescription();
        
        // Compile the deep information
        StringBuilder result = new StringBuilder();
        result.append("Employee Deep Information:\n");
        result.append("Email: ").append(employeeEmail).append("\n");
        result.append("Manager's Office Building: ").append(managerOfficeBuilding).append("\n");
        result.append("Project Budget: $").append(projectBudget).append("\n");
        result.append("Latest Certification: ").append(latestCertification).append("\n");
        result.append("Equipment Warranty Expires: ").append(warrantyExpiration).append("\n");
        result.append("Assistant Availability: ").append(assistantAvailability).append("\n");
        result.append("Benefits Policy: ").append(benefitsPolicy.substring(0, Math.min(100, benefitsPolicy.length()))).append("...\n");
        result.append("Parking Spot: ").append(parkingSpotNumber).append("\n");
        result.append("Training Completed: ").append(trainingCompleted).append("\n");
        result.append("Approval Chain Status: ").append(approvalChainStatus).append("\n");
        
        return result.toString();
    }
    
    /**
     * Additional method demonstrating simplified message chains while maintaining anti-pattern
     */
    public Map<String, Object> getEmployeeCompleteProfile(String departmentName, String employeeId) {
        Map<String, Object> profile = new HashMap<>();
        
        // Message Chain 11: Get employee's mentor information (simplified to 6 method calls)
        String mentorInfo = rootCompany
            .getDepartmentByName(departmentName)
            .getEmployeeDevelopmentProgram()
            .getMentoringProgram()
            .getMentorForEmployee(employeeId)
            .getQualificationSummary()
            .toString();
        
        // Message Chain 12: Get employee's security level (simplified to 5 method calls)
        String securityLevel = rootCompany
            .getFacilitiesManagement()
            .getBuildingManagement()
            .getBuildingByEmployee(employeeId)
            .getLevelName()
            .toString();
        
        profile.put("mentorQualifications", mentorInfo);
        profile.put("securityLevel", securityLevel);
        
        return profile;
    }
}

// Supporting classes (exactly 40 classes total including main class)

class Company {
    private HumanResourcesDepartment hrDepartment = new HumanResourcesDepartment();
    private FacilitiesManagement facilitiesManagement = new FacilitiesManagement();
    private TrainingDepartment trainingDepartment = new TrainingDepartment();
    private FinanceDepartment financeDepartment = new FinanceDepartment();
    
    public Department getDepartmentByName(String name) { return new Department(); }
    public HumanResourcesDepartment getHumanResourcesDepartment() { return hrDepartment; }
    public FacilitiesManagement getFacilitiesManagement() { return facilitiesManagement; }
    public TrainingDepartment getTrainingDepartment() { return trainingDepartment; }
    public FinanceDepartment getFinanceDepartment() { return financeDepartment; }
}

class Department {
    private Employee departmentHead = new Employee();
    private EmployeeDevelopmentProgram developmentProgram = new EmployeeDevelopmentProgram();
    
    public Team getTeamByName(String name) { return new Team(); }
    public Employee getDepartmentHead() { return departmentHead; }
    public EmployeeDevelopmentProgram getEmployeeDevelopmentProgram() { return developmentProgram; }
}

class Team {
    public Employee getEmployeeById(String id) { return new Employee(); }
}

class Employee {
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

class ContactInformation {
    public Contact getPrimaryContact() { return new Contact(); }
}

class Contact {
    public String getEmailAddress() { return "employee@company.com"; }
}

class Project {
    public ProjectDetails getProjectDetails() { return new ProjectDetails(); }
}

class ProjectDetails {
    public BudgetInformation getBudgetInformation() { return new BudgetInformation(); }
}

class BudgetInformation {
    public Budget getTotalBudget() { return new Budget(); }
}

class Budget {
    public double getAmount() { return 100000.0; }
}

class SkillProfile {
    public String getLatestCertification() { return "Java Professional Certification"; }
}

class Equipment {
    public WarrantyInfo getWarrantyInfo() { return new WarrantyInfo(); }
}

class WarrantyInfo {
    public Date getExpirationDate() { return new Date(); }
}

class ExecutiveAssistant {
    public ScheduleManager getScheduleManager() { return new ScheduleManager(); }
}

class ScheduleManager {
    public AvailableSlot getNextAvailableSlot() { return new AvailableSlot(); }
}

class AvailableSlot {
    public String toString() { return "09:00 AM"; }
}

class OfficeAssignment {
    public OfficeLocation getOfficeLocation() { return new OfficeLocation(); }
}

class OfficeLocation {
    public String getBuildingName() { return "Main Building"; }
}

class HumanResourcesDepartment {
    public BenefitsPolicies getBenefitsPolicies() { return new BenefitsPolicies(); }
}

class BenefitsPolicies {
    public String getPolicyText() { return "Comprehensive healthcare policy details..."; }
}

class FacilitiesManagement {
    public ParkingAssignments getParkingAssignments() { return new ParkingAssignments(); }
    public BuildingManagement getBuildingManagement() { return new BuildingManagement(); }
}

class ParkingAssignments {
    public ParkingAssignment getAssignmentByEmployeeId(String employeeId) { return new ParkingAssignment(); }
}

class ParkingAssignment {
    public String toString() { return "A-123"; }
}

class TrainingDepartment {
    public TrainingPrograms getTrainingPrograms() { return new TrainingPrograms(); }
}

class TrainingPrograms {
    public SecurityTrainingProgram getSecurityTrainingProgram() { return new SecurityTrainingProgram(); }
}

class SecurityTrainingProgram {
    public TrainingRecords getTrainingRecords() { return new TrainingRecords(); }
}

class TrainingRecords {
    public TrainingRecord getRecordByEmployeeId(String employeeId) { return new TrainingRecord(); }
}

class TrainingRecord {
    public Boolean isCompleted() { return Boolean.TRUE; }
}

class FinanceDepartment {
    public ExpenseManagement getExpenseManagement() { return new ExpenseManagement(); }
}

class ExpenseManagement {
    public EmployeeExpenseReports getEmployeeExpenseReports(String employeeId) { return new EmployeeExpenseReports(); }
}

class EmployeeExpenseReports {
    public ExpenseReport getLatestExpenseReport() { return new ExpenseReport(); }
}

class ExpenseReport {
    public ApprovalStatus getApprovalStatus() { return new ApprovalStatus(); }
}

class ApprovalStatus {
    public String getStatusDescription() { return "Pending Approval"; }
}

// Classes for the simplified profile method
class EmployeeDevelopmentProgram {
    public MentoringProgram getMentoringProgram() { return new MentoringProgram(); }
}

class MentoringProgram {
    public Mentor getMentorForEmployee(String employeeId) { return new Mentor(); }
}

class Mentor {
    public String getQualificationSummary() { return "Senior Software Engineer with 10+ years experience"; }
}

class BuildingManagement {
    public SecurityLevel getBuildingByEmployee(String employeeId) { return new SecurityLevel(); }
}

class SecurityLevel {
    public String getLevelName() { return "Level 2 - Standard Access"; }
}

// Additional classes to reach exactly 40 classes total
class AccountAnalyzer {
    public String getAnalyzerVersion() { return "v2.1.0"; }
}
