import java.util.*;
import java.io.*;
/**
 * Base Class Vehicle
 * Basic outline for specfic vehicle classes, acts as a template
 **/
class Vehicle{
  //Initialising base parking fee to 50, uninstanstiated vehicle type and uninstantiated regNumber.
  final double BASE_PARKING_FEE = 50;
  public String vehicleType;
  public String regNumber;
  /**
   * Parameterized Constructor 
   * @param vehicleType Stores vehicle type
   * @param regNumber Stores registration number
   **/
  Vehicle(String vehicleType, String regNumber){
    this.vehicleType = vehicleType;
    this.regNumber = regNumber;
  }
  /**
   * Function to display vehicle type
   * Unparameterized but uses vehicleType variable in class to print vehicleType
   **/
  final void displayVehicleType(){
    if(vehicleType == "ElectricVehicle"){
      System.out.println("Vehicle Type: "+vehicleType);
    }
    if(vehicleType == "PetrolVehicle"){
      System.out.println("Vehicle Type: "+vehicleType);
    }
    if(vehicleType == "CommercialVehicle"){
      System.out.println("Vehicle Type: "+vehicleType);
    }
  }
  /**
   * Function to return calculate Parking Fee, returns Base Parking Fee for now 
   * @returns parking fee
   **/
  double calculateParkingFee(){
    return BASE_PARKING_FEE;
  }
}
