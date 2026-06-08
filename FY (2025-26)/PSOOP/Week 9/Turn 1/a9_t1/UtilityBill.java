/**
 * Combines utility interfaces and exposes total bill display behavior.
 *
 * @author Omkar Anil Gajare
 * @version 1/4/26
*/
interface UtilityBill extends ElectricityUsage, WaterUsage
{
    /** Displays the combined utility bill summary. */
    void displayTotalBill();
}