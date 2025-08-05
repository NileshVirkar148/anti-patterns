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
        
        // Message Chain 4: Navigate to employee's skill certification details (9 method calls)
        String latestCertification = rootCompany
            .getDepartmentByName(departmentName)
            .getTeamByName(teamName)
            .getEmployeeById(employeeId)
            .getSkillProfile()
            .getCertifications()
            .getLatestCertification()
            .getCertificationDetails()
            .getCertificationName()
            .getFullName();
        
        // Message Chain 5: Navigate to employee's equipment warranty information (10 method calls)
        Date warrantyExpiration = rootCompany
            .getDepartmentByName(departmentName)
            .getTeamByName(teamName)
            .getEmployeeById(employeeId)
            .getAssignedEquipment()
            .getPrimaryWorkstation()
            .getHardwareDetails()
            .getWarrantyInformation()
            .getWarrantyPeriod()
            .getExpirationDate()
            .getDate();
        
        // Message Chain 6: Navigate to department head's assistant's schedule (11 method calls)
        String assistantAvailability = rootCompany
            .getDepartmentByName(departmentName)
            .getDepartmentHead()
            .getExecutiveAssistant()
            .getScheduleManager()
            .getCurrentWeekSchedule()
            .getAvailableTimeSlots()
            .getNextAvailableSlot()
            .getTimeSlotDetails()
            .getStartTime()
            .getFormattedTime()
            .toString();
        
        // Message Chain 7: Navigate to company policy on employee benefits (12 method calls)
        String benefitsPolicy = rootCompany
            .getHumanResourcesDepartment()
            .getPolicyManagement()
            .getEmployeePolicies()
            .getBenefitsPolicies()
            .getHealthcarePolicies()
            .getPrimaryHealthcarePlan()
            .getPlanDetails()
            .getCoverageInformation()
            .getDetailedCoverage()
            .getPolicyDocument()
            .getDocumentContent()
            .getTextContent();
        
        // Message Chain 8: Navigate to employee's parking assignment details (13 method calls)
        String parkingSpotNumber = rootCompany
            .getFacilitiesManagement()
            .getParkingManagement()
            .getEmployeeParkingAssignments()
            .getAssignmentByEmployeeId(employeeId)
            .getParkingSpotDetails()
            .getSpotLocation()
            .getLocationDetails()
            .getSpotIdentifier()
            .getSpotNumber()
            .getFormattedNumber()
            .getDisplayFormat()
            .getPaddedNumber()
            .toString();
        
        // Message Chain 9: Navigate to employee's training completion status (14 method calls)
        boolean trainingCompleted = Boolean.TRUE.equals(rootCompany
            .getTrainingDepartment()
            .getTrainingPrograms()
            .getMandatoryTrainingPrograms()
            .getSecurityTrainingProgram()
            .getTrainingRecords()
            .getRecordByEmployeeId(employeeId)
            .getCompletionStatus()
            .getLatestCompletionRecord()
            .getCompletionDetails()
            .getVerificationStatus()
            .getVerificationResult()
            .isVerified());
        
        // Message Chain 10: Navigate to employee's expense report approval chain (15 method calls)
        String approvalChainStatus = rootCompany
            .getFinanceDepartment()
            .getExpenseManagement()
            .getExpenseReportSystem()
            .getEmployeeExpenseReports(employeeId)
            .getLatestExpenseReport()
            .getApprovalWorkflow()
            .getCurrentApprovalStep()
            .getApprovalStepDetails()
            .getApproverInformation()
            .getApproverEmployee()
            .getEmployeeDetails()
            .getEmployeeStatus()
            .getStatusInformation()
            .getCurrentStatus()
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
     * Additional method demonstrating more message chains
     */
    public Map<String, Object> getEmployeeCompleteProfile(String departmentName, String employeeId) {
        Map<String, Object> profile = new HashMap<>();
        
        // Message Chain 11: Get employee's mentor's qualifications (16 method calls)
        String mentorQualifications = rootCompany
            .getDepartmentByName(departmentName)
            .getEmployeeDevelopmentProgram()
            .getMentoringProgram()
            .getMentorAssignments()
            .getMentorForEmployee(employeeId)
            .getMentorProfile()
            .getProfessionalQualifications()
            .getEducationalBackground()
            .getHighestDegree()
            .getDegreeDetails()
            .getInstitutionInformation()
            .getInstitutionName()
            .getOfficialName()
            .getFullInstitutionName()
            .getFormattedName()
            .toString();
        
        // Message Chain 12: Get employee's office building's security clearance requirements (17 method calls)
        String securityRequirements = rootCompany
            .getFacilitiesManagement()
            .getBuildingManagement()
            .getBuildingByEmployee(employeeId)
            .getSecurityManagement()
            .getAccessControlSystem()
            .getSecurityClearanceRequirements()
            .getEmployeeClearanceLevel(employeeId)
            .getClearanceDetails()
            .getRequiredClearanceLevel()
            .getClearanceLevelDetails()
            .getClearanceDocumentation()
            .getDocumentationRequirements()
            .getRequiredDocuments()
            .getDocumentList()
            .getPrimaryDocument()
            .getDocumentTitle()
            .toString();
        
        profile.put("mentorQualifications", mentorQualifications);
        profile.put("securityRequirements", securityRequirements);
        
        return profile;
    }
}

