#include <stdio.h>
#include <stdlib.h>
/**
 * @brief Hospital Patient Management System
 * @author Omkar Anil Gajare
 * @date   20-12-2025
 */

/**
 * @union To represent the fee of the patient
 */
typedef union Fee
{
    int roomCharge;       // Room charge for inpatient
    float consulationFee; // Consultation fee for outpatient
} Fee;

/**
 * @struct To represent a patient
 */
typedef struct Patient
{
    int id;          // Unique patient ID
    char name[20];   // Patient name
    int patientType; // 1 for inpatient, 2 for outpatient
    Fee fee;         // Fee information
} Patient;

/**
 * Function to input patient data from user.
 * @param patient Pointer to the patient structure to fill.
 */
void inputData(Patient *patient)
{
    printf("Enter Patient ID: ");
    scanf("%d", &patient->id);
    printf("Enter Patient Name: ");
    scanf("%s", patient->name);
    getchar();
    do
    {
        printf("Update Patient Type (1 = Inpatient, 2 = Outpatient) : ");
        scanf("%d", &patient->patientType);
        if (patient->patientType != 1 && patient->patientType != 2)
        {
            printf("Invalid Patient Type! Please enter 1 or 2.\n");
            while (getchar() != '\n')
                ;
        }
    } while (patient->patientType != 1 && patient->patientType != 2); // Loop until valid input

    if (patient->patientType == 1)
    {
        printf("Enter Room Charge: ");
        scanf("%d", &patient->fee.roomCharge);
    }
    else
    {
        printf("Enter consultation Fee: ");
        scanf("%f", &patient->fee.consulationFee);
    }
}

/**
 * Function to display details of all patients.
 * @param patients Pointer to the array of patients.
 * @param noOfPatients Number of patients in the array.
 */
void displayDetails(Patient *patients, int noOfPatients)
{
    printf("----------- Patient Details ----------\n");
    for (int i = 0; i < noOfPatients; i++) // Loop through each patient
    {
        if (patients[i].patientType == 1) // Inpatient
            printf("Id: %d\nName: %s\nType: Inpatient\nRoom Charge: %d\n\n",
                   patients[i].id,
                   patients[i].name,
                   patients[i].fee.roomCharge);
        else if (patients[i].patientType == 2) // Outpatient
            printf("Id: %d\nName: %s\nType: Outpatient\nConsultation Fee: %.2f\n\n",
                   patients[i].id,
                   patients[i].name,
                   patients[i].fee.consulationFee);
    }
}

/**
 * Function to search for a patient by ID.
 * @param patients Pointer to the array of patients.
 * @param numOfPatients Number of patients in the array.
 * @param id The ID to search for.
 * @return Index of the patient if found, -1 otherwise.
 */
int searchPatient(Patient *patients, int numOfPatients, int id)
{
    for (int i = 0; i < numOfPatients; i++) // Iterate through patients
        if (patients[i].id == id)           // Check if ID matches
            return i;                       // Return index if found
    return -1;                              // Return -1 if not found
}

/**
 * Function to update the fee of a patient by ID.
 * @param patients Pointer to the array of patients.
 * @param numOfPatients Number of patients in the array.
 */
void updateFee(Patient *patients, int numOfPatients)
{
    int id;
    printf("Enter Patient ID to update fee: ");
    scanf("%d", &id);
    int idx = searchPatient(patients, numOfPatients, id); // Find patient index
    if (idx == -1)
    {
        printf("Patient not found.\n");
        return;
    }
    Patient *p = &patients[idx]; // Pointer to the patient
    if (p->patientType == 1)     // Inpatient
    {
        printf("Current Room Charge: %d\n", p->fee.roomCharge);
        printf("Enter new Room Charge: ");
        scanf("%d", &p->fee.roomCharge);
    }
    else // Outpatient
    {
        printf("Current Consultation Fee: %.2f\n", p->fee.consulationFee);
        printf("Enter new Consultation Fee: ");
        scanf("%f", &p->fee.consulationFee);
    }
    printf("Fee updated.\n");
}

/**
 * Function to calculate the total revenue from all patients.
 * @param patients Pointer to the array of patients.
 * @param numOfPatients Number of patients in the array.
 * @return Total revenue as a float.
 */
float calculateTotalRevenue(Patient *patients, int numOfPatients)
{
    float total = 0.0;                      // Initialize total revenue
    for (int i = 0; i < numOfPatients; i++) // Sum fees for all patients
    {
        if (patients[i].patientType == 1) // Inpatient: add room charge
        {
            total += patients[i].fee.roomCharge;
        }
        else // Outpatient: add consultation fee
        {
            total += patients[i].fee.consulationFee;
        }
    }
    return total;
}

int main()
{
    printf("\n2025300063 Omkar Anil Gajare\n\n");
    Patient patients[5];
    int numOfPatients = 0;
    int choice = 0;
    do
    {
        // MENU SETUP
        printf("\n=== Patient Management System ===\n");
        printf("1. Add Patient\n");
        printf("2. Display All Patients\n");
        printf("3. Update Patient Fee\n");
        printf("4. Calculate Total Revenue\n");
        printf("5. Exit\n");
        printf("Enter Choice: ");
        scanf("%d", &choice);
        while (getchar() != '\n')
            ;
        switch (choice)
        {
        case 1: // Add a new patient
            if (numOfPatients < 5)
            {
                inputData(&patients[numOfPatients]);
                numOfPatients++;
            }
            else
            {
                printf("Maximum patients reached.\n");
            }
            break;
        case 2: // Display all patients
            displayDetails(patients, numOfPatients);
            break;
        case 3: // Update fee for a patient
            updateFee(patients, numOfPatients);
            break;
        case 4: // Calculate and display total revenue
            printf("Total Revenue: %.2f\n", calculateTotalRevenue(patients, numOfPatients));
            break;
        case 5: // Exit the program
            break;
        default: // Invalid choice
            printf("Enter valid choice! (1-5)\n");
        }
    } while (choice != 5);

    printf("\n\n2025300063 Omkar Anil Gajare\n");
    return 0;
}
