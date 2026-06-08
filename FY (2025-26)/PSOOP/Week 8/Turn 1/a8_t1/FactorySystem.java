import java.io.*;
/**
 * Main class for the IO and execution of logic
 *
 * @author Omkar Anil Gajare
 * @version 26/3/26
 */
public class FactorySystem {
    public static void main(String args[]) throws IOException {
        // Read runtime input from console.
        DataInputStream in = new DataInputStream(System.in);
        System.out.println("Enter number of machines: ");
        int noOfMachines = Integer.parseInt(in.readLine());
        // Polymorphic array: can hold any subclass object that extends Machine.
        Machine[] machines = new Machine[noOfMachines];
        int machineType;
        for (int i = 0; i < noOfMachines; i++) {
            int machineId = 0;
            String manufacturer = "";
            int operatingHours = 0;
            System.out.println("Enter type of machine: 1-Cutting, 2-Welding");
            machineType = Integer.parseInt(in.readLine());
            // Guard clause for invalid machine type input.
            if (machineType != 1 && machineType != 2) {
                System.out.println("Error! Choose a valid machine type!");
                break;
            }
            System.out.println("Machine Id: ");
            machineId = Integer.parseInt(in.readLine());

            System.out.println("Manufacturer: ");
            manufacturer = in.readLine();

            System.out.println("Operating Hours: ");
            operatingHours = Integer.parseInt(in.readLine());

            // Object creation is selected dynamically using machineType.
            if (machineType == 1) {
                machines[i] = new CuttingMachine(machineId, manufacturer, operatingHours);
            } else {
                machines[i] = new WeldingMachine(machineId, manufacturer, operatingHours);
            }
        }

        System.out.println("==== MACHINE REPORT ====");
        for (int i = 0; i < noOfMachines; i++) {
            // These calls dispatch to subclass implementations at runtime.
            machines[i].displayBasicInfo();
            machines[i].performOperation();
            System.out.println("Maintenance Cost: " + machines[i].calculateMaintenanceCost());

            // instanceof + cast is used to access interface-implemented methods.
            if (machines[i] instanceof CuttingMachine) {
                System.out.println("Energy Usage: " + ((CuttingMachine) machines[i]).calculateEnergyUsage());
                ((CuttingMachine) machines[i]).sendStatus();
            } else {
                System.out.println("Energy Usage: " + ((WeldingMachine) machines[i]).calculateEnergyUsage());
                ((WeldingMachine) machines[i]).sendStatus();
            }
            System.out.println("----------------------");
        }
    }
}
