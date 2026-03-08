/**
 *
 * @author Omkar Anil Gajare
 * @version 6/3/26
 */
class Car extends Vehicle {
  private boolean isLuxury = false;

  /**
   * Create a new Car with the given details.
   *
   * @param vehicleNumber registration number of the vehicle
   * @param ownerName     name of the vehicle owner
   * @param serviceCost   current service cost for the vehicle
   * @param isLuxury      true if the car is classified as luxury
   */
  Car(String vehicleNumber, String ownerName, double serviceCost, boolean isLuxury) {
    this.vehicleNumber = vehicleNumber;
    this.ownerName = ownerName;
    this.serviceCost = serviceCost;
    this.isLuxury = isLuxury;
  }

  /**
   * Apply a 10% discount to `serviceCost` if this is a luxury car.
   */
  void applyDiscount() {
    if (isLuxury == true) {
      serviceCost *= 0.9;
    }
  }
}
