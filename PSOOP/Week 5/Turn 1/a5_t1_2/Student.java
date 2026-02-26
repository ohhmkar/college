
/**
 * This class provides a template for student, having required methods and variables
 *
 * @author Omkar Anil Gajare
 * @version 25/2/26
 */
public class Student
{
    //Instance Variables
    int rollNumber;
    String name;
    int[] marks = new int[3];
    
    //Constructor
    Student(int rollNumber, String name, int[] marks){
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }
    //Method to calculate total marks of student
    //Returns total marks
    int calculateTotal(){
        int total = 0;
        for(int i=0;i<marks.length;i++){
            total += marks[i];
        }
        return total;
    }
    //Method to calculate average marks of student
    //Param: total marks
    //Returns: average marks
    float calculateAverage(int total){
        float avg;
        avg = (float)(total/3.0);
        return avg;
    }
    //Method to print result of student
    //Uses calculateTotal, calculateAverage
    void displayResult(){
        System.out.println("Roll No."+ rollNumber);
        System.out.println("Name: "+name);
        System.out.println("Total Marks: "+calculateTotal());
        System.out.println("Average Marks: "+calculateAverage(calculateTotal()));
        if(calculateAverage(calculateTotal())>40){
            System.out.println("Result: PASS");
        }
        else{
            System.out.println("Result: FAIL");
        }
    }
}