// Supporting classes to enable the message chains

class Company {
    private Map<String, Department> departments = new HashMap<>();
    private HumanResourcesDepartment hrDepartment;
    private FacilitiesManagement facilitiesManagement;
    private TrainingDepartment trainingDepartment;
    private FinanceDepartment financeDepartment;
    
    public Department getDepartmentByName(String name) { return departments.get(name); }
    public HumanResourcesDepartment getHumanResourcesDepartment() { return hrDepartment; }
    public FacilitiesManagement getFacilitiesManagement() { return facilitiesManagement; }
    public TrainingDepartment getTrainingDepartment() { return trainingDepartment; }
    public FinanceDepartment getFinanceDepartment() { return financeDepartment; }
}

class Department {
    private Map<String, Team> teams = new HashMap<>();
    private Employee departmentHead;
    private EmployeeDevelopmentProgram developmentProgram;
    
    public Team getTeamByName(String name) { return teams.get(name); }
    public Employee getDepartmentHead() { return departmentHead; }
    public EmployeeDevelopmentProgram getEmployeeDevelopmentProgram() { return developmentProgram; }
}

class Team {
    private Map<String, Employee> employees = new HashMap<>();
    
    public Employee getEmployeeById(String id) { return employees.get(id); }
}

class Employee {
    private ContactInformation contactInfo;
    private Employee directManager;
    private Project currentProject;
    private SkillProfile skillProfile;
    private Equipment assignedEquipment;
    private ExecutiveAssistant executiveAssistant;
    private EmployeeDetails employeeDetails;
    private OfficeAssignment officeAssignment;
    
    public ContactInformation getContactInformation() { return contactInfo; }
    public Employee getDirectManager() { return directManager; }
    public Project getCurrentProject() { return currentProject; }
    public SkillProfile getSkillProfile() { return skillProfile; }
    public Equipment getAssignedEquipment() { return assignedEquipment; }
    public ExecutiveAssistant getExecutiveAssistant() { return executiveAssistant; }
    public EmployeeDetails getEmployeeDetails() { return employeeDetails; }
    public OfficeAssignment getOfficeAssignment() { return officeAssignment; }
}

class ContactInformation {
    private Contact primaryContact;
    public Contact getPrimaryContact() { return primaryContact; }
}

class Contact {
    private String emailAddress;
    public String getEmailAddress() { return emailAddress; }
}

class Project {
    private ProjectDetails projectDetails;
    public ProjectDetails getProjectDetails() { return projectDetails; }
}

class ProjectDetails {
    private BudgetInformation budgetInfo;
    public BudgetInformation getBudgetInformation() { return budgetInfo; }
}

class BudgetInformation {
    private Budget totalBudget;
    public Budget getTotalBudget() { return totalBudget; }
}

class Budget {
    private double amount;
    public double getAmount() { return amount; }
}

class SkillProfile {
    private Certifications certifications;
    public Certifications getCertifications() { return certifications; }
}

class Certifications {
    private Certification latestCertification;
    public Certification getLatestCertification() { return latestCertification; }
}

class Certification {
    private CertificationDetails details;
    public CertificationDetails getCertificationDetails() { return details; }
}

class CertificationDetails {
    private CertificationName name;
    public CertificationName getCertificationName() { return name; }
}

class CertificationName {
    private String fullName;
    public String getFullName() { return fullName; }
}

class Equipment {
    private Workstation primaryWorkstation;
    public Workstation getPrimaryWorkstation() { return primaryWorkstation; }
}

