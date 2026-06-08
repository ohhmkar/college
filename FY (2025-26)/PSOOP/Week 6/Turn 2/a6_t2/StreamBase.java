/**
 * Base class that holds all stream data and contains
 * the inner Student class for representing candidate data.
 */
public class StreamBase {

    protected String streamName;
    protected int totalSeats;
    protected int seatsLeft;
    protected static int streamCount = 0;

    protected static StreamBase[] allStreams;
    protected static int numStreams;

    public StreamBase(String name, int seats) {
        // initialize basic stream metadata and available seats
        this.streamName = name;
        this.totalSeats = seats;
        this.seatsLeft = seats;
        streamCount++; // track how many stream objects were created
    }

    /**
     * Makes a seat pool that can be accessed and allotted from
     * 
     * @param streams Array of all streams
     * @param count   Number of streams in the array
     */
    public static void setStreams(StreamBase[] streams, int count) {
        allStreams = streams;
        numStreams = count;
    }

    /**
     * Inner class encapsulating all candidate information.
     */
    public static class Student {

        int rollNo;
        double score;
        String appliedStream;
        int numPreferences;
        String[] preferences;
        String allocatedStream;
        int originalIndex;

        /* Student constructor */
        public Student(int rollNo, double score, String appliedStream, int numPreferences, String[] preferences,
                int originalIndex) {
            // preserve input values for later allocation and output
            this.rollNo = rollNo;
            this.score = score;
            this.appliedStream = appliedStream;
            this.numPreferences = numPreferences;
            this.preferences = preferences;
            this.allocatedStream = null; // set when allocation happens
            this.originalIndex = originalIndex; // helps print original order
        }
    }
}
