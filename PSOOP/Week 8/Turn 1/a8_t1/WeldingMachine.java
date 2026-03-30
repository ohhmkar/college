
/**
 * Write a description of class CuttingMachine here.
 *
 * @author Omkar Anil Gajare
 * @version 26/3/26
 */
class WeldingMachine extends Machine implements RemoteMonitor, EnergyConsumer
{
    final double maintenanceCost = 18;
    final double energyCost = 5.5;

    WeldingMachine(int machineID, String manufacturer, int operatingHours){
        super(machineID, manufacturer, operatingHours);
    }

    void performOperation(){
        System.out.println("Welding operation in progress");
    }

    public void sendStatus(){
        System.out.println("Welding Machine Status: ACTIVE");
    }

    double calculateMaintenanceCost(){
        return maintenanceCost*operatingHours;
    }

    public double calculateEnergyUsage(){
        return energyCost*operatingHours;
    }

}
