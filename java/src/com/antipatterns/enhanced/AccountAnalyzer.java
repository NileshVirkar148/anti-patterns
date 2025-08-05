package com.antipatterns.enhanced;

import java.util.*;

/**
 * ENHANCED FEATURE ENVY ANTI-PATTERN
 * 
 * This class is designed to exceed detection thresholds:
 * - ATFD > 4 (Access to Foreign Data)
 * - FDP < 4 (Foreign Data Providers)
 * - LAA < 0.33 (Locality of Attribute Accesses)
 * 
 * The AccountAnalyzer class demonstrates Feature Envy by:
 * - Extensively accessing attributes of Customer objects
 * - Making numerous calls to external Account data
 * - Having minimal access to its own attributes
 * - Concentrating on foreign data rather than encapsulated behavior
 */
public class AccountAnalyzer {
    
    // Local attributes (minimal usage to keep LAA low)
    private String analyzerVersion = "1.0";
    private Date lastAnalysisDate;
    
    /**
     * FEATURE ENVY METHOD: analyzeCustomerAccount()
     * 
     * This method demonstrates Feature Envy by:
     * - Accessing 15+ foreign attributes (ATFD > 4)
     * - Using data from 3 foreign classes (FDP < 4)
     * - Minimal access to local attributes (LAA < 0.33)
     * - Heavy reliance on external object data
     */
    public Map<String, Object> analyzeCustomerAccount(Customer customer, Account account, Transaction lastTransaction) {
        Map<String, Object> analysis = new HashMap<>();
        
        // Extensive access to Customer foreign data (9 accesses)
        String customerName = customer.getFirstName() + " " + customer.getLastName();
        String customerEmail = customer.getEmailAddress();
        String customerPhone = customer.getPhoneNumber();
        String customerAddress = customer.getStreetAddress() + ", " + customer.getCity() + ", " + customer.getState();
        Date customerBirthDate = customer.getDateOfBirth();
        String customerSSN = customer.getSocialSecurityNumber();
        String customerEmployer = customer.getEmployerName();
        double customerAnnualIncome = customer.getAnnualIncome();
        String customerCreditScore = customer.getCreditScore();
        
        // Extensive access to Account foreign data (12 accesses)
        String accountNumber = account.getAccountNumber();
        String accountType = account.getAccountType();
        double accountBalance = account.getCurrentBalance();
        double accountMinBalance = account.getMinimumBalance();
        double accountMaxBalance = account.getMaximumBalance();
        Date accountOpenDate = account.getOpenDate();
        Date accountLastActivity = account.getLastActivityDate();
        String accountStatus = account.getAccountStatus();
        double accountInterestRate = account.getInterestRate();
        List<String> accountFeatures = account.getAccountFeatures();
        String accountBranch = account.getBranchCode();
        double accountCreditLimit = account.getCreditLimit();
        
        // Access to Transaction foreign data (8 accesses)
        String transactionId = lastTransaction.getTransactionId();
        double transactionAmount = lastTransaction.getAmount();
        Date transactionDate = lastTransaction.getTransactionDate();
        String transactionType = lastTransaction.getTransactionType();
        String transactionDescription = lastTransaction.getDescription();
        String transactionMerchant = lastTransaction.getMerchantName();
        String transactionCategory = lastTransaction.getCategory();
        String transactionLocation = lastTransaction.getLocation();
        
        // Complex analysis using predominantly foreign data
        
        // Customer demographics analysis
        int customerAge = calculateAge(customerBirthDate);
        boolean isYoungCustomer = customerAge < 30;
        boolean isSeniorCustomer = customerAge >= 65;
        boolean isHighIncomeCustomer = customerAnnualIncome > 100000;
        boolean isPrimeCustomer = Integer.parseInt(customerCreditScore) > 700;
        
        // Account performance analysis
        double balanceToIncomeRatio = accountBalance / customerAnnualIncome;
        boolean isLowBalanceAccount = accountBalance < accountMinBalance * 1.1;
        boolean isHighValueAccount = accountBalance > 50000;
        long accountAgeInDays = (new Date().getTime() - accountOpenDate.getTime()) / (1000 * 60 * 60 * 24);
        boolean isNewAccount = accountAgeInDays < 90;
        
        // Transaction pattern analysis  
        boolean isLargeTransaction = transactionAmount > accountBalance * 0.1;
        boolean isDebitTransaction = transactionType.equals("DEBIT");
        boolean isCreditTransaction = transactionType.equals("CREDIT");
        boolean isATMTransaction = transactionDescription.contains("ATM");
        boolean isOnlineTransaction = transactionLocation.contains("ONLINE");
        
        // Risk assessment using foreign data
        double riskScore = 0.0;
        
        if (isYoungCustomer && accountBalance < 5000) {
            riskScore += 10.0;
        }
        
        if (customerAnnualIncome < 30000 && accountBalance > customerAnnualIncome * 0.5) {
            riskScore += 15.0;
        }
        
        if (Integer.parseInt(customerCreditScore) < 600) {
            riskScore += 20.0;
        }
        
        if (isLargeTransaction && isDebitTransaction) {
            riskScore += 25.0;
        }
        
        if (accountType.equals("CHECKING") && accountBalance > accountCreditLimit) {
            riskScore += 30.0;
        }
        
        // Profitability analysis using foreign data
        double profitabilityScore = 0.0;
        
        if (isHighIncomeCustomer && isHighValueAccount) {
            profitabilityScore += 50.0;
        }
        
        if (isPrimeCustomer && accountBalance > 25000) {
            profitabilityScore += 40.0;
        }
        
        if (accountInterestRate > 0.05 && accountBalance > 10000) {
            profitabilityScore += 30.0;
        }
        
        if (accountFeatures.contains("PREMIUM") && customerAnnualIncome > 75000) {
            profitabilityScore += 35.0;
        }
        
        // Customer service analysis using foreign data
        double serviceScore = 0.0;
        
        if (isSeniorCustomer) {
            serviceScore += 20.0;
        }
        
        if (isNewAccount && isPrimeCustomer) {
            serviceScore += 25.0;
        }
        
        if (customerAddress.contains("PREMIUM_ZIP") && accountType.equals("SAVINGS")) {
            serviceScore += 15.0;
        }
        
        // Compile analysis results
        analysis.put("customer_name", customerName);
        analysis.put("customer_age", customerAge);
        analysis.put("account_number", accountNumber);
        analysis.put("account_age_days", accountAgeInDays);
        analysis.put("balance_to_income_ratio", balanceToIncomeRatio);
        analysis.put("risk_score", riskScore);
        analysis.put("profitability_score", profitabilityScore);
        analysis.put("service_score", serviceScore);
        
        // Risk categorization based on foreign data
        if (riskScore > 50) {
            analysis.put("risk_category", "HIGH");
            analysis.put("recommended_action", "REVIEW_ACCOUNT");
        } else if (riskScore > 25) {
            analysis.put("risk_category", "MEDIUM");
            analysis.put("recommended_action", "MONITOR_CLOSELY");
        } else {
            analysis.put("risk_category", "LOW");
            analysis.put("recommended_action", "STANDARD_MONITORING");
        }
        
        // Profitability categorization
        if (profitabilityScore > 80) {
            analysis.put("profitability_category", "PREMIUM");
            analysis.put("marketing_priority", "HIGH");
        } else if (profitabilityScore > 40) {
            analysis.put("profitability_category", "STANDARD");
            analysis.put("marketing_priority", "MEDIUM");
        } else {
            analysis.put("profitability_category", "BASIC");
            analysis.put("marketing_priority", "LOW");
        }
        
        // Service level recommendation
        if (serviceScore > 40) {
            analysis.put("service_level", "PREMIUM");
        } else if (serviceScore > 20) {
            analysis.put("service_level", "ENHANCED");
        } else {
            analysis.put("service_level", "STANDARD");
        }
        
        // Minimal access to local attributes (only 2 accesses to keep LAA low)
        analysis.put("analyzer_version", this.analyzerVersion);
        this.lastAnalysisDate = new Date();
        
        return analysis;
    }
    
