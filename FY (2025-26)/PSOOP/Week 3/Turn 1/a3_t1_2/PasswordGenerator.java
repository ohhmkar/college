import java.util.*;
/**
 * This generates a password conacting the first letters of the users name and their age multiplied with a random number
 *
 * @author Omkar Gajare
 * @version 11/2/26
*/
public class PasswordGenerator
{
    public static void main(String args[]){
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        String [] name = new String[3];//Array to store first name, middle name and last name
        
        System.out.println("Enter first name: ");
        name[0] = in.nextLine();//Stores first name
        System.out.println("Enter middle name: ");
        name[1] = in.nextLine();//Stores middle name
        System.out.println("Enter last name: ");
        name[2] = in.nextLine();//Stores last name
        System.out.println("Enter age:");
        int age = in.nextInt() * r.nextInt(1,10);//Stores age by taking input and multiplying random number to it using Random class
        String password = "";
        password = password + (name[0].substring(0,1))//Appends first character of first name 
                            + (name[1].substring(0,1))//Appends first character of middle name
                            + (name[2].substring(0,1))//Appends first character of last name
                            + (Integer.toString(age));//Appends age*random_number to password
        System.out.println("Password: " + password);
    }
}