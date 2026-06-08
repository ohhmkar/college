class PetrolVehicle extends FuelVehicle
{
    /**
     * Parameterized Constructor
     * @param regNumber Stores registration number
     **/
    PetrolVehicle(String regNumber){
        super("PetrolVehicle",regNumber);
    }
    /**
     * Function to return calculate Parking Fee, returns Base parking fee + 30 + surcharge for petrol vehicles
     * @returns parking fee
     **/
    double calculateParkingFee(){
        return BASE_PARKING_FEE + 30 + surcharge;
    }
}