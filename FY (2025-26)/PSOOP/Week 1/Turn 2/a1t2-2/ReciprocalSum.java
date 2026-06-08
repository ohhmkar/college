/**
 * This program prints the sum of the reciprocals
 *
 * @author Omkar Anil Gajare
 * @version 30-1-26
 */
public class ReciprocalSum
{
    public static void main(String args[]){
        System.out.println("2025300063_Omkar_Anil_Gajare");
        System.out.println();
        /*
         * 
         *  1 + 1/2 + 1/3 + 1/4 + 1/5 + 1/6 + 1/7 + 1/8 + 1/9 + 1/10 \approx= 2.929
         *  When computed with integers, it performs integer division and stores the value in
         *  an int hence the output is 1 as all fractions that are not 1
         *  are rounded down to a 0 the value in a int hence the output is 1 as all fractions that are not 1 are rounded down to a 0
         * 
         *  Reciprocal Sum with integers:
         *  1 + 1/2 + 1/3 + 1/4 + 1/5 + 1/6 + 1/7 + 1/8 + 1/9 + 1/10 = 1
         */
        System.out.println("Reciprocal Sum with integers:");
        System.out.println("1 + 1/2 + 1/3 + 1/4 + 1/5 + 1/6 + 1/7 + 1/8 + 1/9 + 1/10 = "+(1 + 1/2 + 1/3 + 1/4 + 1/5 + 1/6 + 1/7 + 1/8 + 1/9 + 1/10));
        System.out.println();
        /*
         * When computed using division with float point value, it divides the values and stores them in a float not a int, due to divison happening in a higher order datatype
         * This saves the data in float, this causes it to store the actual value upto 16 decimal places and stores the actual value
         * Reciprocal Sum with floats:
         * 1.0 + 1/2.0 + 1/3.0 + 1/4.0 + 1/5.0 + 1/6.0 + 1/7.0 + 1/8.0 + 1/9.0 + 1/10.0 = 2.9289682539682538
        */
        System.out.println("Reciprocal Sum with floats");
        System.out.println("1.0 + 1.0/2.0 + 1/3.0 + 1/4.0 + 1/5.0 + 1/6.0 + 1/7.0 + 1/8.0 + 1/9.0 + 1/10.0 = "+(1.0 + 1/2.0 + 1/3.0 + 1/4.0 + 1/5.0 + 1/6.0 + 1/7.0 + 1/8.0 + 1/9.0 + 1/10.0));
    }
}