package com.antipatterns.enhanced.model;

public class Company {
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
