# Java Anti-Patterns Examples

This folder contains examples of common Java anti-patterns as documented by [Embold](https://docs.embold.io/anti-patterns/).

## Anti-Patterns Included

1. **God Class** - A class that knows too much or does too much
2. **Brain Method** - A method that is too complex and does too many things
3. **Brain Class** - A class that is overly complex
4. **Feature Envy** - A method that accesses data from another class more than its own
5. **Message Chain** - A chain of method calls that creates tight coupling
6. **Shotgun Surgery** - A change requires modifications in many classes
7. **Fat Interface** - An interface with too many methods
8. **Dispersed Coupling** - A class that is coupled to many other classes
9. **Fan Out** - A method that calls too many other methods
10. **Intensive Coupling** - Excessive coupling between classes

## Structure

- Each anti-pattern has its own package with examples
- Both "bad" and "good" implementations are provided where applicable
- Comments explain why the pattern is problematic and how to improve it

## How to Run

```bash
# Compile all examples
javac -d out src/**/*.java

# Run specific examples (replace with actual main class)
java -cp out com.antipatterns.godclass.GodClassExample
```

## Anti-Pattern Descriptions

### God Class
A class that has grown too large and handles multiple responsibilities, violating the Single Responsibility Principle.

### Brain Method
A method that is too complex, with high cyclomatic complexity, making it hard to understand and maintain.

### Feature Envy
A method that uses methods and fields from another class more than its own, suggesting it should belong to that other class.

### Message Chain
A series of method calls like `a.getB().getC().getD().doSomething()` that creates tight coupling.

### And more...

Each example demonstrates the anti-pattern and provides a refactored solution.
