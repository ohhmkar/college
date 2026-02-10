import java.io.*;
/**
 * This program takes input of different amount of coins and prints the value of the sum.
 *
 * @author Omkar Gajare
 * @version 4/2/26
 *
 */

public class Coins
{
    static final double PENNY = 0.01,NICKEL = 0.05,DIME=0.1,QUARTER=0.25; //Constant values for each coin type
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);
        System.out.print("Enter number of pennies:");//Entry of number of pennies
        double penny_val = PENNY*Integer.parseInt(in.readLine());
        System.out.print("Enter number of nickels:");//Entry of number of nickels
        double nickel_val = NICKEL*Integer.parseInt(in.readLine());
        System.out.print("Enter number of dimes:");//Entry of number of dimes
        double dime_val = DIME*Integer.parseInt(in.readLine());
        System.out.print("Enter number of quarters:");//Entry of number of quarters
        double quarter_val = QUARTER*Integer.parseInt(in.readLine());
        //Calculates total value of coins
        double total = penny_val+nickel_val+dime_val+quarter_val;
        System.out.println();
        System.out.println("Total Value of Coins= $"+total);
    }
}