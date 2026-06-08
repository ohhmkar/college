import java.io.*;
/**
 * This program prints the average of 2 numbers, fixed from initial state
 *
 * @author Omkar Anil Gajare
 * @version 6/2/26
 */
//Overall changes: formatting all code in line and indenting properly, and spacing out code by adding relevant comments.
public class Test//class name is always CaptialCase while, keyword "class" and "public" should be small 
{
    public static void main(String args[]) throws IOException{//added a main function with IOException to handle error with DataInputStream
        DataInputStream in = new DataInputStream(System.in);
        int total = 0;//initialised with small letters and variable names should be small(style changes)
        //Entry of first number
        System.out.println("Enter a number:");
        int number1 = Integer.parseInt(in.readLine());//initialised number1 with small letter only name and took input using Integer wrapper class to typecast the input from String to int
        total += number1;//used shorthand operator to add number1
        //Entry of second number
        System.out.println("Enter another number:");
        int number2 = Integer.parseInt(in.readLine());//initialised number1 with small letter only name and took input using Integer wrapper class to typecast the input from String to int
        total += number2;//added number 2 which stores second number not input 1
        //Calculating average and storing in average, divided by 2.0 to get float result to handle cases of .5 averages
        double average = total/2.0;
        System.out.println("Average = " + average);//Fixed syntax error in print statement and also in f string print statement
    }
}