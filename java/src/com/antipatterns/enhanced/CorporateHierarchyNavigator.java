package com.antipatterns.enhanced;

import java.util.*;
import com.antipatterns.enhanced.model.*;

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
