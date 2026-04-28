import java.io.*;
/**
 * Represents a regular patient billed for consultation and diagnostic services.
 *
 * @author Omkar Anil Gajare
 * @version 10/4/26
 */
public class RegularPatient extends Patient implements ConsultationService, DiagnosticService {
    protected double DIAGNOSTIC_CHARGES = 0;
    protected double CONSULTATION_CHARGES = 0;

    RegularPatient(String patientID, String patientName) {
        super(patientID, patientName);
    }

    /**
     * Reads consultation charges from console input.
     */
    @Override
    public void readConsultationCharges() {
        DataInputStream in = new DataInputStream(System.in);
        try {
            System.out.print("Consultation Charges: ");
            CONSULTATION_CHARGES = Double.parseDouble(in.readLine());
            if (!isValidNumeric(CONSULTATION_CHARGES)) {
                CONSULTATION_CHARGES = 0;
                throw new Exception("Consultation Charges cannot be negative! Consultation Charge defaulting to 0");
            }
        } catch (Exception e) {

            System.out.println("Error! Details: " + e);
        }
    }

    /**
     * Reads diagnostic charges from console input.
     */
    @Override
    public void readDiagnosticCharges() {
        DataInputStream in = new DataInputStream(System.in);
        try {
            System.out.print("Diagnostic Charges: ");
            DIAGNOSTIC_CHARGES = Double.parseDouble(in.readLine());
            if (!isValidNumeric(DIAGNOSTIC_CHARGES)) {
                DIAGNOSTIC_CHARGES = 0;
                throw new Exception("Diagnostic Charges cannot be negative! Diagnostic Charge defaulting to 0");
            }
        } catch (Exception e) {
            System.out.println("Error! Details: " + e);
        }
    }

    /**
     * Returns diagnostic charges for this patient.
     */
    @Override
    public double getDiagnosticCharges() {
        return DIAGNOSTIC_CHARGES;
    }

    /**
     * Returns consultation charges for this patient.
     */
    @Override
    public double getConsultationCharges() {
        return CONSULTATION_CHARGES;
    }

    /**
     * Calculates total bill as consultation plus diagnostic charges.
     */
    @Override
    public double calculateBill() {
        return (getDiagnosticCharges() + getConsultationCharges());
    }
}
