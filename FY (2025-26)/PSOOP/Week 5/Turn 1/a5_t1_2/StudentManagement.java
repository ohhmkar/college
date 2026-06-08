import java.io.*;
import java.util.*;
/**
 * This program handles the data of 2 students and calculating their result
 *
 * @author Omkar Anil Gajare
 * @version 25/2/26
 */
public class StudentManagement
{
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);
        //local variables used to store value that will be sent as parameters for construction of object
        int rollNo;
        int[] marks = new int[3];
        String name;
        //Data Entry for Student 1
        System.out.println("Enter details for student 1");
        System.out.print("Roll No: ");
        rollNo = Integer.parseInt(in.readLine());
        System.out.print("Name: ");
        name = in.readLine();
        System.out.print("Marks in 3 Subjects: ");
        for(int i = 0; i < 3; i++){
            marks[i] = Integer.parseInt(in.readLine());
        }
        //Instanstiating student 1 with all details
        Student s1 = new Student(rollNo,name,marks);
        
        //Data Entry for Student 2
        System.out.println("Enter details for student 2");
        System.out.print("Roll No: ");
        rollNo = Integer.parseInt(in.readLine());
        System.out.print("Name: ");
        name = in.readLine();
        System.out.print("Marks in 3 Subjects: ");
        for(int i = 0; i < 3; i++){
            marks[i] = Integer.parseInt(in.readLine());
        }
        //Instanstiating student 2 with all details
        Student s2 = new Student(rollNo,name,marks);
        
        //Calling display to print results of both students
        System.out.println("--- Student Results ---");
        System.out.println();
        s1.displayResult();
        System.out.println();
        s2.displayResult(); 
    }
}