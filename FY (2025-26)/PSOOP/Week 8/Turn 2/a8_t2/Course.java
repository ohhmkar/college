/**
 * Write a description of class ManagementCourse here.
 *
 * @author Omkar Anil Gajare
 * @version 27/3/26
 */
abstract class Course{
  // Common properties shared by all course types.
    protected String courseCode;
    protected String instructor;
    protected int durationInWeeks;
    protected String courseType;
    

    Course(String courseCode, String instructor, int durationInWeeks, String courseType){
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.durationInWeeks = durationInWeeks;
        this.courseType = courseType;
    }

    // Subclasses define their own evaluation, outcome, and session behavior.
    abstract void evaluateStudent(int score);
    abstract String courseOutcome();

    final void displayCourseDetails(){
      // Final keeps display format consistent across subclasses.
      System.out.println("Course Code: "+ courseCode);
      System.out.println("Instructor: "+ instructor);
      System.out.println("Duration (Weeks): "+ durationInWeeks);
    }
}
