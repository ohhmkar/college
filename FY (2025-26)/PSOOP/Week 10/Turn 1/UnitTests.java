
/**
 * Simple console-based test runner for patient input and billing methods.
 *
 * @author Omkar Anil Gajare
 * @version 10/4/26
 */
public class UnitTests
{
    /**
     * Entry point for manually testing patient workflows.
     */
    public static void main(String args[]){
        RegularPatient p = new RegularPatient("hi","hello");
        p.readPatientDetails();
        p.readConsultationCharges();
        System.out.println(p.getConsultationCharges());
        p.readDiagnosticCharges();
        System.out.println(p.getDiagnosticCharges());
        
        System.out.println(p.calculateBill());
    }
}