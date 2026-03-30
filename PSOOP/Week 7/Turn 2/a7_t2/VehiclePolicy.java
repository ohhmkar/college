/**
 * Vehicle Policy 
 * 
 * @author Omkar Anil Gajare
 * @version 25/3/26
 * 
 * Parameterized constructor
 * @param String policyID stores policy ID
 * @param String policyHolderName stores policy holders name
 * 
 * calculatePremium Calculates Premium
 * @returns premium which is Base + vehicle risk surcharge
 * 
 */
final class VehiclePolicy extends Policy{
  final double vehicleRiskSurcharge = 1500;//defining surcharge as 1500, cannot be overwritten in children classes, or in this class
  VehiclePolicy(String policyId, String policyHolderName){
    super(policyId, policyHolderName, "VehiclePolicy");
  }
  double calculatePremium(){
    return BASE_PREMIUM + vehicleRiskSurcharge;
  }
}
