
/**
 * Write a description of class User here.
 *
 * @author Omkar Anil Gajare
 */
public class User {
    protected int userId;
    protected String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    protected void displayUser() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
    }
}
