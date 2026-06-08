/**
 * Class that makes methods defined in interfaces concrete
 *
 * @author Omkar Anil Gajare
 * @version 26/3/26
 */
class CuttingMachine extends Machine implements RemoteMonitor, EnergyConsumer {
    // Per-hour cost constants for this machine type.
    final double maintenanceCost = 15.5;
    final double energyCost = 4.2;

    // extends Machine: reuses common machine fields through super(...).
    // implements interfaces: must provide sendStatus() and calculateEnergyUsage().
    CuttingMachine(int machineID, String manufacturer, int operatingHours) {
        super(machineID, manufacturer, operatingHours);
    }

    @Override
    // Concrete implementation of the abstract operation hook from Machine.
    void performOperation() {
        System.out.println("Cutting operation in progress");
    }

    @Override
    public void sendStatus() {
        System.out.println("Cutting Machine Status: ACTIVE");
    }

    @Override
    // Maintenance is proportional to total operating hours.
    double calculateMaintenanceCost() {
        return maintenanceCost * operatingHours;
    }

    @Override
    // Energy usage is also modeled linearly with operating hours.
    public double calculateEnergyUsage() {
        return energyCost * operatingHours;
    }
}
