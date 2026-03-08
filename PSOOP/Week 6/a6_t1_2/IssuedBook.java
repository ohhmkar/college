/**
 * An issued book extends `Book` and adds behaviors related to fines.
 *
 * @author Omkar Anil Gajare
 * @version 6/3/26
 */
class IssuedBook extends Book {
  /** Calculated fine amount for late returns */
  private double fine;

  /**
   * Constructor
   *
   * @param bookId book identifier
   * @param title  book title
   */
  IssuedBook(String bookId, String title) {
    this.bookId = bookId;
    this.title = title;
  }

  /**
   * Calculate and print the fine based on how many days the book was issued.
   * Reference books are fined at Rs. 2/day over the limit; other books Rs. 5/day.
   */
  void calculateFine() {
    // Check if the book is overdue based on maxIssueLimit
    if (issueDays > maxIssueLimit) {
      if (isReferenceBook) {
        this.fine = 5.0 * (issueDays - maxIssueLimit);
      } else {
        this.fine = 2.0 * (issueDays - maxIssueLimit);
      }
    } else {
      this.fine = 0.0;
    }
    System.out.println("Fine Amount    : Rs. " + this.fine);
  }
}
