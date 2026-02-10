/**
 * This program prints the sum of two preset numbers(Fixed from initial state).
 *
 * @author Omkar Gajare
 * @version 4/2/26
 */
//General Fixes: Syntaxical and indentation
public class TestError{//Fixed class name being CapitalCase and changed public to small
    public static void main(String args[]){//Changed "string" to String so it uses the String class
        System.out.println("This program adds two numbers");//Fixed comma to semi colon
        int x = 5;//Initialization requires int before variable name.
        double y = 3.5;//Initialization of double done with int was fixed.
        System.out.print("The sum of "+x+" and "+y+" is ");//Fixed f-string text
        System.out.print(x+y);
    }
}