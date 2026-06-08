#include <stdio.h>
#include <stdlib.h>

/**
 * @brief Device Status Management using Bit-fields
 * @author Omkar Anil Gajare
 * @date 19-12-2025
 */

/**
 * @brief Union to represent device status using bit-fields
 * This union allows accessing the same memory location either as:
 * - Individual bit flags (via bits struct)
 * - A single byte value (via allFlags)
 */
typedef union DeviceStatus
{
    unsigned char allFlags; // All 8 bits as a single byte (0-255)
    struct
    {
        unsigned char powerOn : 1;    // Bit 0: Device power status
        unsigned char connected : 1;  // Bit 1: Connection status
        unsigned char error : 1;      // Bit 2: Error flag
        unsigned char batteryLow : 1; // Bit 3: Battery level indicator
        // Bits 4-7 are unused but available for future flags
    } bits; // Individual bit access through struct members
} DeviceStatus;

int main()
{
    // Declare device status variable
    DeviceStatus device;
    device.allFlags = 0; // Initialize all flags to 0 (all OFF)

    int temp; // Temporary variable to read user input
    printf("\n2025300063 Omkar Anil Gajare\n\n");

    // Read Power Status from user
    printf("Enter Power Status (0=Off, 1=On): ");
    scanf("%d", &temp);         // Read integer input
    device.bits.powerOn = temp; // Set the powerOn bit (0 or 1)

    // Read Connection Status from user
    printf("Enter Connection Status (0=Off, 1=On): ");
    scanf("%d", &temp);           // Read integer input
    device.bits.connected = temp; // Set the connected bit (0 or 1)

    // Read Error Status from user
    printf("Enter Error Status (0=Off, 1=On): ");
    scanf("%d", &temp);       // Read integer input
    device.bits.error = temp; // Set the error bit (0 or 1)

    // Read Battery Low Status from user
    printf("Enter Battery Low Status (0=Off, 1=On): ");
    scanf("%d", &temp);            // Read integer input
    device.bits.batteryLow = temp; // Set the batteryLow bit (0 or 1)

    // Display section header
    printf("\n--- Device Status Flags ---\n");

    // Display individual bit flag values
    printf("Power On: %u\n", device.bits.powerOn);       // Print bit 0
    printf("Connected: %u\n", device.bits.connected);    // Print bit 1
    printf("Error: %u\n", device.bits.error);            // Print bit 2
    printf("Battery Low: %u\n", device.bits.batteryLow); // Print bit 3

    // Display combined byte value in hexadecimal format
    // This shows all 8 bits as a single hex value (e.g., 0x0B = 00001011 in binary)
    printf("Combined Flag Byte: 0x%02X\n", device.allFlags);
    printf("\n2025300063 Omkar Anil Gajare\n");

    return 0;
}
