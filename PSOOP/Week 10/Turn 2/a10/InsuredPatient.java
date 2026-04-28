import java.io.*;
/**
 * InsuredPatient class representing a patient with insurance coverage in the
 * health management system, extending the EmergencyPatient class and
 * implementing
 * the InsuranceService interface to manage insurance-related details and
 * billing.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InsuredPatient extends EmergencyPatient implements InsuranceService {
    // Specific field to hold off coverage limitations
    protected double insuranceDeductible = 0.0;

    /** Parameterized constructor for InsuredPatient. */
    InsuredPatient(String patientID, String patientName) {
        super(patientID, patientName);
    }

    /** Default constructor for InsuredPatient. */
    InsuredPatient() {
    }

    /** Handles specialized prompts for deduction constraints. */
    public void readInsuranceCoverage() {
        DataInputStream in = new DataInputStream(System.in);

        // Loop forces the end user correctly specify deduction quantity
        while (true) {
            try {
                System.out.print("Enter Insurance Deductible: ");
                insuranceDeductible = Double.parseDouble(in.readLine());

                // Confirm valid state regarding existing variables beforehand to ensure logical
                // accuracy
                if (!isValidNumeric(insuranceDeductible)) {
                    insuranceDeductible = 0;
                    throw new OmException("Deductibles cannot be negative! Re-enter!");
                }
                break; // Ends properly out of cycle phase upon clearing
            } catch (OmException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /** Accessor for deductive allowance. */
    public double getInsuranceCoverage() {
        return insuranceDeductible;
    }

    /** Incorporates multiple base modifiers with targeted reductions. */
    @Override
    public double calculateBill() {
        return (getDiagnosticCharges() + getConsultationCharges() + getEmergencyServiceCharges()
                - insuranceDeductible);
    }

    /** Checks valid numeric logic regarding overly heavy deductions. */
    @Override
    public boolean isValidNumeric(Double val) {
        // Compare to total to ensure the patient does not end up owing negative
        if ((val < 0) && (getInsuranceCoverage() > (getConsultationCharges() + getDiagnosticCharges()
                + getEmergencyServiceCharges()))) {
            return false;
        }
        return true;
    }

    /**
     * Centralized execution loop gathering each element of entire scope
     * required accurately complete forms immediately before math resolution step
     * completes.
     */
    @Override
    public void readAllCharges() {
        readDiagnosticCharges();
        readConsultationCharges();
        readEmergencyServiceCharges();
        readInsuranceCoverage();
    }
}
