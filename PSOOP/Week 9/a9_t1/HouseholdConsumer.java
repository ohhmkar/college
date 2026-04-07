import java.io.*;
/**
 * Implements electricity and water billing for a household consumer.
 *
 * @author Omkar Anil Gajare
 * @version 1/4/26
*/
class HouseholdConsumer implements UtilityBill
{
    //instantiating values
    protected int electricityUnits, waterUnits;
    protected float electricityCharge, waterCharge;
    final float pricePerWattHour = 5    , pricePerKiloLitre = 2;
    String consumerId;
    /** Creates a consumer record identified by consumer id. */
    HouseholdConsumer(String consumerId){
        // Consumer identifier is captured once and reused in final bill output.
        this.consumerId = consumerId;
    }
    
    @Override
    /** Reads electricity usage units from console input. */
    public void readElectricityUnits(){
        DataInputStream in = new DataInputStream(System.in);
        try{
            System.out.print("Enter Electricity Units: ");
            electricityUnits = Integer.parseInt(in.readLine());
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
    
    @Override
    public void computeElectricityBill(){
        // Compute bill directly from units and fixed per-unit tariff.
        electricityCharge = electricityUnits * pricePerWattHour;
    }
    
    @Override
    public void readWaterUnits(){
        DataInputStream in = new DataInputStream(System.in);
        try{
            // Read total water units before applying per-kilolitre pricing.
            System.out.print("Enter Water Units: ");
            waterUnits = Integer.parseInt(in.readLine());
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
    
    @Override
    public void computeWaterBill(){
        // Water billing follows the same linear pricing model.
        waterCharge = waterUnits * pricePerKiloLitre;
    }
    
    @Override
    public void displayTotalBill(){
        // Total utility amount is the sum of computed component charges.
        float totalBill = electricityCharge + waterCharge;
        System.out.println("\n--- Utility Bill ---");
        System.out.println("Consumer Id:    "+consumerId);
        System.out.println("Electricity Bill: Rs."+electricityCharge);
        System.out.println("Water Bill: Rs."+waterCharge);
        System.out.println("Total Bill: Rs."+(totalBill));
    }
}