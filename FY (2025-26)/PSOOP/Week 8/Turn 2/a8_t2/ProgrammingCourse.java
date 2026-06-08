/**
 * Write a description of class ManagementCourse here.
 *
 * @author Omkar Anil Gajare
 * @version 27/3/26
 */
class ProgrammingCourse extends Course implements LiveSession, Certification{
    // Stores the student's programming assessment score.
    public int score;
    // Tracks whether the student met the passing requirement.
    protected boolean pass = false;

    ProgrammingCourse(String courseCode, String instructor, int durationInWeeks, int score){
        super(courseCode, instructor, durationInWeeks, "ProgrammingCourse");
        // Programming courses require 60 to pass
        pass = (score>=60)? true : false;
    }
    
    @Override
    void evaluateStudent(int score){
        System.out.println("Programming Score: "+score);
    }
    
    
    @Override
    String courseOutcome(){
        // Outcome is based on whether the student passed the course.
        if(pass){
            return "Practical coding skills gained";
        }
        else{
            return "Practical coding skills not gained";
        }
    }
    
    @Override
    public void conductLiveSession(){
        System.out.println("Live Coding Session Conducted");
    }
    
    @Override
    public boolean issueCertificate(int score){
        // Certificate is issued only when score is 60 or above.
        return (score>=60)? true: false;
    }
}
