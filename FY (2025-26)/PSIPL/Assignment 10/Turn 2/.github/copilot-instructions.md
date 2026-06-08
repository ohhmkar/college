# Copilot Instructions for PSIPL Assignment 10

## Project Overview
This is a C programming assignment workspace for **Problem Solving using Programming Languages (PSIPL)** course. The project demonstrates union and struct usage in C through two practical applications:
- **Assignment_10_Turn2_1.c**: Temperature sensor management system
- **Assignment_10_Turn2_2.c**: Hospital patient management system

Author: Omkar Anil Gajare (Roll: 2025300063)

## Code Structure Patterns

### Union vs Struct Architecture
Both programs follow a **union-within-struct pattern** to demonstrate memory efficiency:

**Temperature System** (`Assignment_10_Turn2_1.c`):
- `Temperature` union stores either `celsius` OR `fahrenheit` (never both simultaneously in union)
- `FullTemperature` struct stores both values permanently
- `Sensor` struct contains BOTH union and struct for comparison purposes

**Patient System** (`Assignment_10_Turn2_2.c`):
- `Fee` union stores either `roomCharge` (int) OR `consulationFee` (float)
- `Patient` struct contains the union with `patientType` discriminator (1=inpatient, 2=outpatient)

### Data Flow Pattern
1. **Input → Union**: Raw data stored in union first
2. **Union → Struct**: Union value copied to struct for permanent storage
3. **Computation**: Additional fields calculated (temperature conversion, status)
4. **Display**: Both union and struct data displayed separately to show differences

### Fixed Array Limits
All programs use **fixed capacity of 5 records** (`Sensor sens[5]`, `Patient patients[5]`). Capacity checking is mandatory before adding new records.

## Critical Conventions

### Function Documentation
Every function includes Doxygen-style comments:
```c
/**
 * @brief Brief description
 * @author Omkar Anil Gajare
 * @date DD-MM-YYYY
 * @param name Description
 * @return Description
 */
```

### Temperature Status Logic
In `Assignment_10_Turn2_1.c`, status is always determined from **celsius** value:
- `< 0°C` → 'L' (Low)
- `0-100°C` → 'N' (Normal)  
- `> 100°C` → 'H' (High)

### Input Validation
- Patient type must be 1 or 2 (validated with do-while loop in Assignment_10_Turn2_2.c)
- Buffer clearing with `while (getchar() != '\n');` after scanf
- Capacity checks before adding records

### Menu-Driven Pattern
All programs use identical menu structure:
```c
while (choice != EXIT_VALUE) {
    // Display menu
    scanf("%d", &choice);
    switch(choice) { ... }
}
```

## Build & Run

### Compilation
Use the provided VS Code task or compile manually:
```bash
gcc -fdiagnostics-color=always -g Assignment_10_Turn2_1.c -o Assignment_10_Turn2_1
gcc -fdiagnostics-color=always -g Assignment_10_Turn2_2.c -o Assignment_10_Turn2_2
```

### Execution
```bash
./Assignment_10_Turn2_1  # Temperature system
./Assignment_10_Turn2_2  # Patient system
```

### Debug Symbols
Programs generate `.dSYM` bundles for debugging on macOS (aarch64).

## File Naming Convention
Pattern: `Assignment_<number>_Turn<turn>_<question>.c`
- Executables: Same name without extension
- Work files: `temp.c` (scratch work, may have bugs)

## Key Gotchas

1. **Union Memory Overwrite**: Writing to `temp.celsius` overwrites `temp.fahrenheit` in the union. Always copy to struct for dual storage.

2. **Temperature Conversion Bug**: Original formula `(9/5)` uses integer division (result=1). Correct: `(9.0/5)` or `(9*celTemp)/5`.

3. **Display Differences**: Union display shows last-written value only; struct display shows complete converted data.

4. **Array Indexing**: `noOfSensors` and `numOfPatients` track next free index, not count-1.

## When Modifying Code

- Preserve author attribution in all function headers
- Maintain roll number display in main() entry/exit
- Keep capacity checks before array insertions
- Ensure both union and struct fields are updated consistently
- Test with edge cases: 0°C, 100°C, negative temperatures