class Workstation {
    private HardwareDetails hardwareDetails;
    public HardwareDetails getHardwareDetails() { return hardwareDetails; }
}

class HardwareDetails {
    private WarrantyInformation warrantyInfo;
    public WarrantyInformation getWarrantyInformation() { return warrantyInfo; }
}

class WarrantyInformation {
    private WarrantyPeriod warrantyPeriod;
    public WarrantyPeriod getWarrantyPeriod() { return warrantyPeriod; }
}

class WarrantyPeriod {
    private ExpirationDate expirationDate;
    public ExpirationDate getExpirationDate() { return expirationDate; }
}

class ExpirationDate {
    private Date date;
    public Date getDate() { return date; }
}

class ExecutiveAssistant {
    private ScheduleManager scheduleManager;
    public ScheduleManager getScheduleManager() { return scheduleManager; }
}

class ScheduleManager {
    private WeekSchedule currentWeekSchedule;
    public WeekSchedule getCurrentWeekSchedule() { return currentWeekSchedule; }
}

class WeekSchedule {
    private TimeSlots availableTimeSlots;
    public TimeSlots getAvailableTimeSlots() { return availableTimeSlots; }
}

class TimeSlots {
    private TimeSlot nextAvailableSlot;
    public TimeSlot getNextAvailableSlot() { return nextAvailableSlot; }
}

class TimeSlot {
    private TimeSlotDetails details;
    public TimeSlotDetails getTimeSlotDetails() { return details; }
}

class TimeSlotDetails {
    private StartTime startTime;
    public StartTime getStartTime() { return startTime; }
}

class StartTime {
    private FormattedTime formattedTime;
    public FormattedTime getFormattedTime() { return formattedTime; }
}

class FormattedTime {
    public String toString() { return "09:00 AM"; }
}

class OfficeAssignment {
    private OfficeLocation officeLocation;
    public OfficeLocation getOfficeLocation() { return officeLocation; }
}

class OfficeLocation {
    private String buildingName;
    public String getBuildingName() { return buildingName; }
}

// Additional supporting classes for the remaining chains...
class HumanResourcesDepartment {
    private PolicyManagement policyManagement;
    public PolicyManagement getPolicyManagement() { return policyManagement; }
}

class PolicyManagement {
    private EmployeePolicies employeePolicies;
    public EmployeePolicies getEmployeePolicies() { return employeePolicies; }
}

class EmployeePolicies {
    private BenefitsPolicies benefitsPolicies;
    public BenefitsPolicies getBenefitsPolicies() { return benefitsPolicies; }
}

class BenefitsPolicies {
    private HealthcarePolicies healthcarePolicies;
    public HealthcarePolicies getHealthcarePolicies() { return healthcarePolicies; }
}

class HealthcarePolicies {
    private HealthcarePlan primaryPlan;
    public HealthcarePlan getPrimaryHealthcarePlan() { return primaryPlan; }
}

class HealthcarePlan {
    private PlanDetails planDetails;
    public PlanDetails getPlanDetails() { return planDetails; }
}

class PlanDetails {
    private CoverageInformation coverageInfo;
    public CoverageInformation getCoverageInformation() { return coverageInfo; }
}

class CoverageInformation {
    private DetailedCoverage detailedCoverage;
    public DetailedCoverage getDetailedCoverage() { return detailedCoverage; }
}

class DetailedCoverage {
    private PolicyDocument policyDocument;
    public PolicyDocument getPolicyDocument() { return policyDocument; }
}

class PolicyDocument {
    private DocumentContent documentContent;
    public DocumentContent getDocumentContent() { return documentContent; }
}

class DocumentContent {
    private String textContent = "Comprehensive healthcare policy details...";
    public String getTextContent() { return textContent; }
}

class FacilitiesManagement {
    private ParkingManagement parkingManagement;
    private BuildingManagement buildingManagement;
    
    public ParkingManagement getParkingManagement() { return parkingManagement; }
    public BuildingManagement getBuildingManagement() { return buildingManagement; }
}

class ParkingManagement {
    private EmployeeParkingAssignments parkingAssignments;
    public EmployeeParkingAssignments getEmployeeParkingAssignments() { return parkingAssignments; }
}

class EmployeeParkingAssignments {
    public ParkingAssignment getAssignmentByEmployeeId(String employeeId) { return new ParkingAssignment(); }
}

class ParkingAssignment {
    private ParkingSpotDetails spotDetails;
    public ParkingSpotDetails getParkingSpotDetails() { return spotDetails; }
}

