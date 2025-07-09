#!/bin/bash

# Test script for C Anti-Patterns Demo
echo "=== Testing C Anti-Patterns Demo ==="
echo

# Check if make is available
if ! command -v make &> /dev/null; then
    echo "ERROR: make is not available"
    exit 1
fi

# Check if gcc is available
if ! command -v gcc &> /dev/null; then
    echo "ERROR: gcc is not available"
    exit 1
fi

echo "✓ Build tools available"

# Clean any previous builds
echo "Cleaning previous builds..."
make clean &> /dev/null

# Build the project
echo "Building anti-patterns demo..."
if make &> build.log; then
    echo "✓ Build successful"
else
    echo "✗ Build failed"
    echo "Build log:"
    cat build.log
    exit 1
fi

# Run the demo
echo "Running anti-patterns demo..."
if make run > output.log 2>&1; then
    echo "✓ Program executed successfully"
else
    echo "✗ Program execution failed"
    echo "Output log:"
    cat output.log
    exit 1
fi

# Check if expected output patterns are present
echo "Verifying output contains expected anti-patterns..."

expected_patterns=(
    "Brain Method anti-pattern"
    "Feature Envy anti-pattern"
    "Message Chain anti-pattern"
    "Fan Out anti-pattern"
    "Dispersed Coupling anti-pattern"
    "Intensive Coupling anti-pattern"
    "Format Exposure anti-pattern"
    "Decapsulation anti-pattern"
    "Test Hungry anti-pattern"
    "Global Variables anti-pattern"
)

missing_patterns=()
for pattern in "${expected_patterns[@]}"; do
    if grep -q "$pattern" output.log; then
        echo "  ✓ Found: $pattern"
    else
        echo "  ✗ Missing: $pattern"
        missing_patterns+=("$pattern")
    fi
done

if [ ${#missing_patterns[@]} -eq 0 ]; then
    echo "✓ All expected anti-patterns demonstrated"
else
    echo "✗ Missing ${#missing_patterns[@]} anti-patterns"
    exit 1
fi

# Check if temporary files are created (and clean them)
if [ -f "temp_calculation.txt" ]; then
    echo "✓ Temporary files created as expected"
    rm -f temp_calculation.txt
fi

if [ -f "hardcoded_file.txt" ]; then
    rm -f hardcoded_file.txt
fi

echo
echo "=== All Tests Passed ==="
echo "The C anti-patterns demonstration is working correctly!"
echo
echo "Files created:"
echo "  - anti_patterns_demo.c (main source file)"
echo "  - Makefile (build configuration)"
echo "  - README.md (documentation)"
echo "  - test.sh (this test script)"
echo
echo "Usage:"
echo "  make          # Build the demo"
echo "  make run      # Build and run"
echo "  make clean    # Clean generated files"
echo "  make help     # Show available targets"

# Clean up log files
rm -f build.log output.log
