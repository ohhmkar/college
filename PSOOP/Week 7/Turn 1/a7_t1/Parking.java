import java.io.*;
import java.util.*;
public class Parking
{
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);
        int noOfVehicles;
        System.out.print("Enter number of vehicles: ");
        noOfVehicles = Integer.parseInt(in.readLine());
        Vehicle[] vehicles = new Vehicle[noOfVehicles];
        for(int i=0;i<noOfVehicles;i++){
            int vehicleType;
            String regNumber;
            System.out.println("1.Electric 2.Petrol 3.Commercial");
            vehicleType = Integer.parseInt(in.readLine());
            if(vehicleType==1){
                System.out.println("Enter registration number:");
                regNumber = in.readLine();
                vehicles[i] = new ElectricVehicle(regNumber);
            }
            if(vehicleType==2){
                System.out.println("Enter registration number:");
                regNumber = in.readLine();
                vehicles[i] = new PetrolVehicle(regNumber);
            }
            if(vehicleType==3){
                System.out.println("Enter registration number:");
                regNumber = in.readLine();
                vehicles[i] = new CommercialVehicle(regNumber);
            }
        }

        //Printing output
        System.out.println("--- Parking Fee Details ---");
        for(int i=0;i<noOfVehicles;i++){
            vehicles[i].displayVehicleType();
            System.out.println("Registration Number: "+vehicles[i].regNumber);
            System.out.println("Parking Fee: "+vehicles[i].calculateParkingFee());
            System.out.println("\n");
        }
    }
}