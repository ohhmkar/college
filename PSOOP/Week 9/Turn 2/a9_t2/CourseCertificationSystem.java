/**
 * Main Function that runs the program, makes an object Student and calls methods.
 *
 * @author Omkar Anil Gajare
 * @version 8/4/26
 */
public class CourseCertificationSystem
{
    public static void main(String args[]){
        StudentCandidate student = new StudentCandidate();
        student.readStudentDetails();
        student.calculateGrade();
        student.displayResult();
    }
}