# C Anti-Patterns Demonstration

This directory contains a comprehensive C code example that demonstrates various anti-patterns applicable to C-style languages, based on the [Embold Anti-Patterns Documentation](https://docs.embold.io/anti-patterns/).

## Overview

The `anti_patterns_demo.c` file intentionally implements multiple anti-patterns to serve as an educational example of what **NOT** to do in production code. Each anti-pattern is clearly marked with comments and demonstrates real-world scenarios where these patterns commonly emerge.

## Anti-Patterns Demonstrated

### 1. **God Class** 📚
- **Location**: `struct god_class`
- **Description**: A single struct that tries to handle data management, file operations, network operations, UI, business logic, and system operations
- **Problem**: Violates Single Responsibility Principle, difficult to maintain and test

### 2. **Brain Method** 🧠
- **Location**: `brain_method_calculate_everything()`
- **Description**: A single function that performs string processing, mathematical calculations, file I/O, memory operations, business logic, and more
- **Problem**: Too complex, difficult to understand, test, and maintain

### 3. **Global Variables** 🌍
- **Location**: Multiple global variables at the top of the file
- **Description**: Shared state accessible from anywhere in the program
- **Problem**: Makes code unpredictable, hard to test, and prone to side effects

### 4. **Feature Envy** 👀
- **Location**: `feature_envy_method()`
- **Description**: A method that uses more data from another struct than from its own context
- **Problem**: Indicates poor encapsulation and suggests the functionality belongs elsewhere

### 5. **Shotgun Surgery** 🔫
- **Location**: `update_global_state_method1-4()`
- **Description**: Small changes require modifications across multiple functions
- **Problem**: Makes maintenance difficult and error-prone

### 6. **Message Chain** ⛓️
- **Location**: `get_deeply_nested_value()`
- **Description**: Long chains of method calls to navigate through objects
- **Problem**: Creates tight coupling and makes code fragile

### 7. **Fan Out** 📤
- **Location**: `fan_out_method()`
- **Description**: A method that calls too many other methods
- **Problem**: High coupling, difficult to understand and maintain

### 8. **Dispersed Coupling** 🕸️
- **Location**: `dispersed_coupling_method()`
- **Description**: A method that depends on many different modules/components
- **Problem**: Makes the code fragile and hard to change

### 9. **Intensive Coupling** 🔗
- **Location**: `intensive_coupling_method()`
- **Description**: A method with an excessive number of parameters (20 in this example)
- **Problem**: Difficult to use, understand, and maintain

### 10. **Fat Interface** 🍔
- **Location**: `struct fat_interface`
- **Description**: An interface with too many methods/function pointers
- **Problem**: Violates Interface Segregation Principle, forces implementations to support unnecessary methods

### 11. **Format Exposure** 📋
- **Location**: `format_exposure_method()`
- **Description**: Exposing internal data structures and formats directly
- **Problem**: Breaks encapsulation, makes refactoring difficult

### 12. **Decapsulation** 🔓
- **Location**: `decapsulation_method()`
- **Description**: Direct manipulation of what should be private/internal data
- **Problem**: Breaks object-oriented principles, makes code fragile

### 13. **Data Exposure** 📊
- **Location**: `struct exposed_data`
- **Description**: Exposing sensitive internal data without proper access control
- **Problem**: Security risks, breaks encapsulation

### 14. **Unused Methods** 🗑️
- **Location**: `unused_method1()`, `unused_method2()`, `unused_static_method()`
- **Description**: Methods that are defined but never called
- **Problem**: Dead code that clutters the codebase and confuses developers

### 15. **Test Hungry** 🧪
- **Location**: `test_hungry_method()`
- **Description**: Code that's extremely difficult to test due to tight coupling with external dependencies
- **Problem**: Makes automated testing nearly impossible

## Building and Running

### Prerequisites
- GCC compiler
- Make utility
- Math library (libm)

### Build Commands

```bash
# Build the demo
make

# Build and run
make run

# Build with debug flags
make debug

# Clean generated files
make clean

# Show help
make help
```

### Optional Tools

```bash
# Memory leak checking (requires valgrind)
make memcheck

# Static analysis (requires cppcheck)
make static-analysis
```

## Sample Output

When you run the program, it will demonstrate each anti-pattern in action:

```bash
$ make run
gcc -Wall -Wextra -std=c99 -lm -o anti_patterns_demo anti_patterns_demo.c
./anti_patterns_demo
=== C Anti-Patterns Demonstration ===

1. Demonstrating Brain Method anti-pattern:
Processing complete. Result: 25.123456
Calculation result saved to temp_calculation.txt
Brain method result: 42

2. Demonstrating Feature Envy anti-pattern:
Account balance: 1037.685
Customer name: John Doe - Updated
...
```

## Educational Purpose

⚠️ **IMPORTANT**: This code is intentionally poorly designed for educational purposes. In real projects, these patterns should be **avoided** and **refactored**. 

### Best Practices (What to do instead):

1. **Single Responsibility**: Each function/struct should have one clear purpose
2. **Encapsulation**: Hide internal data and provide controlled access
3. **Loose Coupling**: Minimize dependencies between components
4. **High Cohesion**: Group related functionality together
5. **Clear Interfaces**: Keep interfaces simple and focused
6. **Avoid Global State**: Use parameters and return values instead
7. **Proper Error Handling**: Handle errors at appropriate levels
8. **Testability**: Write code that can be easily tested
9. **Clean Code**: Use meaningful names and clear structure
10. **Refactor Regularly**: Continuously improve code quality

## Code Quality Tools

This code can be used to test various code quality and static analysis tools:

- **Embold**: Will detect most of the anti-patterns demonstrated
- **SonarQube**: Will flag code quality issues
- **Cppcheck**: Will find potential bugs and style issues
- **Valgrind**: Will detect memory leaks and errors
- **Clang Static Analyzer**: Will find potential bugs

## Learning Objectives

After studying this code, you should be able to:

1. Identify anti-patterns in existing codebases
2. Understand why these patterns are problematic
3. Recognize the symptoms of poor code design
4. Apply refactoring techniques to improve code quality
5. Write better, more maintainable C code

## Further Reading

- [Embold Anti-Patterns Documentation](https://docs.embold.io/anti-patterns/)
- [Clean Code by Robert C. Martin](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)
- [Refactoring: Improving the Design of Existing Code](https://martinfowler.com/books/refactoring.html)
- [Code Complete by Steve McConnell](https://www.amazon.com/Code-Complete-Practical-Handbook-Construction/dp/0735619670)

---

*Remember: The best way to learn good practices is to first understand what bad practices look like!*
