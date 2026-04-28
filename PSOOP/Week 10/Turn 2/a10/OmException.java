/**
 * Custom exception handler for my exceptions in this program.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OmException extends Exception {
    String msg;
    OmException(String msg) {
        // Call the parent Exception class constructor
        super(msg);
    }
}
