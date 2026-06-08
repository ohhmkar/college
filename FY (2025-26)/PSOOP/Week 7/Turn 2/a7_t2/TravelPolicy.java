/**
 * Travel Policy 
 * 
 * @author Omkar Anil Gajare
 * @version 25/3/26
 * 
 * Parameterized constructor
 * @param String policyID stores policy ID
 * @param String policyHolderName stores policy holders name
 * 
 * calculatePremium Calculates Premium
 * @returns premium which is Base + international travel fee
 * 
 */
final class TravelPolicy extends Policy{
  final double internationalTravelFee = 3000;//defining internationalTravelFee to 3000, value cannot be overwritten
  TravelPolicy(String policyId, String policyHolderName){
    super(policyId, policyHolderName, "TravelPolicy");
  }
  double calculatePremium(){
    return BASE_PREMIUM + internationalTravelFee;
  }
}