class ParkingSpotDetails {
    private SpotLocation spotLocation;
    public SpotLocation getSpotLocation() { return spotLocation; }
}

class SpotLocation {
    private LocationDetails locationDetails;
    public LocationDetails getLocationDetails() { return locationDetails; }
}

class LocationDetails {
    private SpotIdentifier spotIdentifier;
    public SpotIdentifier getSpotIdentifier() { return spotIdentifier; }
}

class SpotIdentifier {
    private SpotNumber spotNumber;
    public SpotNumber getSpotNumber() { return spotNumber; }
}

class SpotNumber {
    private FormattedNumber formattedNumber;
    public FormattedNumber getFormattedNumber() { return formattedNumber; }
}

class FormattedNumber {
    private DisplayFormat displayFormat;
    public DisplayFormat getDisplayFormat() { return displayFormat; }
}

class DisplayFormat {
    private PaddedNumber paddedNumber;
    public PaddedNumber getPaddedNumber() { return paddedNumber; }
}

class PaddedNumber {
    public String toString() { return "A-123"; }
}

class TrainingDepartment {
    private TrainingPrograms trainingPrograms;
    public TrainingPrograms getTrainingPrograms() { return trainingPrograms; }
}

class TrainingPrograms {
    private MandatoryTrainingPrograms mandatoryPrograms;
    public MandatoryTrainingPrograms getMandatoryTrainingPrograms() { return mandatoryPrograms; }
}

class MandatoryTrainingPrograms {
    private SecurityTrainingProgram securityProgram;
    public SecurityTrainingProgram getSecurityTrainingProgram() { return securityProgram; }
}

class SecurityTrainingProgram {
    private TrainingRecords trainingRecords;
    public TrainingRecords getTrainingRecords() { return trainingRecords; }
}

class TrainingRecords {
    public TrainingRecord getRecordByEmployeeId(String employeeId) { return new TrainingRecord(); }
}

class TrainingRecord {
    private CompletionStatus completionStatus;
    public CompletionStatus getCompletionStatus() { return completionStatus; }
}

class CompletionStatus {
    private CompletionRecord latestRecord;
    public CompletionRecord getLatestCompletionRecord() { return latestRecord; }
}

class CompletionRecord {
    private CompletionDetails completionDetails;
    public CompletionDetails getCompletionDetails() { return completionDetails; }
}

class CompletionDetails {
    private VerificationStatus verificationStatus;
    public VerificationStatus getVerificationStatus() { return verificationStatus; }
}

class VerificationStatus {
    private VerificationResult verificationResult;
    public VerificationResult getVerificationResult() { return verificationResult; }
}

class VerificationResult {
    private Boolean verified = Boolean.TRUE;
    public Boolean isVerified() { return verified; }
}

class FinanceDepartment {
    private ExpenseManagement expenseManagement;
    public ExpenseManagement getExpenseManagement() { return expenseManagement; }
}

class ExpenseManagement {
    private ExpenseReportSystem expenseReportSystem;
    public ExpenseReportSystem getExpenseReportSystem() { return expenseReportSystem; }
}

class ExpenseReportSystem {
    public EmployeeExpenseReports getEmployeeExpenseReports(String employeeId) { return new EmployeeExpenseReports(); }
}

class EmployeeExpenseReports {
    private ExpenseReport latestReport;
    public ExpenseReport getLatestExpenseReport() { return latestReport; }
}

class ExpenseReport {
    private ApprovalWorkflow approvalWorkflow;
    public ApprovalWorkflow getApprovalWorkflow() { return approvalWorkflow; }
}

class ApprovalWorkflow {
    private ApprovalStep currentStep;
    public ApprovalStep getCurrentApprovalStep() { return currentStep; }
}

class ApprovalStep {
    private ApprovalStepDetails stepDetails;
    public ApprovalStepDetails getApprovalStepDetails() { return stepDetails; }
}

class ApprovalStepDetails {
    private ApproverInformation approverInfo;
    public ApproverInformation getApproverInformation() { return approverInfo; }
}

class ApproverInformation {
    private Employee approverEmployee;
    public Employee getApproverEmployee() { return approverEmployee; }
}

class EmployeeDetails {
    private EmployeeStatus employeeStatus;
    public EmployeeStatus getEmployeeStatus() { return employeeStatus; }
}

class EmployeeStatus {
    private StatusInformation statusInfo;
    public StatusInformation getStatusInformation() { return statusInfo; }
}

