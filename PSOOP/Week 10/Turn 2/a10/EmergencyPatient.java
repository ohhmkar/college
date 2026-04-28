import java.io.*;
/**
 * Class representing an emergency patient in the health management system,
 * extending the RegularPatient class and adding specific services related to
 * emergency care.
 *
 * @author Omkar Anil Gajare
 * @version 10/4/26
 */
public class EmergencyPatient extends RegularPatient {
    // Specific field maintaining urgent response expense
    protected double emergencyServiceCharge = 0;

    /** Parameterized constructor for EmergencyPatient. */
    EmergencyPatient(String patientID, String patientName) {
        super(patientID, patientName);
    }

    /** Default constructor for EmergencyPatient. */
    EmergencyPatient() {
    }

    /** Takes in charge associated specifically with emergencies. */
    public void readEmergencyServiceCharges() {
        DataInputStream in = new DataInputStream(System.in);

        // Loop implementation verifying correctness of input value
        while (true) {
            try {
                System.out.print("Enter Emergency Service Charge: ");
                emergencyServiceCharge = Double.parseDouble(in.readLine());

                // Delegate to generic utility checking negativity constraint
                if (!isValidNumeric(emergencyServiceCharge)) {
                    throw new OmException("Emergency Service Charges cannot be negative!");
                }
                break; // If no issues arise, finish loop iteration phase successfully
            } catch (OmException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * External provider block returning this item's specific fee payload.
     * 
     * @return Double denoting urgent service total.
     */
    public double getEmergencyServiceCharges() {
        return emergencyServiceCharge;
    }

    /**
     * Broadens internal scope of summing by integrating immediate fee requirements.
     * 
     * @return Entire compilation of all applicable categories combined together.
     */
    @Override
    public double calculateBill() {
        return (getDiagnosticCharges() + getConsultationCharges() + getEmergencyServiceCharges());
    }

    /** Integrates immediate fee requirements into the total bill. */
    @Override
    public void readAllCharges() {
        readDiagnosticCharges();
        readConsultationCharges();
        readEmergencyServiceCharges();
    }
}
