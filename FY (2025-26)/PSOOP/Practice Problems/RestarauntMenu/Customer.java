
/// @author Omkar Anil Gajare
public class Customer extends User {
    String address;

    Customer(int userId, String name, String address) {
        super(userId, name);
        this.address = address;
    }

    @Override
    protected void displayUser() {
        super.displayUser();
        System.out.println("Address: " + address);
    }
}
