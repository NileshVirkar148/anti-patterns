# Anti-Patterns Demonstration Repository

This repository contains comprehensive examples of software anti-patterns for educational purposes. Anti-patterns are common programming practices that appear to be beneficial but are actually counterproductive and lead to poor code quality, maintenance difficulties, and bugs.

## Purpose

The code in this repository is **intentionally poorly designed** to demonstrate what **NOT** to do in production software. Each example clearly illustrates specific anti-patterns and their problems, helping developers:

1. **Recognize** anti-patterns in existing codebases
2. **Understand** why these patterns are problematic  
3. **Learn** better alternatives and refactoring techniques
4. **Improve** code quality in their own projects

## Languages and Examples

### C Anti-Patterns (`c/` directory)

A comprehensive C program demonstrating 15+ anti-patterns applicable to C-style languages, based on [Embold's anti-patterns documentation](https://docs.embold.io/anti-patterns/):

- **God Class** - Single struct handling too many responsibilities
- **Brain Method** - Overly complex functions doing too much
- **Global Variables** - Shared state causing unpredictable behavior
- **Feature Envy** - Methods using more external data than their own
- **Shotgun Surgery** - Changes requiring modifications everywhere
- **Message Chain** - Excessive method call chaining
- **Fan Out** - Methods calling too many other methods
- **Dispersed Coupling** - Dependencies on many different modules
- **Intensive Coupling** - Functions with too many parameters
- **Fat Interface** - Interfaces with too many methods
- **Format Exposure** - Exposing internal data structures
- **Decapsulation** - Breaking encapsulation principles
- **Data Exposure** - Exposing sensitive internal data
- **Unused Methods** - Dead code cluttering the codebase
- **Test Hungry** - Code that's difficult to test

### Quick Start (C Examples)

```bash
cd c/
make run          # Build and run the demo
make help         # Show available build targets
./test.sh         # Run comprehensive tests
```

## Educational Value

⚠️ **Important**: This code demonstrates **bad practices** for learning purposes. In real projects:

- **Refactor** these patterns when you encounter them
- **Apply** clean code principles instead
- **Use** proper design patterns and best practices
- **Test** your code thoroughly
- **Review** code regularly for quality issues

## Anti-Pattern Categories

Based on Embold's classification, the demonstrated anti-patterns fall into these categories:

- **Component-level** anti-patterns (affect entire modules/classes)
- **Subcomponent-level** anti-patterns (affect individual methods/functions)
- **Structural** problems (organization and dependencies)
- **Behavioral** problems (how code behaves and interacts)

## Code Quality Tools

This code is designed to trigger various static analysis and code quality tools:

- **Embold** - Will detect most demonstrated anti-patterns
- **SonarQube** - Will flag code quality issues
- **Cppcheck** - Will find potential bugs and style issues  
- **Clang Static Analyzer** - Will find potential bugs
- **Valgrind** - Will detect memory issues (when applicable)

## Learning Path

1. **Study** the code and identify the anti-patterns
2. **Run** static analysis tools to see what they detect
3. **Practice** refactoring the code to eliminate anti-patterns
4. **Apply** the lessons to improve your own code
5. **Share** knowledge with your team about code quality

## Contributing

If you'd like to add examples for other languages or additional anti-patterns:

1. Create a new directory for the language
2. Include comprehensive examples with clear documentation
3. Add a README explaining the anti-patterns demonstrated
4. Include build/run instructions and tests
5. Update this main README

## References

- [Embold Anti-Patterns Documentation](https://docs.embold.io/anti-patterns/)
- [Clean Code by Robert C. Martin](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)
- [Refactoring: Improving the Design of Existing Code](https://martinfowler.com/books/refactoring.html)
- [Code Complete by Steve McConnell](https://www.amazon.com/Code-Complete-Practical-Handbook-Construction/dp/0735619670)

---

*"The best way to learn good practices is to first understand what bad practices look like!"*
