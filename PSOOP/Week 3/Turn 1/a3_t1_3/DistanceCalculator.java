import java.util.*;
/**
 * This program calculates distance and time intervals using Preset formulas
 *
 * @author Omkar Gajare
 * @version 11/2/26
 */
public class DistanceCalculator
{
    public static void main(String args[]){
        System.out.println("2025300063_Omkar_Anil_Gajare\t");
        int init_speed,accel,time_interval,total_time;//Initializing basic parameters like initial speed, acceleration, time interval and total time
        Scanner in = new Scanner(System.in);
        int flag = 1;//making a flag variable that acts as a flag for if program is to be terminated or repeated
        while(flag!=0){
            //Prompting user for input of initial velocity
            System.out.println("Enter initial velocity u(m/s): ");
            init_speed = in.nextInt();
            //Prompting user for input of acceleration
            System.out.println("Enter acceleration (m/s^2): ");
            accel = in.nextInt();
            //Prompting user for input of time interval
            System.out.println("Enter time interval(s): ");
            time_interval = in.nextInt();
            //Prompting user for input of total time
            System.out.println("Enter total time (s): ");
            total_time = in.nextInt();

            int curr_time;//Stores current time
            int steps = total_time/time_interval;//Stores number of steps for completion of time
            float[] distance = new float[steps+1];//Array to store distance at a moment of time of size steps+1
            System.out.println();
            System.out.println("Time\tDistance");
            for(int t=0;t<steps+1;t++){
                curr_time = t*time_interval;//Current time is current step * time interval
                distance[t] = init_speed*curr_time + (float)(accel*curr_time*curr_time)/2;//Implementation of the formula
                System.out.println((t)*time_interval+"\t"+distance[t]);//Printing the output
            }
            //Repeat check, if 0 is entered program is exited else if 1 is entered program is repeated
            System.out.println("Do you want to repeat? (1-Yes,0-No)");
            flag = in.nextInt();
            //Check for invalid input 
            while(flag!=0&&flag!=1){
                System.out.println("Enter either 0 or 1!");
                System.out.println("Do you want to repeat? (1-Yes,0-No)");
                flag = in.nextInt();
            }
        }
        System.out.println("\nProgram Terminated");
    }
}