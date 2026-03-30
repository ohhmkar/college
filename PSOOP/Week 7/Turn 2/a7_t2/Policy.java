/**
 * Policy Class[Base Class] serves as template for all policies 
 * 
 * @author Omkar Anil Gajare
 * @version 25/3/26
 * 
 * Parameterized constructor
 * @param policyID stores policy ID
 * @param policyHolderName stores policy holders name
 * @param policyType stores indiviual policy type
 * 
 * showPolicyRules Prints all the policy details
 * 
 * calculatePremium Calculates Premium
 * @returns BASE_PREMIUM  for a default implementation
 */
sealed class Policy permits HealthPolicy,TravelPolicy,VehiclePolicy{
    final double BASE_PREMIUM = 5000;//Initializing value of Base Premium
    //Initialzing variables to store values that are independent to each policy
    protected String policyID;
    protected String policyHolderName;
    protected String policyType;
    Policy(String policyID, String policyHolderName, String policyType){
        this.policyID = policyID;
        this.policyHolderName = policyHolderName;
        this.policyType = policyType;
    }

    final void showPolicyRules(){
        System.out.println("Policy rules cannot be modified");//The function being final shows policyRules cannot be modified
        System.out.println("Policy Id: "+policyID);
        System.out.println("Policy Holder Name: "+policyHolderName);
        System.out.println("Policy Type: "+policyType);
        System.out.println("Final Premium: "+calculatePremium());
        System.out.println();
    }

    double calculatePremium(){
        return BASE_PREMIUM; //as a default implementation, it returns BASE_PREMIUM
    }
}
