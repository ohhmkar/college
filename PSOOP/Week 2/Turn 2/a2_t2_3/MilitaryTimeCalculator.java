import java.io.*;
/**
 * This program calculates the difference between two times entered in military time format
 *
 * @author Omkar Anil Gajare
 * @version 6/2/26
 */
public class MilitaryTimeCalculator
{
    public static void main(String args[]) throws IOException {
        int time1,time2;
        int no_of_hours,no_of_mins,time_diff;
        DataInputStream in = new DataInputStream(System.in);
        //Takes input of first time
        System.out.print("Please enter the first time: ");
        time1 = Integer.parseInt(in.readLine());
        no_of_hours = time1/100;//Stores number of hours
        //System.out.println(no_of_hours);
        no_of_mins = time1%100;//Stores number of minutes
        //System.out.println(no_of_mins);
        time1 = (no_of_hours*60)+no_of_mins;//Calculates total number of minutes taken to reach that time
        
        System.out.print("Please enter the second time: ");
        time2 = Integer.parseInt(in.readLine());
        no_of_hours = time2/100;//Stores number of hours
        //System.out.println(no_of_hours);
        no_of_mins = time2%100;//Stores number of minutes
        //System.out.println(no_of_mins);
        time2 = (no_of_hours*60)+no_of_mins;//Calculates total number of minutes taken to reach that time
        //Calculates time difference between both, uses ternary to find if time1 is before time2 and adds 1440 to handle overnight
        time_diff = time2-time1>0? time2-time1 : time2-time1+(24*60);
        no_of_hours = time_diff/60;//Calculates hours in time difference
        no_of_mins = time_diff%60;//Calculates mins in time difference
        System.out.println("Time Difference is: "+no_of_hours+" hours "+no_of_mins+" minutes");//Prints the time difference
    }
}