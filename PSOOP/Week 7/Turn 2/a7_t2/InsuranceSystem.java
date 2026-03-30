import java.util.*;
import java.io.*;
/**
 * A basic Insurance System that definies policies, uses runtime polymorphism
 *
 * @author Omkar Anil Gajare
 * @version 25/3/26
 */
public class InsuranceSystem
{
    public static void main(String args[]) throws IOException{
       DataInputStream in = new DataInputStream(System.in); 
       
       System.out.println("Enter number of policies: ");//Prompts user for number of policies to be made
       int noOfPolicies = Integer.parseInt(in.readLine());
       Policy[] policies = new Policy[noOfPolicies];//Makes an array of base class policies of count number of policies
       
       for(int i=0;i<noOfPolicies;i++){
           String policyID = "", policyHolderName = "";//Wiping policyID and policyHolderName for each iteration
           
           System.out.println("Enter policy ID: " );//Prompting user for policyId
           policyID = in.readLine();
           
           System.out.println("Enter policy holder name: ");//Prompting user for policy holder name
           policyHolderName = in.readLine();
           
           System.out.println("Choose Policy Type: ");//Prompting user to choose which policy type
           System.out.println("1. Health, 2. Senior , 3. Vehicle, 4. Travel");
           switch(Integer.parseInt(in.readLine())){
               case 1://Health Policy
                   policies[i] = new HealthPolicy(policyID, policyHolderName, false);
                   break;    
               case 2://Senior Citizen Policy
                   policies[i] = new SeniorCitizenPolicy(policyID, policyHolderName);
                   break;
               case 3://Vehicle Policy
                   policies[i] = new VehiclePolicy(policyID, policyHolderName);
                   break;
               case 4://Travel Policy
                   policies[i] = new TravelPolicy(policyID, policyHolderName);
                   break;
               default://Default Case
                   System.out.println("Please choose a valid policy type");
                   break;
           }
       }
       
       //Printing details for each policy
       System.out.println("===== Policy Premium Details =====");
       for(int i = 0 ; i< noOfPolicies; i++){
            policies[i].showPolicyRules();        
       }
    }
}
