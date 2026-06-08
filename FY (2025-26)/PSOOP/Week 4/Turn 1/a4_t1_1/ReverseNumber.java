import java.io.*;
/**
 * This program takes an input of a number and returns it reversed
 *
 * @author Omkar Anil Gajare
 * @version 18/2/26
 */
public class ReverseNumber
{
    public static void main(String args[]) throws IOException{
        int num;
        DataInputStream in = new DataInputStream(System.in);
        System.out.println("Enter a number: ");
        num = Integer.parseInt(in.readLine());
        int num_len = String.valueOf(num).length();
        // Variable to accumulate the reversed number
        int rev_num = 0;
        // Reverse the number by repeatedly extracting the last digit
        while(num>0){
            rev_num = rev_num*10 + num%10;
            num/=10;
        }
        int rev_num_len = String.valueOf(rev_num).length();
        System.out.printf("Reversed Num: ");
        // If the original number had trailing zeros, reintroduce them as leading zeros after reversal
        while(rev_num_len<num_len){
            System.out.print("0");
            rev_num_len++;
        }
        System.out.print(rev_num);
    }
}