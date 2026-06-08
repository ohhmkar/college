import java.io.*;
/**
 * This program splits the input into indiviual characters spaced out
 *
 * @author Omkar Gajare
 * @version 6/2/26
 */
public class InputBreaker
{
    public static void main(String args[]) throws IOException{
        //Initialising Stringbuffer class 
        StringBuffer str = new StringBuffer(args[0]);//input taken from CLI as args
        //Initialising loop variables and length of string
        int i = 0;
        int len = str.length();
        while(i<len){
            //loop iterates till last value of string as len stores length of string and last index is length-1
            System.out.print(str.charAt(i)+" ");
            i+=1;
        }
    }
}