    // Helper method that also demonstrates Feature Envy
    private int calculateAge(Date birthDate) {
        // Uses foreign data parameter extensively
        long currentTime = new Date().getTime();
        long birthTime = birthDate.getTime();
        long ageInMillis = currentTime - birthTime;
        long ageInYears = ageInMillis / (1000L * 60 * 60 * 24 * 365);
        return (int) ageInYears;
    }
    
    // Getter for local attribute (minimal local data access)
    public String getAnalyzerVersion() {
        return analyzerVersion;
    }
    
    public Date getLastAnalysisDate() {
        return lastAnalysisDate;
    }
}

/**
 * Supporting Customer class (Foreign Data Provider 1)
 */
class Customer {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private Date dateOfBirth;
    private String socialSecurityNumber;
    private String employerName;
    private double annualIncome;
    private String creditScore;
    
    // Constructor
    public Customer(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }
    
    // Getters (Foreign Data Access Points)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmailAddress() { return emailAddress; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public String getSocialSecurityNumber() { return socialSecurityNumber; }
    public String getEmployerName() { return employerName; }
    public double getAnnualIncome() { return annualIncome; }
    public String getCreditScore() { return creditScore; }
    
    // Setters
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setSocialSecurityNumber(String socialSecurityNumber) { this.socialSecurityNumber = socialSecurityNumber; }
    public void setEmployerName(String employerName) { this.employerName = employerName; }
    public void setAnnualIncome(double annualIncome) { this.annualIncome = annualIncome; }
    public void setCreditScore(String creditScore) { this.creditScore = creditScore; }
}

