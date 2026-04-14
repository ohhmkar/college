import java.io.*;
/**
 * @author Omkar Anil Gajare
 * @version 8/4/26
 *
 *
 */
public class StudentCandidate implements CertificationRules, AttendancePolicy{
    DataInputStream in = new DataInputStream(System.in);

    protected String studentId;
    protected int marks, attendance;
    protected char grade;

    /*Read User Input Methods*/
    void readStudentId(){
        while(true){
            try{
                System.out.print("Enter Student ID: ");
                String input = in.readLine();
                if(input == null || input.trim().isEmpty()){
                    System.out.println("Invalid input. Student ID cannot be empty. Please re-enter.");
                    continue;
                }
                studentId = input.trim();
                break;
            }
            catch(Exception e){
                System.out.println("Error reading Student ID. Please re-enter.");
            }
        }
    }

    @Override
    public void readMarks(){
        while(true){
            try{
                System.out.print("Enter Marks: ");
                marks = Integer.parseInt(in.readLine());
                if(marks < 0 || marks > 100){
                    System.out.println("Invalid marks. Enter a value between 0 and 100.");
                    continue;
                }
                break;
            }
            catch(Exception e){
                System.out.println("Invalid marks input. Please enter a whole number between 0 and 100.");
            }
        }
    }

    @Override
    public void readAttendance(){
        while(true){
            try{
                System.out.print("Enter Attendance Percentage (0-100): ");
                attendance = Integer.parseInt(in.readLine());
                if(attendance < 0 || attendance > 100){
                    System.out.println("Invalid attendance. Enter a value between 0 and 100.");
                    continue;
                }
                break;
            }
            catch(Exception e){
                System.out.println("Invalid attendance input. Please enter a whole number between 0 and 100.");
            }
        }
    }

    public void readStudentDetails(){
        readStudentId();
        readMarks();
        readAttendance();
    }

    /*Eligibility Checks*/
    @Override
    public boolean isAttendanceEligible(){
        return (attendance >= 75);
    }

    @Override
    public boolean isMarksEligible(){
        return (marks>50);
    }

    public boolean checkEligibility(){
        return (isAttendanceEligible() && isMarksEligible());
    }

    /*Grade Calculation Logic*/
    @Override
    public void calculateGrade(){
        if(checkEligibility()){
            grade = ((marks>=85)? 'A' : 
                (marks>=75)? 'B' : 'C');
        }
        else{
            grade = 'F';
        }
    }

    public void displayResult(){
        System.out.println("\n\n====== STUDENT EVALUATION REPORT =======");
        System.out.println("Student Id:\t"+                 studentId);
        System.out.println("Grade:\t"+                          grade);
        System.out.println("Attendance Ok:\t"+ isAttendanceEligible());
        System.out.println("Marks Eligible:\t"+     isMarksEligible());
        System.out.println("Certification:\t" +((checkEligibility())? "ELIGIBLE" : "NOT ELIGIBLE"));
    }
}
