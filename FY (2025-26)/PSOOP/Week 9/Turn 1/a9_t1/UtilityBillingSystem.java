import java.io.*;
/**
 * Drives utility bill input, calculation, and final display for one consumer.
 *
 * @author Omkar Anil Gajare
 * @version 1/4/26
*/
public class UtilityBillingSystem
{
    /** Runs the complete utility billing workflow from input to output. */
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);
        String consumerId;
        // Start by collecting consumer context used across the billing steps.
        System.out.print("Consumer ID: ");
        consumerId = in.readLine();
        
        // Single consumer object coordinates all utility-related calculations.
        HouseholdConsumer HC = new HouseholdConsumer(consumerId);
        // Read units first, then compute both charges before final display.
        HC.readElectricityUnits();
        HC.computeElectricityBill();
        HC.readWaterUnits();
        HC.computeWaterBill();
        
        HC.displayTotalBill();
    }
}