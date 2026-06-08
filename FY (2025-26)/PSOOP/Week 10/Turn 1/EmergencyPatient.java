import java.io.*;
/**
 * Represents an emergency patient with an additional emergency service charge.
 *
 * @author Omkar Anil Gajare
 * @version 10/4/26
 */
public class EmergencyPatient extends RegularPatient {
    protected double EMERGENCY_SERVICE_CHARGE = 0;

    EmergencyPatient(String patientID, String patientName) {
        super(patientID, patientName);
    }

    /**
     * Reads emergency service charges from console input.
     */
    public void readEmergencyServiceCharges() {
        DataInputStream in = new DataInputStream(System.in);
        try {
            System.out.print("Emergency Service Charge: ");
            EMERGENCY_SERVICE_CHARGE = Double.parseDouble(in.readLine());
            if (!isValidNumeric(EMERGENCY_SERVICE_CHARGE)) {
                CONSULTATION_CHARGES = 0;
                throw new Exception("Emergency Service Charges cannot be negative! ES Charge defaulting to 0");
            }
        } catch (Exception e) {
            System.out.println("Error! Details: " + e);
        }
    }

}
