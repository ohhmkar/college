class FuelVehicle extends Vehicle{
    final double surcharge = 20;//initialising a surcharge (20 for now)
    /**
     * Parameterized Constructor 
     * @param vehicleType Stores vehicle type
     * @param regNumber Stores registration number
     **/
    FuelVehicle(String vehicleType, String regNumber){
        super(vehicleType, regNumber);//Super constructor for base class vehicle
    }

    /**
     * Function to return calculate Parking Fee, returns Base parking fee + surcharge
     * @returns parking fee
     **/
    double calculateParkingFee(){
        return BASE_PARKING_FEE+surcharge;
    }
}
