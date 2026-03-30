/**
 * SeniorCitizen Policy 
 * 
 * @author Omkar Anil Gajare
 * @version 25/3/26
 * 
 * Parameterized constructor
 * @param String policyID stores policy ID
 * @param String policyHolderName stores policy holders name
 * 
 * calculatePremium Calculates Premium
 * @returns premium 
 * 
 */
final class SeniorCitizenPolicy extends HealthPolicy{
  final double ageRiskFactor = 2000;//defining ageRiskFactor to 2000, variables are modular but value cant be overwritten
  SeniorCitizenPolicy(String policyId, String policyHolderName){
    super(policyId, policyHolderName, true);
  }
  double calculatePremium(){
    return BASE_PREMIUM + hospitalCoverageCost + ageRiskFactor;//now premium is added with hospitalcoverage and ageriskfactor
  }
}
