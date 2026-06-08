import java.io.*;
import java.util.*;
/**
 * Write a description of class ManagementCourse here.
 *
 * @author Omkar Anil Gajare
 * @version 27/3/26
 */
public class LearningPlatform
{
    public static void main(String args[]) throws IOException{
        // Reads text input for a simple console-driven report.
        DataInputStream in = new DataInputStream(System.in);
        System.out.println("Enter number of courses: ");
        int noOfCourses = Integer.parseInt(in.readLine());

        // Polymorphism lets one Course[] hold both course types.
        Course[] courseNo = new Course[noOfCourses];
        int courseType;
        int[] scores = new int[noOfCourses];
        for(int i = 0;i<noOfCourses;i++){
            String courseCode = "",instructor = "";
            int durationInWeeks = 0, score = 0;

            System.out.println("Enter course type: (1-Programming, 2-Management)");
            courseType = Integer.parseInt(in.readLine());

            System.out.print("Course Code: ");
            courseCode = in.readLine();

            System.out.print("Instructor Name: ");
            instructor = in.readLine();

            System.out.print("Duration (Weeks): ");
            durationInWeeks = Integer.parseInt(in.readLine());

            System.out.print("Student Score: ");
            scores[i] = Integer.parseInt(in.readLine());

                        // The chosen input decides which subclass object is created.
            if(courseType == 1){
              courseNo[i] = new ProgrammingCourse(courseCode, instructor, durationInWeeks,scores[i]);
            }else{
              courseNo[i] = new ManagementCourse(courseCode, instructor, durationInWeeks,scores[i]);
            }
            System.out.println();
        }
        System.out.println("==== COURSE REPORT ====");
        for(int i=0;i<noOfCourses;i++){
            // The base reference is used first, then behavior changes by actual object type.
            courseNo[i].displayCourseDetails();
            // Runtime type checks decide which subclass-specific methods to call.
            if(courseNo[i] instanceof ProgrammingCourse){
                ((ProgrammingCourse)courseNo[i]).evaluateStudent(scores[i]);
                ((ProgrammingCourse)courseNo[i]).conductLiveSession();
                System.out.println("Outcome: " + ((ProgrammingCourse)courseNo[i]).courseOutcome());
                System.out.println("Certificate Issued: "+ (((ProgrammingCourse)courseNo[i]).issueCertificate(scores[i])));
            }
            else{
                ((ManagementCourse)courseNo[i]).evaluateStudent(scores[i]);
                ((ManagementCourse)courseNo[i]).conductLiveSession();
                System.out.println("Outcome: " + ((ManagementCourse)courseNo[i]).courseOutcome());
                System.out.println("Certificate Issued: "+ (((ManagementCourse)courseNo[i]).issueCertificate(scores[i])));
            }
            // Separator improves readability for each course report block.
            System.out.println("----------------------------");
        }
    }
}

