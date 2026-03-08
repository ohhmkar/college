import java.io.*;

/**
 * Simple Lbrary Management System
 *
 * @author Omkar Anil Gajare
 * @version 6/3/26
 **/
class Test {
  public static void main(String[] args) throws IOException {
    DataInputStream in = new DataInputStream(System.in);
    String bookId, title;
    boolean isReference;
    int issueDays, newLimit;

    // Prompting user for book details
    System.out.print("Enter Book ID: ");
    bookId = in.readLine();

    System.out.print("Enter Book Title: ");
    title = in.readLine();

    // Create a new IssuedBook instance based on user input
    IssuedBook book = new IssuedBook(bookId, title);

    // Retrieve issue details
    System.out.print("Is Reference Book? (true/false): ");
    isReference = Boolean.parseBoolean(in.readLine());

    System.out.print("Enter Issue Days: ");
    issueDays = Integer.parseInt(in.readLine());

    // Ask if the max issue limit should be updated globally
    System.out.print("Change Max Issue Limit? (yes/no): ");
    String change = in.readLine();
    if (change.equalsIgnoreCase("yes")) {
      System.out.print("Enter New Limit: ");
      newLimit = Integer.parseInt(in.readLine());
      Book.updateIssueLimit(newLimit); // Update via static method
    }

    // Issue the book with the provided details using overloaded methods
    if (isReference) {
      book.issueBook(issueDays, true);
    } else {
      book.issueBook(issueDays);
    }

    // Display the final details and calculated fine
    System.out.println();
    book.displayBookDetails();
    book.calculateFine();
  }
}