class StatusInformation {
    private CurrentStatus currentStatus;
    public CurrentStatus getCurrentStatus() { return currentStatus; }
}

class CurrentStatus {
    private String statusDescription = "Active";
    public String getStatusDescription() { return statusDescription; }
}

// Additional classes for the complete profile method
class EmployeeDevelopmentProgram {
    private MentoringProgram mentoringProgram;
    public MentoringProgram getMentoringProgram() { return mentoringProgram; }
}

class MentoringProgram {
    private MentorAssignments mentorAssignments;
    public MentorAssignments getMentorAssignments() { return mentorAssignments; }
}

class MentorAssignments {
    public Mentor getMentorForEmployee(String employeeId) { return new Mentor(); }
}

class Mentor {
    private MentorProfile mentorProfile;
    public MentorProfile getMentorProfile() { return mentorProfile; }
}

class MentorProfile {
    private ProfessionalQualifications qualifications;
    public ProfessionalQualifications getProfessionalQualifications() { return qualifications; }
}

class ProfessionalQualifications {
    private EducationalBackground educationalBackground;
    public EducationalBackground getEducationalBackground() { return educationalBackground; }
}

class EducationalBackground {
    private Degree highestDegree;
    public Degree getHighestDegree() { return highestDegree; }
}

class Degree {
    private DegreeDetails degreeDetails;
    public DegreeDetails getDegreeDetails() { return degreeDetails; }
}

class DegreeDetails {
    private InstitutionInformation institutionInfo;
    public InstitutionInformation getInstitutionInformation() { return institutionInfo; }
}

class InstitutionInformation {
    private InstitutionName institutionName;
    public InstitutionName getInstitutionName() { return institutionName; }
}

class InstitutionName {
    private OfficialName officialName;
    public OfficialName getOfficialName() { return officialName; }
}

class OfficialName {
    private FullInstitutionName fullName;
    public FullInstitutionName getFullInstitutionName() { return fullName; }
}

class FullInstitutionName {
    private FormattedInstitutionName formattedName;
    public FormattedInstitutionName getFormattedName() { return formattedName; }
}

class FormattedInstitutionName {
    public String toString() { return "Massachusetts Institute of Technology"; }
}

class BuildingManagement {
    public Building getBuildingByEmployee(String employeeId) { return new Building(); }
}

class Building {
    private SecurityManagement securityManagement;
    public SecurityManagement getSecurityManagement() { return securityManagement; }
}

class SecurityManagement {
    private AccessControlSystem accessControlSystem;
    public AccessControlSystem getAccessControlSystem() { return accessControlSystem; }
}

class AccessControlSystem {
    private SecurityClearanceRequirements clearanceRequirements;
    public SecurityClearanceRequirements getSecurityClearanceRequirements() { return clearanceRequirements; }
}

class SecurityClearanceRequirements {
    public EmployeeClearanceLevel getEmployeeClearanceLevel(String employeeId) { return new EmployeeClearanceLevel(); }
}

class EmployeeClearanceLevel {
    private ClearanceDetails clearanceDetails;
    public ClearanceDetails getClearanceDetails() { return clearanceDetails; }
}

class ClearanceDetails {
    private RequiredClearanceLevel requiredLevel;
    public RequiredClearanceLevel getRequiredClearanceLevel() { return requiredLevel; }
}

class RequiredClearanceLevel {
    private ClearanceLevelDetails levelDetails;
    public ClearanceLevelDetails getClearanceLevelDetails() { return levelDetails; }
}

class ClearanceLevelDetails {
    private ClearanceDocumentation documentation;
    public ClearanceDocumentation getClearanceDocumentation() { return documentation; }
}

class ClearanceDocumentation {
    private DocumentationRequirements requirements;
    public DocumentationRequirements getDocumentationRequirements() { return requirements; }
}

class DocumentationRequirements {
    private RequiredDocuments requiredDocs;
    public RequiredDocuments getRequiredDocuments() { return requiredDocs; }
}

class RequiredDocuments {
    private DocumentList documentList;
    public DocumentList getDocumentList() { return documentList; }
}

class DocumentList {
    private Document primaryDocument;
    public Document getPrimaryDocument() { return primaryDocument; }
}

class Document {
    private DocumentTitle title;
    public DocumentTitle getDocumentTitle() { return title; }
}

class DocumentTitle {
    public String toString() { return "Security Clearance Application Form SF-86"; }
}
