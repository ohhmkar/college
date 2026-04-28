import java.io.*;
/**
 * Class representing a patient in the health management system, serving as a
 * base for various patient types.
 *
 * @author Omkar Anil Gajare
 * @version 10/4/26
 */
public class Patient {
    // Attributes to hold common patient details
    protected String patientID = "DEFAULT_ID";
    protected String patientName = "DEFAULT_NAME";
    protected final double BASE_FEES = 0;

    /** Parameterized constructor for Patient. */
    Patient(String patientID, String patientName) {
        // Initialize instance variables from parameters
        this.patientID = patientID;
        this.patientName = patientName;
    }

    /** Default constructor for Patient. */
    Patient() {
    }

    /** Reads and validates base details from user input. */
    public void readPatientDetails() {
        DataInputStream in = new DataInputStream(System.in);
        // Flag to track if a valid ID was successfully entered
        boolean IDFlag = false;

        while (true) {
            try {
                if (!IDFlag) {
                    while (true) {
                        try {
                            // Loop for a valid ID until criteria is met
                            System.out.print("Enter Patient ID:");
                            patientID = in.readLine();

                            // Check that ID conforms to alphanumeric pattern
                            if (!isAlphanumeric(patientID)) {
                                throw new OmException("Patient ID must be alphanumeric, [a-z; A-Z; 0-9]");
                            }
                            IDFlag = true;
                            break;
                        } catch (OmException e) {
                            System.out.println(e.getMessage());
                        } catch (IOException e) {
                            System.out.println("Error! Details: " + e);
                        }
                    }
                }
                System.out.print("Enter Patient Name:");
                patientName = in.readLine();
                if (!isAlpha(patientName)) {
                    throw new OmException("Patient Name must be alphabetical, [a-z; A-Z]");
                }
                break; // Everything valid, exit main loop
            } catch (OmException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Error! Details: " + e);
            }
        }
    }

    /** Calculates bill using base configuration. */
    public double calculateBill() {
        return BASE_FEES;
    }

    /** Prints generated billing details. */
    public void printBill() {
        System.out.println("\n----- BILL DETAILS -----");
        System.out.println("Patient ID: " + patientID);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Total Payable Amount: Rs." + calculateBill());
        System.out.println();
    }

    public boolean isAlphanumeric(String str) {
        if (str == null || str.isEmpty())
            return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAlpha(String str) {
        if (str == null || str.isEmpty())
            return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidNumeric(Double val) {
        if (val < 0) {
            return false;
        }
        return true;
    }
}
