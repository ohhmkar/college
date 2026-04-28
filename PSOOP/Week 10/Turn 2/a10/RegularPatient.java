import java.io.*;
/**
 * Class representing a regular patient in the health management system,
 * extending the base Patient class and implementing services for consultation
 * and diagnostics.
 *
 * @author Omkar Anil Gajare
 * @version 10/4/26
 */
public class RegularPatient extends Patient implements ConsultationService, DiagnosticService {
    protected double diagnosticCharges = 0;
    protected double consultationCharges = 0;

    /** Parameterized Constructor for RegularPatient. */
    RegularPatient(String patientID, String patientName) {
        super(patientID, patientName);
    }

    /** Default constructor for RegularPatient. */
    RegularPatient() {
    }

    @Override
    public void readConsultationCharges() {
        DataInputStream in = new DataInputStream(System.in);
        while (true) {
            try {
                System.out.print("Enter Consultation Charges: ");
                consultationCharges = Double.parseDouble(in.readLine());

                // Confirm structural validity for money amounts (no negative values)
                if (!isValidNumeric(consultationCharges)) {
                    consultationCharges = 0;
                    throw new OmException("Consultation Charges cannot be negative!");
                }
                break;
            } catch (OmException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void readDiagnosticCharges() {
        DataInputStream in = new DataInputStream(System.in);
        while (true) {
            try {
                System.out.print("Enter Diagnostic Charges: ");
                diagnosticCharges = Double.parseDouble(in.readLine());

                // Validate data using central method preventing corrupt totals
                if (!isValidNumeric(diagnosticCharges)) {
                    diagnosticCharges = 0;
                    throw new OmException("Diagnostic Charges cannot be negative!");
                }
                break;
            } catch (OmException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Error! Details: " + e);
            }
        }
    }

    /** Retrieves currently loaded diagnostic charges. */
    @Override
    public double getDiagnosticCharges() {
        return diagnosticCharges;
    }

    /** Accesses consultation values recorded. */
    @Override
    public double getConsultationCharges() {
        return consultationCharges;
    }

    /** Evaluates total by merging multiple source streams of cost. */
    @Override
    public double calculateBill() {
        return (getDiagnosticCharges() + getConsultationCharges());
    }

    /** Consecutively calls single-prompt procedures. */
    public void readAllCharges() {
        readDiagnosticCharges();
        readConsultationCharges();
    }
}
