/**
 * Declares electricity unit input and bill computation behavior.
 *
 * @author Omkar Anil Gajare
 * @version 1/4/26
*/

interface ElectricityUsage
{
    /** Reads electricity units consumed for billing. */
    void readElectricityUnits();
    /** Computes electricity charges from captured units. */
    void computeElectricityBill();
}