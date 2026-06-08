import java.io.*;
/**
 * Main Engine class for the program.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntegratedHealthManagementSystem {
    /** Main method serving as entry point of the app. */
    public static void main(String args[]) {
        DataInputStream in = new DataInputStream(System.in);
        // Display root menu and wait for selections
        System.out.println("Select Patient Type");
        System.out.println("1. Regular Patient");
        System.out.println("2. Emergency Patient");
        System.out.println("3. Insured Patient");
        int choice;
        while (true) {
            try {
                System.out.println("Choice: ");
                choice = Integer.parseInt(in.readLine());
                if (choice != 1 && choice != 2 && choice != 3) {
                    throw new OmException("Enter valid Choice! (1-3)");
                }
                break; // Valid choice, proceed
            } catch (OmException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("IO Exception: " + e);
            }
        }

        switch (choice) {
            case 1:
                // Construct basic regular patient and output workflow
                RegularPatient p1 = new RegularPatient();
                p1.readPatientDetails();
                p1.readAllCharges();
                p1.printBill();
                break;
            case 2:
                // Setup emergency patient, prompting for extra emergency fees
                EmergencyPatient p2 = new EmergencyPatient();
                p2.readPatientDetails();
                p2.readAllCharges();
                p2.printBill();
                break;
            case 3:
                // Construct fully featured insured patient
                InsuredPatient p3 = new InsuredPatient();
                p3.readPatientDetails();
                p3.readAllCharges();
                p3.printBill();
                break;
        }
    }
}
