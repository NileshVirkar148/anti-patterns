package com.antipatterns.enhanced;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.regex.*;

/**
 * ENHANCED BRAIN METHOD ANTI-PATTERN
 * 
 * This class contains a method designed to exceed detection thresholds:
 * - LOC > 80 (VeryHigh threshold for Brain Method)
 * - Cyclomatic Complexity > 20 (VeryHigh threshold for Brain Method)
 * - Multiple nested conditions and loops
 * - Complex business logic concentrated in a single method
 */
public class ComplexDataProcessor {
    
    private Connection dbConnection;
    private Map<String, Object> configCache;
    private List<String> errorLog;
    
    public ComplexDataProcessor() {
        this.configCache = new HashMap<>();
        this.errorLog = new ArrayList<>();
    }
    
    /**
     * BRAIN METHOD: processComplexBusinessLogic()
     * 
     * This method violates the Brain Method anti-pattern by:
     * - Exceeding 80 lines of code (LOC threshold)
     * - Having cyclomatic complexity > 20 (multiple if/else, loops, switches)
     * - Containing multiple responsibilities in a single method
     * - Having deep nesting levels
     * - Performing complex calculations and data transformations
     * 
     * Estimated metrics:
     * - LOC: ~120+ lines
     * - Cyclomatic Complexity: ~25+ (multiple decision points)
     * - Nesting Level: 4-5 levels deep
     */
    public Map<String, Object> processComplexBusinessLogic(
            String inputData, 
            Map<String, String> parameters, 
            List<String> validationRules,
            Set<String> allowedOperations,
            boolean isDebugMode,
            int maxRetries) throws Exception {
        
        // Initialize result map
        Map<String, Object> result = new HashMap<>();
        List<String> processingErrors = new ArrayList<>();
        Map<String, Object> statisticsData = new HashMap<>();
        Set<String> processedItems = new HashSet<>();
        
        // Input validation with multiple conditions (Complexity +5)
        if (inputData == null || inputData.trim().isEmpty()) {
            if (isDebugMode) {
                System.out.println("Debug: Input data is null or empty");
                errorLog.add("Input validation failed: null or empty data");
            }
            throw new IllegalArgumentException("Input data cannot be null or empty");
        } else if (inputData.length() > 10000) {
            if (isDebugMode) {
                System.out.println("Debug: Input data exceeds maximum length");
            }
            throw new IllegalArgumentException("Input data too large");
        } else if (!inputData.matches("^[a-zA-Z0-9\\s\\-_.,;:!?]+$")) {
            if (isDebugMode) {
                System.out.println("Debug: Input data contains invalid characters");
            }
            throw new IllegalArgumentException("Input data contains invalid characters");
        }
        
        // Parameter validation with nested conditions (Complexity +7)
        if (parameters != null && !parameters.isEmpty()) {
            for (Map.Entry<String, String> param : parameters.entrySet()) {
                if (param.getKey() == null || param.getKey().trim().isEmpty()) {
                    processingErrors.add("Invalid parameter key: " + param.getKey());
                    continue;
                }
                
                String value = param.getValue();
                if (value == null) {
                    if (isDebugMode) {
                        System.out.println("Debug: Parameter " + param.getKey() + " has null value");
                    }
                    processingErrors.add("Parameter " + param.getKey() + " has null value");
                } else if (value.length() > 500) {
                    if (isDebugMode) {
                        System.out.println("Debug: Parameter " + param.getKey() + " value too long");
                    }
                    processingErrors.add("Parameter " + param.getKey() + " value exceeds maximum length");
                } else {
                    // Validate parameter based on its key
                    switch (param.getKey().toLowerCase()) {
                        case "email":
                            if (!value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                                processingErrors.add("Invalid email format: " + value);
                            }
                            break;
                        case "phone":
                            if (!value.matches("^\\+?[1-9]\\d{1,14}$")) {
                                processingErrors.add("Invalid phone format: " + value);
                            }
                            break;
                        case "age":
                            try {
                                int age = Integer.parseInt(value);
                                if (age < 0 || age > 150) {
                                    processingErrors.add("Invalid age range: " + age);
                                }
                            } catch (NumberFormatException e) {
                                processingErrors.add("Age must be a number: " + value);
                            }
                            break;
                        case "score":
                            try {
                                double score = Double.parseDouble(value);
                                if (score < 0.0 || score > 100.0) {
                                    processingErrors.add("Score must be between 0 and 100: " + score);
                                }
                            } catch (NumberFormatException e) {
                                processingErrors.add("Score must be a number: " + value);
                            }
                            break;
                        default:
                            if (isDebugMode) {
                                System.out.println("Debug: Unknown parameter: " + param.getKey());
                            }
                            break;
                    }
                }
            }
        }
        
        // Validation rules processing with loops and conditions (Complexity +6)
        if (validationRules != null && !validationRules.isEmpty()) {
            for (String rule : validationRules) {
                if (rule == null || rule.trim().isEmpty()) {
                    continue;
                }
                
                // Parse validation rule
                String[] ruleParts = rule.split(":");
                if (ruleParts.length != 2) {
                    processingErrors.add("Invalid rule format: " + rule);
                    continue;
                }
                
                String ruleType = ruleParts[0].trim();
                String ruleValue = ruleParts[1].trim();
                
                // Apply validation rule with nested conditions
                switch (ruleType.toLowerCase()) {
                    case "min_length":
                        try {
                            int minLength = Integer.parseInt(ruleValue);
                            if (inputData.length() < minLength) {
                                processingErrors.add("Input length below minimum: " + minLength);
                            }
                        } catch (NumberFormatException e) {
                            processingErrors.add("Invalid min_length value: " + ruleValue);
                        }
                        break;
                    case "max_length":
                        try {
                            int maxLength = Integer.parseInt(ruleValue);
                            if (inputData.length() > maxLength) {
                                processingErrors.add("Input length exceeds maximum: " + maxLength);
                            }
                        } catch (NumberFormatException e) {
                            processingErrors.add("Invalid max_length value: " + ruleValue);
                        }
                        break;
                    case "pattern":
                        try {
                            Pattern pattern = Pattern.compile(ruleValue);
                            if (!pattern.matcher(inputData).matches()) {
                                processingErrors.add("Input does not match pattern: " + ruleValue);
                            }
                        } catch (PatternSyntaxException e) {
                            processingErrors.add("Invalid regex pattern: " + ruleValue);
                        }
                        break;
                    case "contains":
                        if (!inputData.toLowerCase().contains(ruleValue.toLowerCase())) {
                            processingErrors.add("Input must contain: " + ruleValue);
                        }
                        break;
                    case "not_contains":
                        if (inputData.toLowerCase().contains(ruleValue.toLowerCase())) {
                            processingErrors.add("Input must not contain: " + ruleValue);
                        }
                        break;
                    default:
                        if (isDebugMode) {
                            System.out.println("Debug: Unknown validation rule: " + ruleType);
                        }
                        break;
                }
            }
        }
        
        // Data processing with complex nested loops and conditions (Complexity +8)
        String[] dataLines = inputData.split("\n");
        for (int i = 0; i < dataLines.length; i++) {
            String line = dataLines[i].trim();
            if (line.isEmpty()) {
                continue;
            }
            
            // Process each line with multiple conditions
            if (line.startsWith("#")) {
                // Comment line, skip but log if debug mode
                if (isDebugMode) {
                    System.out.println("Debug: Skipping comment line " + (i + 1) + ": " + line);
                }
                continue;
            } else if (line.startsWith("@")) {
                // Special directive line
                String directive = line.substring(1);
                if (directive.equals("reset")) {
                    processedItems.clear();
                    statisticsData.clear();
                    if (isDebugMode) {
                        System.out.println("Debug: Reset directive executed at line " + (i + 1));
                    }
                } else if (directive.equals("debug_on")) {
                    isDebugMode = true;
                } else if (directive.equals("debug_off")) {
                    isDebugMode = false;
                } else {
                    processingErrors.add("Unknown directive at line " + (i + 1) + ": " + directive);
                }
                continue;
            } else {
                // Regular data line processing
                String[] fields = line.split(",");
                
                for (int j = 0; j < fields.length; j++) {
                    String field = fields[j].trim();
                    
                    if (field.isEmpty()) {
                        continue;
                    }
                    
                    // Process field based on position and content
                    if (j == 0) {
                        // First field is ID
                        if (processedItems.contains(field)) {
                            processingErrors.add("Duplicate ID at line " + (i + 1) + ": " + field);
                        } else {
                            processedItems.add(field);
                            statisticsData.put("processed_count", ((Integer) statisticsData.getOrDefault("processed_count", 0)) + 1);
                        }
                    } else if (j == 1) {
                        // Second field is type
                        if (allowedOperations != null && !allowedOperations.contains(field)) {
                            processingErrors.add("Disallowed operation at line " + (i + 1) + ": " + field);
                        } else {
                            statisticsData.put(field + "_count", ((Integer) statisticsData.getOrDefault(field + "_count", 0)) + 1);
                        }
                    } else {
                        // Additional fields are data values
                        try {
                            if (field.matches("^\\d+$")) {
                                // Integer value
                                int intValue = Integer.parseInt(field);
                                if (intValue < 0) {
                                    processingErrors.add("Negative value not allowed at line " + (i + 1) + ": " + intValue);
                                } else {
                                    statisticsData.put("total_numeric", ((Integer) statisticsData.getOrDefault("total_numeric", 0)) + intValue);
                                }
                            } else if (field.matches("^\\d*\\.\\d+$")) {
                                // Decimal value
                                double doubleValue = Double.parseDouble(field);
                                if (doubleValue < 0.0) {
                                    processingErrors.add("Negative decimal not allowed at line " + (i + 1) + ": " + doubleValue);
                                } else {
                                    Double currentDecimal = (Double) statisticsData.getOrDefault("total_decimal", 0.0);
                                    statisticsData.put("total_decimal", currentDecimal + doubleValue);
                                }
                            } else {
                                // String value
                                statisticsData.put("string_count", ((Integer) statisticsData.getOrDefault("string_count", 0)) + 1);
                                if (field.length() > 100) {
                                    processingErrors.add("String too long at line " + (i + 1) + ": " + field.substring(0, 20) + "...");
                                }
                            }
                        } catch (NumberFormatException e) {
                            processingErrors.add("Invalid number format at line " + (i + 1) + ": " + field);
                        }
                    }
                }
            }
        }
        
        // Error handling with retry logic (Complexity +4)
        if (!processingErrors.isEmpty()) {
            if (maxRetries > 0) {
                if (isDebugMode) {
                    System.out.println("Debug: Processing errors found, attempting retry...");
                }
                
                // Attempt to clean up data and retry
                String cleanedData = inputData.replaceAll("[^a-zA-Z0-9\\s\\-_.,;:!?\n#@]", "");
                if (!cleanedData.equals(inputData)) {
                    try {
                        return processComplexBusinessLogic(cleanedData, parameters, validationRules, allowedOperations, isDebugMode, maxRetries - 1);
                    } catch (Exception e) {
                        processingErrors.add("Retry failed: " + e.getMessage());
                    }
                }
            }
            
            // Log errors if too many
            if (processingErrors.size() > 10) {
                errorLog.addAll(processingErrors.subList(0, 10));
                errorLog.add("... and " + (processingErrors.size() - 10) + " more errors");
            } else {
                errorLog.addAll(processingErrors);
            }
        }
        
        // Final result compilation with complex logic (Complexity +3)
        result.put("processed_items", new ArrayList<>(processedItems));
        result.put("statistics", new HashMap<>(statisticsData));
        result.put("errors", new ArrayList<>(processingErrors));
        result.put("success", processingErrors.isEmpty());
        result.put("processing_time", System.currentTimeMillis());
        
        if (statisticsData.containsKey("processed_count")) {
            int processedCount = (Integer) statisticsData.get("processed_count");
            if (processedCount > 100) {
                result.put("performance_rating", "HIGH");
            } else if (processedCount > 50) {
                result.put("performance_rating", "MEDIUM");
            } else {
                result.put("performance_rating", "LOW");
            }
        }
        
        // Debug output if enabled
        if (isDebugMode) {
            System.out.println("Debug: Processing completed");
            System.out.println("Debug: Processed " + processedItems.size() + " items");
            System.out.println("Debug: Found " + processingErrors.size() + " errors");
            System.out.println("Debug: Statistics: " + statisticsData);
        }
        
        return result;
    }
    
    // Additional methods to complete the class
    public void setDatabaseConnection(Connection connection) {
        this.dbConnection = connection;
    }
    
    public List<String> getErrorLog() {
        return new ArrayList<>(errorLog);
    }
    
    public void clearErrorLog() {
        errorLog.clear();
    }
}
