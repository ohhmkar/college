import java.io.*;
import java.util.*;
/**
 * This program takes number of inputs from user and converts the number either from Roman representation to Decimal or vice versa
 *
 * @author Omkar Anil Gajare
 * @version 27/2/26
 */
public class RomanDecimalConverterTest
{
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);
        String input = "";//Local Variable to store input
        int t;//Local variable to store number of test cases
        t = Integer.parseInt(in.readLine());//Reading number of cases
        /* Iterating until testcases are over */
        for(int i=0;i<t;i++){
            input = in.readLine();//Reading Input
            /*If input is number converting to roman and vice versa*/
            if(Character.isDigit(input.charAt(0))) //Checking if input is number using charAt(0) being a digit
            {
                int number = Integer.parseInt(input);
                RomanDecimalConverter num = new RomanDecimalConverter(number);//Instanstiating new object so old data is wiped
                System.out.println(num.convertValue(number));//Calling function convertValue with integer value
            }
            else //Input is roman representation of a number
            {
                RomanDecimalConverter num = new RomanDecimalConverter(input);//Instanstiaiting new object so old data is wiped
                System.out.println(num.convertValue(input));//Calling function convertValue with String roman
            }
        }
    }
}