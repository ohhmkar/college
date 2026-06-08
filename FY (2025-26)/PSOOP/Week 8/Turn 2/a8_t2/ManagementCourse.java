/**
 * Write a description of class ManagementCourse here.
 *
 * @author Omkar Anil Gajare
 * @version 27/3/26
 */
class ManagementCourse extends Course implements LiveSession, Certification {
    // Stores the student's management assessment score.
    public int score;
    // Indicates whether the student cleared the course threshold.
    protected boolean pass;

    ManagementCourse(String courseCode, String instructor, int durationInWeeks, int score) {
        super(courseCode, instructor, durationInWeeks, "ManagemenCourse");
        // Management courses require 50 to pass
        pass = (score >= 50) ? true : false;
    }

    @Override
    void evaluateStudent(int score) {
        System.out.println("Management Score: " + score);
    }

    @Override
    String courseOutcome() {
        // The reported outcome depends on the computed pass status.
        if (pass) {
            return "Leadership and planning skills gained";
        } else {
            return "Leadership and planning skills not gained!";
        }
    }

    @Override
    public void conductLiveSession() {
        System.out.println("Live Case-Study discussion conducted");
    }

    @Override
    public boolean issueCertificate(int score) {
        // Certificates are granted for scores at or above 50.
        return (score >= 50) ? true : false;
    }
}
