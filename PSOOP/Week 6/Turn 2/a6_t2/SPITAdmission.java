import java.io.*;

public class SPITAdmission {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);

        // read number of streams to construct pool
        // Read number of streams and create stream objects
        System.out.print("Enter no. Of streams : ");
        int numStreams = Integer.parseInt(in.readLine().trim());

        StreamBase[] streams = new StreamBase[numStreams];
        System.out.println("Enter streamwise seats : ");
        for (int i = 0; i < numStreams; i++) {
            // Each line: <StreamName> <Seats>
            String[] parts = in.readLine().trim().split("\\s+");
            // create StreamBase for each input line
            streams[i] = new StreamBase(parts[0], Integer.parseInt(parts[1]));
        }
        // Make the stream pool available for allocation logic
        StreamBase.setStreams(streams, numStreams);

        // Read candidate count and then each candidate's data
        System.out.print("\nEnter total candidates: ");
        int numStudents = Integer.parseInt(in.readLine().trim());

        StreamBase.Student[] students = new StreamBase.Student[numStudents];
        System.out.println("Enter Candidate Preferences " + "(RollNo Score NumberOfPreferences Preferences): ");

        for (int i = 0; i < numStudents; i++) {
            // Input a students details in the format: <RollNo> <Score> <NumPreferences>
            // <Preference1> <Preference2> ...
            String[] parts = in.readLine().trim().split("\\s+");
            int rollNo = Integer.parseInt(parts[0]);
            double score = Double.parseDouble(parts[1]);
            int numPrefs = Integer.parseInt(parts[2]);

            String[] preferences = new String[numPrefs];
            for (int p = 0; p < numPrefs; p++) {
                preferences[p] = parts[3 + p];
            }

            // store the candidate record (appliedStream set to first pref)
            students[i] = new StreamBase.Student(rollNo, score, preferences[0], numPrefs, preferences, i);
        }

        // Create allocator and perform seat allocation
        AllocationDerived alr = new AllocationDerived(students, numStudents);

        System.out.println();
        alr.allocate(); // allocate seats and print results
    }
}
