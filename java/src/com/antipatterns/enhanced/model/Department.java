package com.antipatterns.enhanced.model;

public class Department {
    private Employee departmentHead = new Employee();
    private EmployeeDevelopmentProgram developmentProgram = new EmployeeDevelopmentProgram();
    
    public Team getTeamByName(String name) { return new Team(); }
    public Employee getDepartmentHead() { return departmentHead; }
    public EmployeeDevelopmentProgram getEmployeeDevelopmentProgram() { return developmentProgram; }
}
