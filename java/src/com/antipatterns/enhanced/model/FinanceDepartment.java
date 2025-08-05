package com.antipatterns.enhanced.model;

public class FinanceDepartment {
    public ExpenseManagement getExpenseManagement() { return new ExpenseManagement(); }
}
