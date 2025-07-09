/*
 * C Anti-Patterns Demonstration
 * This file intentionally contains various anti-patterns for educational purposes
 * Based on Embold anti-patterns documentation
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

// ANTI-PATTERN: Global Variables
int global_counter = 0;
char global_buffer[1000];
int global_array[1000];
FILE* global_file_pointer;
int global_state = 0;
double global_calculation_result = 0.0;

// ANTI-PATTERN: Data Exposure - exposing internal data structures
struct exposed_data {
    int internal_value;
    char* secret_key;
    double balance;
    int user_id;
};

// ANTI-PATTERN: Fat Interface - interface with too many methods/functions
// This would be a struct with function pointers in C
struct fat_interface {
    void (*method1)(void);
    void (*method2)(void);
    void (*method3)(void);
    void (*method4)(void);
    void (*method5)(void);
    void (*method6)(void);
    void (*method7)(void);
    void (*method8)(void);
    void (*method9)(void);
    void (*method10)(void);
    int (*calculate1)(int);
    int (*calculate2)(int);
    int (*calculate3)(int);
    int (*calculate4)(int);
    int (*calculate5)(int);
    char* (*process1)(char*);
    char* (*process2)(char*);
    char* (*process3)(char*);
    char* (*process4)(char*);
    char* (*process5)(char*);
};

// Forward declarations for the fat interface
void fat_method1(void);
void fat_method2(void);
void fat_method3(void);
void fat_method4(void);
void fat_method5(void);
void fat_method6(void);
void fat_method7(void);
void fat_method8(void);
void fat_method9(void);
void fat_method10(void);

// ANTI-PATTERN: God Class (in C, this would be a large struct with many functions)
struct god_class {
    // Data management
    int data[1000];
    char strings[100][256];
    double calculations[500];
    
    // File operations
    FILE* files[10];
    char file_paths[10][256];
    
    // Network operations
    int socket_fd;
    char server_address[256];
    int port;
    
    // User interface
    char menu_items[50][100];
    int selected_item;
    
    // Business logic
    double account_balance;
    int transaction_history[1000];
    char customer_name[256];
    
    // System operations
    int process_id;
    char system_command[512];
    
    // Validation
    int validation_rules[100];
    char error_messages[100][256];
};

// ANTI-PATTERN: Brain Method - overly complex method that does too much
int brain_method_calculate_everything(struct god_class* gc, int input_value, char* input_string, double multiplier) {
    // This method does way too many things - classic Brain Method anti-pattern
    
    // Data validation
    if (gc == NULL || input_string == NULL || input_value < 0 || multiplier < 0) {
        printf("Invalid input parameters\n");
        global_state = -1;
        return -1;
    }
    
    // String processing
    int string_length = strlen(input_string);
    char processed_string[1000];
    strcpy(processed_string, input_string);
    for (int i = 0; i < string_length; i++) {
        if (processed_string[i] >= 'a' && processed_string[i] <= 'z') {
            processed_string[i] = processed_string[i] - 'a' + 'A';
        }
    }
    
    // Mathematical calculations
    double result = 0.0;
    for (int i = 0; i < input_value; i++) {
        result += sin(i * multiplier) + cos(i * multiplier);
        result *= 1.1;
        if (i % 10 == 0) {
            result = sqrt(result);
        }
    }
    
    // File operations
    FILE* temp_file = fopen("temp_calculation.txt", "w");
    if (temp_file != NULL) {
        fprintf(temp_file, "Calculation result: %f\n", result);
        fprintf(temp_file, "Input value: %d\n", input_value);
        fprintf(temp_file, "Processed string: %s\n", processed_string);
        fclose(temp_file);
    }
    
    // Memory operations
    for (int i = 0; i < 100; i++) {
        gc->data[i] = input_value * i;
        gc->calculations[i] = result * i;
    }
    
    // Business logic
    gc->account_balance += result * multiplier;
    if (gc->account_balance > 10000) {
        printf("High balance detected: %f\n", gc->account_balance);
        global_state = 1;
    }
    
    // Logging
    printf("Processing complete. Result: %f\n", result);
    global_counter++;
    global_calculation_result = result;
    
    // Network simulation
    if (input_value > 100) {
        printf("Simulating network call for large input\n");
        gc->socket_fd = 12345; // Fake socket
        strcpy(gc->server_address, "192.168.1.1");
        gc->port = 8080;
    }
    
    // User interface update
    sprintf(gc->menu_items[0], "Result: %.2f", result);
    sprintf(gc->menu_items[1], "Input: %d", input_value);
    sprintf(gc->menu_items[2], "Balance: %.2f", gc->account_balance);
    
    // Error handling (too late and mixed with other logic)
    if (result < 0) {
        printf("Negative result detected\n");
        strcpy(gc->error_messages[0], "Negative calculation result");
        return -2;
    }
    
    // More calculations (should be separate method)
    int factorial = 1;
    for (int i = 1; i <= input_value && i <= 10; i++) {
        factorial *= i;
    }
    
    // Database simulation
    printf("Saving to database: %d, %f, %s\n", input_value, result, processed_string);
    
    return (int)(result + factorial);
}

// ANTI-PATTERN: Message Chain - excessive method chaining
struct chain_link {
    struct chain_link* next;
    int value;
    char name[50];
};

// Initialize some chain links for demonstration
static struct chain_link links[5] = {
    {&links[1], 10, "First"},
    {&links[2], 20, "Second"}, 
    {&links[3], 30, "Third"},
    {&links[4], 40, "Fourth"},
    {NULL, 50, "Fifth"}
};

struct chain_link* get_first_link(struct god_class* gc) {
    (void)gc; // Suppress unused parameter warning
    return &links[0];
}

struct chain_link* get_next_link(struct chain_link* current) {
    return current ? current->next : NULL;
}

int get_value_from_link(struct chain_link* link) {
    return link ? link->value : 0;
}

// This demonstrates message chaining anti-pattern
int get_deeply_nested_value(struct god_class* gc) {
    // ANTI-PATTERN: Long chain of method calls
    return get_value_from_link(get_next_link(get_next_link(get_next_link(get_first_link(gc)))));
}

// ANTI-PATTERN: Feature Envy - method that uses more data from another class than its own
void feature_envy_method(struct god_class* other_object) {
    // This method is envious of god_class features
    printf("Account balance: %f\n", other_object->account_balance);
    printf("Customer name: %s\n", other_object->customer_name);
    printf("Socket FD: %d\n", other_object->socket_fd);
    printf("Server address: %s\n", other_object->server_address);
    printf("Port: %d\n", other_object->port);
    printf("Process ID: %d\n", other_object->process_id);
    printf("Selected item: %d\n", other_object->selected_item);
    
    // Manipulating other object's data instead of its own
    other_object->account_balance *= 1.05;
    other_object->selected_item++;
    strcat(other_object->customer_name, " - Updated");
}

// ANTI-PATTERN: Shotgun Surgery - small changes require modifications in many places
void update_global_state_method1() {
    global_counter++;
    global_state = 1;
    printf("State updated in method1\n");
}

void update_global_state_method2() {
    global_counter += 2;
    global_state = 2;
    printf("State updated in method2\n");
}

void update_global_state_method3() {
    global_counter += 3;
    global_state = 3;
    printf("State updated in method3\n");
}

void update_global_state_method4() {
    global_counter += 4;
    global_state = 4;
    printf("State updated in method4\n");
}

// ANTI-PATTERN: Fan Out - method that calls too many other methods
void fan_out_method() {
    update_global_state_method1();
    update_global_state_method2();
    update_global_state_method3();
    update_global_state_method4();
    fat_method1();
    fat_method2();
    fat_method3();
    fat_method4();
    fat_method5();
    printf("Fan out method called %d other methods\n", 9);
}

// ANTI-PATTERN: Dispersed Coupling - method that calls methods from many different modules/classes
void dispersed_coupling_method(struct god_class* gc) {
    // Calls methods from different conceptual modules
    brain_method_calculate_everything(gc, 50, "test", 2.5);  // Calculation module
    feature_envy_method(gc);                                  // Display module
    get_deeply_nested_value(gc);                             // Navigation module
    fan_out_method();                                        // State module
    fat_method1();                                           // Interface module
    
    // Also manipulates global variables (another module)
    global_counter += 10;
    strcpy(global_buffer, "Dispersed coupling executed");
}

// ANTI-PATTERN: Intensive Coupling - method with too many parameters
void intensive_coupling_method(int param1, int param2, int param3, int param4, int param5,
                              char* param6, char* param7, char* param8, char* param9,
                              double param10, double param11, double param12,
                              struct god_class* param13, struct chain_link* param14,
                              FILE* param15, int* param16, char** param17,
                              float param18, long param19, short param20) {
    printf("Method with %d parameters - Intensive Coupling anti-pattern\n", 20);
    
    // Using all parameters to justify their existence
    int result = param1 + param2 + param3 + param4 + param5;
    printf("String params: %s, %s, %s, %s\n", param6, param7, param8, param9);
    double calc = param10 + param11 + param12 + param18 + param19 + param20;
    
    if (param13) param13->account_balance += calc;
    if (param14) param14->value = result;
    if (param15) fprintf(param15, "Intensive coupling result: %d\n", result);
    if (param16) *param16 = result;
    if (param17) printf("String array first element: %s\n", param17[0]);
}

// ANTI-PATTERN: Format Exposure - exposing internal data format
void format_exposure_method(struct god_class* gc) {
    // Directly exposing internal array structure
    printf("Direct access to internal data array:\n");
    for (int i = 0; i < 10; i++) {
        printf("data[%d] = %d\n", i, gc->data[i]);
    }
    
    // Exposing file structure
    printf("File paths in object:\n");
    for (int i = 0; i < 5; i++) {
        printf("file_paths[%d] = %s\n", i, gc->file_paths[i]);
    }
    
    // Direct manipulation of internal structure
    gc->data[0] = 999;  // Breaking encapsulation
    strcpy(gc->file_paths[0], "/exposed/path");
}

// ANTI-PATTERN: Decapsulation - breaking object encapsulation
void decapsulation_method(struct god_class* gc) {
    // Direct access to what should be private data
    gc->account_balance = 1000000;  // Should use setter method
    gc->socket_fd = -1;            // Should use proper connection method
    gc->process_id = 12345;        // Should be managed internally (hardcoded for demo)
    
    // Bypassing proper validation
    strcpy(gc->customer_name, "HACKED_USER");
    gc->selected_item = -999;
    
    printf("Decapsulation: Direct manipulation of object internals\n");
}

// ANTI-PATTERN: Unused Methods (these methods are defined but never called)
void unused_method1() {
    printf("This method is never called - Unused Method anti-pattern\n");
}

void unused_method2(int param) {
    printf("Another unused method with parameter: %d\n", param);
}

static void unused_static_method() {
    printf("Unused static method\n");
}

// Implementations for fat interface methods
void fat_method1(void) { printf("Fat method 1\n"); }
void fat_method2(void) { printf("Fat method 2\n"); }
void fat_method3(void) { printf("Fat method 3\n"); }
void fat_method4(void) { printf("Fat method 4\n"); }
void fat_method5(void) { printf("Fat method 5\n"); }
void fat_method6(void) { printf("Fat method 6\n"); }
void fat_method7(void) { printf("Fat method 7\n"); }
void fat_method8(void) { printf("Fat method 8\n"); }
void fat_method9(void) { printf("Fat method 9\n"); }
void fat_method10(void) { printf("Fat method 10\n"); }

// ANTI-PATTERN: Test Hungry - code that's difficult to test due to tight coupling
void test_hungry_method() {
    // Hard to test because it depends on global state
    global_counter = 100;
    
    // Hard to test because it performs file I/O
    FILE* file = fopen("hardcoded_file.txt", "w");
    if (file) {
        fprintf(file, "Hard to test content\n");
        fclose(file);
    }
    
    // Hard to test because it prints to stdout
    printf("Test hungry method executed\n");
    
    // Hard to test because it uses system time
    printf("Current global counter: %d\n", global_counter);
}

// Main function demonstrating all anti-patterns
int main() {
    printf("=== C Anti-Patterns Demonstration ===\n\n");
    
    // Initialize god class (another anti-pattern - doing too much in main)
    struct god_class* gc = malloc(sizeof(struct god_class));
    if (!gc) {
        printf("Memory allocation failed\n");
        return 1;
    }
    
    // Initialize god class with default values
    memset(gc, 0, sizeof(struct god_class));
    gc->account_balance = 1000.0;
    strcpy(gc->customer_name, "John Doe");
    gc->port = 8080;
    strcpy(gc->server_address, "localhost");
    
    printf("1. Demonstrating Brain Method anti-pattern:\n");
    int result = brain_method_calculate_everything(gc, 25, "hello world", 1.5);
    printf("Brain method result: %d\n\n", result);
    
    printf("2. Demonstrating Feature Envy anti-pattern:\n");
    feature_envy_method(gc);
    printf("\n");
    
    printf("3. Demonstrating Message Chain anti-pattern:\n");
    int chain_value = get_deeply_nested_value(gc);
    printf("Chain value: %d\n\n", chain_value);
    
    printf("4. Demonstrating Fan Out anti-pattern:\n");
    fan_out_method();
    printf("\n");
    
    printf("5. Demonstrating Dispersed Coupling anti-pattern:\n");
    dispersed_coupling_method(gc);
    printf("\n");
    
    printf("6. Demonstrating Intensive Coupling anti-pattern:\n");
    char* str_array[] = {"test1", "test2"};
    int int_val = 42;
    intensive_coupling_method(1, 2, 3, 4, 5, "str1", "str2", "str3", "str4",
                             1.1, 2.2, 3.3, gc, NULL, stdout, &int_val, str_array,
                             4.4f, 123L, 42);
    printf("\n");
    
    printf("7. Demonstrating Format Exposure anti-pattern:\n");
    format_exposure_method(gc);
    printf("\n");
    
    printf("8. Demonstrating Decapsulation anti-pattern:\n");
    decapsulation_method(gc);
    printf("\n");
    
    printf("9. Demonstrating Test Hungry anti-pattern:\n");
    test_hungry_method();
    printf("\n");
    
    printf("10. Global Variables anti-pattern in use throughout:\n");
    printf("Global counter: %d\n", global_counter);
    printf("Global state: %d\n", global_state);
    printf("Global calculation result: %f\n", global_calculation_result);
    printf("\n");
    
    printf("=== Anti-Pattern Summary ===\n");
    printf("This code demonstrates the following anti-patterns:\n");
    printf("- God Class: The god_class struct tries to do everything\n");
    printf("- Brain Method: brain_method_calculate_everything does too much\n");
    printf("- Feature Envy: feature_envy_method uses other object's data\n");
    printf("- Message Chain: get_deeply_nested_value chains too many calls\n");
    printf("- Fan Out: fan_out_method calls too many other methods\n");
    printf("- Dispersed Coupling: dispersed_coupling_method couples to many modules\n");
    printf("- Intensive Coupling: intensive_coupling_method has too many parameters\n");
    printf("- Format Exposure: format_exposure_method exposes internal data\n");
    printf("- Decapsulation: decapsulation_method breaks encapsulation\n");
    printf("- Global Variables: Multiple global variables used throughout\n");
    printf("- Fat Interface: fat_interface struct has too many methods\n");
    printf("- Unused Methods: Several methods are defined but never called\n");
    printf("- Test Hungry: test_hungry_method is difficult to test\n");
    printf("- Data Exposure: exposed_data struct exposes internal data\n");
    
    // Clean up
    free(gc);
    
    return 0;
}

/*
 * ADDITIONAL ANTI-PATTERNS DEMONSTRATED:
 * 
 * 1. Solution Sprawl: This file tries to solve too many problems in one place
 * 2. Local/Global Breakable: Changes to global variables can break multiple functions
 * 3. Local/Global Butterfly: Small changes ripple through many methods
 * 4. Brain Class: The god_class struct knows and does too much
 * 5. Global Hub: Global variables act as a central hub that many functions depend on
 * 
 * NOTE: This code is intentionally poorly designed for educational purposes.
 * In real projects, these patterns should be avoided and refactored.
 */
