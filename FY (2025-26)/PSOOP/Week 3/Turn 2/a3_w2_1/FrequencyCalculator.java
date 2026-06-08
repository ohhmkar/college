import java.io.*;
import java.util.*;
/**
 * This program calculates the frequency at different values of C when inductance and resistance is given
 *
 * @author Omkar Gajare
 * @version 13/2/26
 */
public class FrequencyCalculator
{
    public static void main(String args[]) throws IOException{
    double freq,induc,res;//Initializing all quantities using double for float point precision
    DataInputStream in = new DataInputStream(System.in);
    //prompting user for inductance value
    System.out.print("Enter inductance:");
    induc = Float.valueOf(in.readLine());
    //prompting user for resistance value
    System.out.print("Enter resistance:");
    res = Double.valueOf(in.readLine());
    //Printing results for freqeuncy
    System.out.println("C\t\tFrequency");
    for(double cap=0.01;cap<=0.1;cap+=0.01){
        freq = Math.sqrt(1/(induc*cap) - Math.pow(res,2)/(4*Math.pow(cap,2)));//implementation of formula using Math package in python. Math.sqrt() returns a double.
        System.out.println(cap+"\t\t"+freq);
    }
}
}