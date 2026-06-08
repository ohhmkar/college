import java.io.*;
/**
 * Takes input of amount due and amount recieved and prints the change and its divisions in coins.
 *
 * @author Omkar Anil Gajare
 * @version 4/2/26
 */
public class ChangeCalculatorWithOutWhile
{
    static final double PENNY = 0.01,NICKEL = 0.05,DIME=0.1,QUARTER=0.25;
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);
        double amt_due,amt_rec;
        //Prompt user for amount due for user
        System.out.print("Enter amount due: ");
        amt_due = Double.parseDouble(in.readLine());
        //Prompt user for amount recieved by user
        System.out.print("Enter amount recieved: ");
        amt_rec = Double.parseDouble(in.readLine());
        double change = amt_rec - amt_due;//Calculate change to be returned
        System.out.println("Change to be returned = $"+change);
        //Initializing counters for each demonstration
        int dollar_count = 0,
            quarter_count = 0,
            dimes_count = 0,
            nickel_count = 0,
            pennies_count = 0;
            //Calculates number of dollars
            dollar_count = (int)change;//Type casting to int, essentially gives us the number of dollars
            change-=dollar_count;
            //Calculates number of quarters
            quarter_count = (int)( change/0.25);//Dividing by 0.25, and type casting to int gives number of quarters
            change-=(quarter_count*0.25);
            //Calculate number of dimes
            dimes_count = (int)(change/0.1);
            change-=(dimes_count*0.1);
            //Calculate number of nickels
            nickel_count = (int)(change/0.05);
            change-=(nickel_count*0.05);
            //Calculate number of pennies
            pennies_count = (int)(change/0.01);
            change-=(pennies_count*0.01);
        //Prints breakdown of change of denomination
        System.out.println("Dollars: "+dollar_count);
        System.out.println("Quarters: "+quarter_count);
        System.out.println("Dimes: "+dimes_count);
        System.out.println("Nickels: "+nickel_count);
        System.out.println("Pennies: "+pennies_count); 
    }
}