/**
 * HealthPolicy Class serves as template for SeniorCitizen as well as a standalone policy 
 * 
 * @author Omkar Anil Gajare
 * @version 25/3/26
 * 
 * Parameterized constructor
 * @param String policyID stores policy ID
 * @param String policyHolderName stores policy holders name
 * @param boolean isSenior flag for if the policy is for seniors or not
 * 
 * 
 * calculatePremium Calculates Premium
 * @returns BASE_PREMIUM+hospitalCoverageCost
 * 
 */
sealed class HealthPolicy extends Policy permits SeniorCitizenPolicy{
    final protected double hospitalCoverageCost = 2000;//defined at 2000, can be modified but cannot be reassgined
    HealthPolicy(String policyId,String policyHolderName, boolean isSenior){
        super(policyId,
              policyHolderName,
             (isSenior? "SeniorCitizenPolicy" : "HealthPolicy")); // sets policyType to base Health or senior based on isSenior flag
    }
    double calculatePremium(){
        return BASE_PREMIUM + hospitalCoverageCost;//premium is now added with hospital coverage cost
    }
}
