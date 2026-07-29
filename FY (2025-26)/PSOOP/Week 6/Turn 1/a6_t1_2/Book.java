/**
 * @author Omkar Anil Gajare
 * @version 6/3/26
 */
class Book {
  // book id of the book
  protected String bookId;
  // title of the book
  protected String title;
  // number of days it has been issued for
  protected int issueDays;
  // checks if book is for reference
  boolean isReferenceBook = false;
  // maximum issue days limit
  static int maxIssueLimit = 14;

  /**
   * Updates the maximum issue limit for all books.
   *
   * @param newLimit the new limit to set
   */
  static void updateIssueLimit(int newLimit) {
    maxIssueLimit = newLimit;
  }

  /**
   * Issue the book for a given number of days.
   *
   * @param days number of days to issue the book
   */
  void issueBook(int days) {
    issueDays = days;
  }

  /**
   * Issue the book for a given number of days and set reference flag.
   *
   * @param days            number of days to issue the book
   * @param isReferenceBook true if this is a reference book
   */
  void issueBook(int days, boolean isReferenceBook) {
    this.isReferenceBook = isReferenceBook;
    issueDays = days;
  }

  /**
   * Print the book details to standard output.
   */
  void displayBookDetails() {
    System.out.println(
        "--- Book Details ---" + "\n" +
            "Book ID        : " + bookId + "\n" +
            "Book Title     : " + title + "\n" +
            "Issue Days     : " + issueDays + "\n" +
            "Reference Book : " + isReferenceBook + "\n" +
            "Max Limit      : " + maxIssueLimit);
  }
}
