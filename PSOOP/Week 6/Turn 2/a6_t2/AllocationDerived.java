public class AllocationDerived extends StreamBase {
    private Student[] students;
    private int numStudents;

    /* Constructor */
    public AllocationDerived(Student[] students, int numStudents) {
        super("", 0);
        // store reference to original student list and its size
        this.students = students;
        this.numStudents = numStudents;
    }

    /**
     * Searches the inherited allStreams pool for a stream by name.
     * 
     * @param name Name of the stream to find
     * @return Reference to the matching StreamBase, or null if not found
     */
    private StreamBase findStream(String name) {
        for (int i = 0; i < numStreams; i++) {
            // compare stream names ignoring case to allow flexible input
            if (allStreams[i].streamName.equalsIgnoreCase(name)) {
                return allStreams[i];
            }
        }
        return null;
    }

    /**
     * Returns a copy of the students array sorted by score descending using bubble
     * sort.
     * The original array is kept intact to preserve input order for final output.
     * 
     * @return New array of students sorted highest score first
     */
    private Student[] sortByScoreDesc() {
        Student[] sorted = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            sorted[i] = students[i];
        }
        // simple bubble sort: move higher scores to front
        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (sorted[j].score < sorted[j + 1].score) {
                    Student temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    /**
     * Allocates a stream to a single student by trying each preference in order.
     * Assigns the first preference that has a seat available.
     * 
     * @param student The student for whom allocation is attempted
     */
    public void allocate(Student student) {
        for (int p = 0; p < student.numPreferences; p++) {
            // try each preference in order and assign first available
            StreamBase preferred = findStream(student.preferences[p]);
            if (preferred != null && preferred.seatsLeft > 0) {
                student.allocatedStream = preferred.streamName;
                preferred.seatsLeft--; // decrement available seats
                return;
            }
        }
    }

    /**
     * Batch-allocates streams to all students in score-descending order,
     * then prints results in the original input order.
     */
    public void allocate() {
        Student[] sorted = sortByScoreDesc();
        // allocate seats in descending score order
        for (int i = 0; i < numStudents; i++) {
            allocate(sorted[i]);
        }
        // print results in original input order for clarity
        System.out.println("Seat Allocation");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(students[i].rollNo + " "
                    + (students[i].allocatedStream == null
                            ? "null"
                            : students[i].allocatedStream));
        }
    }
}
