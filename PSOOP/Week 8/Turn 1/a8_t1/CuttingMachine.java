
/**
 * Write a description of class CuttingMachine here.
 *
 * @author Omkar Anil Gajare
 * @version 26/3/26
 */
class CuttingMachine extends Machine implements RemoteMonitor, EnergyConsumer
{
    final double maintenanceCost = 15.5;
    final double energyCost = 4.2;

    CuttingMachine(int machineID, String manufacturer, int operatingHours){
        super(machineID, manufacturer, operatingHours);
    }

    void performOperation(){
        System.out.println("Cutting operation in progress");
    }
    
    public void sendStatus(){
        System.out.println("Cutting Machine Status: ACTIVE");
    }

    double calculateMaintenanceCost(){
        return maintenanceCost*operatingHours;
    }

    public double calculateEnergyUsage(){
        return energyCost*operatingHours;
    }

}
