/**
 *
 * @author Omkar Anil Gajare
 * @version 6/3/26
 */
class Vehicle {
  protected String vehicleNumber;
  protected String ownerName;
  protected double serviceCost;
  static String serviceCenterName = "Autocare Service Center";

  /**
   * Set the service cost for this vehicle.
   * 
   * @param cost new service cost
   */
  void addService(double cost) {
    this.serviceCost = cost;
  }

  /**
   * Set the service cost and record a service type (printed to stdout).
   * 
   * @param cost        new service cost
   * @param serviceType description of the service performed
   */
  void addService(double cost, String serviceType) {
    this.serviceCost = cost;
    System.out.println("Service Type Added: " + serviceType);
  }

  /**
   * Print the vehicle's service details to standard output.
   */
  void displayVehicleDetails() {
    System.out.println("=== Vehicle Service Details ===");
    System.out.println(
        "Service Center: " + serviceCenterName + "\n" +
            "Vehicle Number: " + vehicleNumber + "\n" +
            "Owner Name: " + ownerName + "\n" +
            "Service Cost: " + serviceCost + "\n");
  }

  /**
   * Change the shared service center name used by all Vehicle instances.
   * 
   * @param name new service center name
   */
  static void changeServiceCenter(String name) {
    serviceCenterName = name;
  }
}
