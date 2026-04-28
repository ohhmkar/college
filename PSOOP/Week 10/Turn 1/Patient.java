import java.io.*;
/**
 * Base class for storing patient identity and common validation/billing
 * behavior.
 *
 * @author Omkar Anil Gajare
 * @version 10/4/26
 */
public class Patient {
    protected String patientID = "DEFAULT_ID";
    protected String patientName = "DEFAULT_NAME";
    protected final double BASE_FEES = 0;

    Patient(String patientID, String patientName) {
        this.patientID = patientID;
        this.patientName = patientName;
    }

    public void readPatientDetails() {
        DataInputStream in = new DataInputStream(System.in);
        try {
            System.out.print("Patient ID:");
            patientID = in.readLine();
            if (!isAlphanumeric(patientID)) {
                throw new Exception("Patient ID must be alphanumeric, [a-z; A-Z; 0-9]");
            }

            System.out.print("Patient Name:");
            patientName = in.readLine();
            if (!isAlpha(patientName)) {
                throw new Exception("Patient Name must be alphabetical, [a-z; A-Z]");
            }
        } catch (Exception e) {
            System.out.println("Error! Details: " + e);
        }
    }

    /**
     * Returns the base bill amount for a generic patient.
     */
    public double calculateBill() {
        return BASE_FEES;
    }

    /**
     * Validates that a string contains only letters or digits.
     */
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

    /**
     * Validates that a string contains only alphabetical characters.
     */
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

    /**
     * Checks whether a numeric value is non-negative.
     */
    public boolean isValidNumeric(Double val) {
        if (val < 0) {
            return false;
        }
        return true;
    }
}
