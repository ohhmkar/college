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
        System.out.print("Enter amount due: ");
        amt_due = Double.parseDouble(in.readLine());
        System.out.print("Enter amount recieved: ");
        amt_rec = Double.parseDouble(in.readLine());
        double change = amt_rec - amt_due;
        System.out.println("Change to be returned = $"+change);
        int dollar_count = 0,
            quarter_count = 0,
            dimes_count = 0,
            nickel_count = 0,
            pennies_count = 0;
            
            //Calculates number of dollars
            dollar_count = (int)change;//Type casting to int, essentially gives us the number of dollars
            change-=dollar_count;
            //Calculates number of pennies
            quarter_count = (int)( change/0.25);//Dividing by 0.25, and type casting to int gives number of quarters
            change-=(quarter_count*0.25);
            
            dimes_count = (int)(change/0.1);
            change-=(dimes_count*0.1);
            
            nickel_count = (int)(change/0.05);
            change-=(nickel_count*0.05);
            
            pennies_count = (int)(change/0.01);
            change-=(dimes_count*0.01);
        
        System.out.println("Dollars: "+dollar_count);
        System.out.println("Quarters: "+quarter_count);
        System.out.println("Dimes: "+dimes_count);
        System.out.println("Nickels: "+nickel_count);
        System.out.println("Pennies: "+pennies_count); 
    }
}