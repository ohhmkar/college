/**
 * Write a description of class ManagementCourse here.
 *
 * @author Omkar Anil Gajare
 * @version 27/3/26
 */
class ManagementCourse extends Course implements LiveSession, Certification{
    public int score;
    protected boolean pass;

    ManagementCourse(String courseCode, String instructor, int durationInWeeks, int score){
        super(courseCode, instructor, durationInWeeks, "ManagemenCourse");
        pass = (score>=50)? true : false;
    }

    @Override
    void evaluateStudent(int score){
        System.out.println("Management Score: "+score);
    }

    @Override
    String courseOutcome(){
        if(pass){
            return "Leadership and planning skills gained";
        }
        else{
            return "Leadership and planning skills not gained!";
        }
    }
    
    @Override
    public void conductLiveSession(){
        System.out.println("Live Case-Study discussion conducted");
    }

    @Override
    public boolean issueCertificate(int score){
        return (score>=50)? true: false;
    }
}
