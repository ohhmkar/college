class ElectricVehicle extends FuelVehicle{
    /**
     * Parameterized Constructor 
     * @param regNumber Stores registration number
     **/
    ElectricVehicle(String regNumber){
        super("ElectricVehicle",regNumber);
    }
    /**
     * Function to return calculate Parking Fee, returns Base parking fee + surcharge
     * @returns parking fee
     **/
    double calculateParkingFee(){
        return BASE_PARKING_FEE - 10 + surcharge;
    }
}
