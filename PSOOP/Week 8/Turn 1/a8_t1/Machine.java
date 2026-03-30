
/**
 * Abstract Class Machine to act as a template 
 *
 * @author Omkar Anil Gajare
 * @version 26/3/26
 */
abstract class Machine
{
    protected int machineId;
    protected String manufacturer;
    protected int operatingHours;
    //Constructor
    Machine(int machineId, String manufacturer, int operatingHours){
        this.machineId = machineId;
        this.manufacturer = manufacturer;
        this.operatingHours = operatingHours;
    }

    //Abstract Methods
    abstract void performOperation();
    abstract double calculateMaintenanceCost();
    
    //Concrete Method
    void displayBasicInfo(){
        System.out.println("Machine ID: "+machineId);
        System.out.println("Manufacturer: "+manufacturer);
        System.out.println("Operating Hours: "+operatingHours);
    }
}