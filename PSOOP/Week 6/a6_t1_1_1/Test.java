import java.io.*;
/**
 * @author Omkar Anil Gajare
 * @version 6/3/26
 */class Test {
  public static void main(String args[]) throws IOException {
    String vehicleNumber, ownerName;
    DataInputStream in = new DataInputStream(System.in);

    // Read basic vehicle details
    System.out.println("Enter Vehicle Number: ");
    vehicleNumber = in.readLine();
    System.out.println("Enter Owner Name: ");
    ownerName = in.readLine();

    // Whether the car is luxury (affects discount)
    System.out.println("Is Luxury Car? ");
    boolean luxuryCheck = Boolean.parseBoolean(in.readLine());

    // Read the service costs
    System.out.println("Enter Service Cost: ");
    Double serviceCost = Double.parseDouble(in.readLine());

    System.out.println("Enter Additional Service Cost: ");
    serviceCost += Double.parseDouble(in.readLine());

    // Create Car instance with collected information
    System.out.println("Enter Service Type: ");
    Car car = new Car(vehicleNumber, ownerName, serviceCost, luxuryCheck);

    // Record the service type and apply any luxury discount
    car.addService(serviceCost, in.readLine());
    car.applyDiscount();

    // Print the final service details
    System.out.println();
    car.displayVehicleDetails();
  }
}
