/**
 * Write a description of class ManagementCourse here.
 *
 * @author Omkar Anil Gajare
 * @version 27/3/26
 */
class ProgrammingCourse extends Course implements LiveSession, Certification{
    public int score;
    protected boolean pass = false;

    ProgrammingCourse(String courseCode, String instructor, int durationInWeeks, int score){
        super(courseCode, instructor, durationInWeeks, "ProgrammingCourse");
        pass = (score>=60)? true : false;
    }
    
    @Override
    void evaluateStudent(int score){
        System.out.println("Programming Score: "+score);
    }
    
    
    @Override
    String courseOutcome(){
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
        return (score>=60)? true: false;
    }
}
