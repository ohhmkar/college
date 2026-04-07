/**
 * Defines methods from interfaces it extends
 *
 * @author Omkar Anil Gajare
 * @version 26/3/26
 */
class WeldingMachine extends Machine implements RemoteMonitor, EnergyConsumer {
    // Per-hour cost constants for welding machines.
    final double maintenanceCost = 18;
    final double energyCost = 5.5;

    // Inherits shared state from Machine and fulfills both interface contracts.
    WeldingMachine(int machineID, String manufacturer, int operatingHours) {
        super(machineID, manufacturer, operatingHours);
    }

    @Override
    // Required concrete version of Machine.performOperation().
    void performOperation() {
        System.out.println("Welding operation in progress");
    }

    @Override
    public void sendStatus() {
        System.out.println("Welding Machine Status: ACTIVE");
    }

    @Override
    // Formula based on operating hour multiplier.
    double calculateMaintenanceCost() {
        return maintenanceCost * operatingHours;
    }

    @Override
    // Interface method from EnergyConsumer.
    public double calculateEnergyUsage() {
        return energyCost * operatingHours;
    }

}
