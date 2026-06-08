class CommercialVehicle extends Vehicle
{
    /**
     * Parameterized Constructor
     * @param regNumber Stores registration number
     **/
    CommercialVehicle(String regNumber){
        super("CommercialVehicle", regNumber);
    }
    /**
     * Function to return calculate Parking Fee, returns Base parking fee * 2 for commercial vehicles
     * @returns parking fee
     **/
    double calculateParkingFee(){
        return BASE_PARKING_FEE*2;
    }
}