/**
 * Supporting Account class (Foreign Data Provider 2)
 */
class Account {
    private String accountNumber;
    private String accountType;
    private double currentBalance;
    private double minimumBalance;
    private double maximumBalance;
    private Date openDate;
    private Date lastActivityDate;
    private String accountStatus;
    private double interestRate;
    private List<String> accountFeatures;
    private String branchCode;
    private double creditLimit;
    
    // Constructor
    public Account(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountFeatures = new ArrayList<>();
    }
    
    // Getters (Foreign Data Access Points)
    public String getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public double getCurrentBalance() { return currentBalance; }
    public double getMinimumBalance() { return minimumBalance; }
    public double getMaximumBalance() { return maximumBalance; }
    public Date getOpenDate() { return openDate; }
    public Date getLastActivityDate() { return lastActivityDate; }
    public String getAccountStatus() { return accountStatus; }
    public double getInterestRate() { return interestRate; }
    public List<String> getAccountFeatures() { return new ArrayList<>(accountFeatures); }
    public String getBranchCode() { return branchCode; }
    public double getCreditLimit() { return creditLimit; }
    
    // Setters
    public void setCurrentBalance(double currentBalance) { this.currentBalance = currentBalance; }
    public void setMinimumBalance(double minimumBalance) { this.minimumBalance = minimumBalance; }
    public void setMaximumBalance(double maximumBalance) { this.maximumBalance = maximumBalance; }
    public void setOpenDate(Date openDate) { this.openDate = openDate; }
    public void setLastActivityDate(Date lastActivityDate) { this.lastActivityDate = lastActivityDate; }
    public void setAccountStatus(String accountStatus) { this.accountStatus = accountStatus; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }
    public void setCreditLimit(double creditLimit) { this.creditLimit = creditLimit; }
    public void addAccountFeature(String feature) { this.accountFeatures.add(feature); }
}

/**
 * Supporting Transaction class (Foreign Data Provider 3)
 */
class Transaction {
    private String transactionId;
    private double amount;
    private Date transactionDate;
    private String transactionType;
    private String description;
    private String merchantName;
    private String category;
    private String location;
    
    // Constructor
    public Transaction(String transactionId, double amount, String transactionType) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionType = transactionType;
    }
    
    // Getters (Foreign Data Access Points)
    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public Date getTransactionDate() { return transactionDate; }
    public String getTransactionType() { return transactionType; }
    public String getDescription() { return description; }
    public String getMerchantName() { return merchantName; }
    public String getCategory() { return category; }
    public String getLocation() { return location; }
    
    // Setters
    public void setTransactionDate(Date transactionDate) { this.transactionDate = transactionDate; }
    public void setDescription(String description) { this.description = description; }
    public void setMerchantName(String merchantName) { this.merchantName = merchantName; }
    public void setCategory(String category) { this.category = category; }
    public void setLocation(String location) { this.location = location; }
}
