#!/bin/bash

# Java Anti-Patterns Compilation and Execution Script

echo "=== Java Anti-Patterns Demo ==="
echo

# Create output directory
mkdir -p out

# Compile all Java files
echo "Compiling Java anti-pattern examples..."
find src -name "*.java" -print0 | xargs -0 javac -d out

if [ $? -eq 0 ]; then
    echo "✅ Compilation successful!"
    echo
    
    echo "Available examples:"
    echo "1. God Class Anti-Pattern"
    echo "2. God Class Refactored Solution" 
    echo "3. Brain Method Anti-Pattern"
    echo "4. Feature Envy Anti-Pattern"
    echo "5. Message Chain Anti-Pattern"
    echo "6. Fat Interface Anti-Pattern"
    echo
    
    # Run examples
    echo "=== Running God Class Example ==="
    java -cp out com.antipatterns.godclass.UserManagerGodClass
    echo
    
    echo "=== Running Refactored Solution ==="
    java -cp out com.antipatterns.godclass.refactored.RefactoredExample
    echo
    
    echo "=== Running Brain Method Example ==="
    java -cp out com.antipatterns.brainmethod.OrderProcessorBrainMethod
    echo
    
    echo "=== Running Feature Envy Example ==="
    java -cp out com.antipatterns.featureenvy.OrderProcessorFeatureEnvy
    echo
    
    echo "=== Running Message Chain Example ==="
    java -cp out com.antipatterns.messagechain.ProjectReportMessageChain
    echo
    
    echo "=== Running Fat Interface Example ==="
    java -cp out com.antipatterns.fatinterface.FatInterfaceExample
    echo
    
else
    echo "❌ Compilation failed!"
    exit 1
fi
