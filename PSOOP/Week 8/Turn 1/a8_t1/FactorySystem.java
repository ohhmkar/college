import java.io.*;
import java.util.*;
/**
 * Write a description of class FactorySystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FactorySystem
{
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);
        System.out.println("Enter number of machines: ");
        int noOfMachines = Integer.parseInt(in.readLine());

        Machine[] machines = new Machine[noOfMachines];
        int machineType;
        for(int i = 0;i<noOfMachines;i++){
            int machineId=0; String manufacturer=""; int operatingHours=0;
            System.out.println("Enter type of machine: 1-Cutting, 2-Welding");
            machineType = Integer.parseInt(in.readLine());
            if(machineType != 1 && machineType != 2){
                System.out.println("Error! Choose a valid machine type!");
                break;
            }
            System.out.println("Machine Id: ");
            machineId = Integer.parseInt(in.readLine());

            System.out.println("Manufacturer: ");
            manufacturer = in.readLine();

            System.out.println("Operating Hours: ");
            operatingHours = Integer.parseInt(in.readLine());

            if(machineType == 1){
                machines[i] = new CuttingMachine(machineId, manufacturer, operatingHours);
            }
            else{
                machines[i] = new WeldingMachine(machineId, manufacturer, operatingHours);
            }
        }
        
        System.out.println("==== MACHINE REPORT ====");
        for(int i=0;i<noOfMachines;i++){
            machines[i].displayBasicInfo();
            machines[i].performOperation();
            System.out.println("Maintenance Cost: "+machines[i].calculateMaintenanceCost());
            if(machines[i] instanceof CuttingMachine){
                System.out.println("Energy Usage: "+((CuttingMachine)machines[i]).calculateEnergyUsage());
                ((CuttingMachine)machines[i]).sendStatus();
            }
            else{
                System.out.println("Energy Usage: "+((WeldingMachine)machines[i]).calculateEnergyUsage());
                ((WeldingMachine)machines[i]).sendStatus();
            }
            System.out.println("----------------------");
        }
    }
}

