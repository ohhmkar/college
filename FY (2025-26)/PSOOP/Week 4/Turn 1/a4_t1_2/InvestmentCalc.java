/**
 * This program prints the values in an investment plan 
 *
 * @author Omkar Anil Gajare
 * @version 18/2/26
 */
class InvestmentCalculator
{
    public static void calc(){
        // Iterate principal amounts from 1,000 to 10,000 in 1,000 increments
        for(Integer principal = 1000;principal<11000;principal+=1000){
            // Iterate interest rates from 10% to 20% in 1% increments
            for(Double rate=0.10;rate<=0.21;rate+=0.01){
                System.out.printf("Principal=%d\tRate=%.2f\n",principal,rate);
                System.out.println("Year\tValue");
                // Compute compound value for years 1 through 10
                for(Integer n=1;n<11;n++){
                    System.out.printf("%d\t%.2f\n",n,principal*Math.pow(1+rate,n));
                }
            }
            System.out.println();
        }
    }
}
public class InvestmentCalc{
    public static void main(String args[]){
        // Invoke the calculator to print the investment table
        InvestmentCalculator.calc();
    }
}
