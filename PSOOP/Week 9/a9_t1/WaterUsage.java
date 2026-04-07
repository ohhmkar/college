
/**
 * Declares water unit input and bill computation behavior.
 *
 * @author Omkar Anil Gajare
 * @version 1/4/26
*/
interface WaterUsage
{
    /** Reads water units consumed for billing. */
    void readWaterUnits();
    /** Computes water charges from captured units. */
    void computeWaterBill();
}