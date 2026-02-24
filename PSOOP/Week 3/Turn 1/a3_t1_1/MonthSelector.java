import java.util.*;
/**
 * This prints the month corresponding to the number entered by the User.
 *
 * @author Omkar Anil Gajare
 * @version 11/2/26
 */
public class MonthSelector
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number (1-12) or -1 to exit");
        //months is a String that stores months spaced out with respect to the largest month in terms of characters
        //As September is the longest month, it has no spaces with the next month, while June has only 4 characters so it has 4 spaces to the next month
        String months = "January  February March    April    May      June     July     August   SeptemberOctober  November December ";
        int n = in.nextInt();
        while(n!=-1){
            if(n>12||n<=0){
                //Check for invalid input
                System.out.println("Invalid Month Number");
            }
            else{
                //Prints the month using a formula that utelises the fact the months are evenly spaced out at 9 characters from each other
                System.out.println(months.substring(9*(n-1),(9*(n-1)+9)));
            }
            //Check for exiting program
            System.out.println("Enter a number (1-12) or -1 to exit");
            n = in.nextInt();
        }
        System.out.println("Program Terminated");
    }
}