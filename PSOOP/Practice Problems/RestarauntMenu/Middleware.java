
/**
 * Write a description of class Middleware here.
 *
 * @author Omkar Anil Gajare
 */
public class Middleware {
    public int noOfOrders = 0;
    int noOfItems = 0;
    FoodItem[] menuItem = new FoodItem[100];
    Order[] orders = new Order[100];

    protected Order placeOrder(int itemId, int quantity) throws InvalidItemException, InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Error: Quantity must be greater than zero");
        }
        for (int i = 0; i < noOfItems; i++) {
            if (menuItem[i].itemId == itemId) {
                Order order = new Order(menuItem[i], quantity);
                orders[noOfOrders] = order;
                noOfOrders++;
                return order;
            }
        }
        throw new InvalidItemException("Error: Item ID not found");
    }

    protected Order placeOrder(String itemName, int quantity) throws InvalidItemException, InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Error: Quantity must be greater than zero");
        }
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new NullPointerException("Input cannot be empty");
        }
        for (int i = 0; i < noOfItems; i++) {
            if (menuItem[i].itemName.equalsIgnoreCase(itemName.trim())) {
                Order order = new Order(menuItem[i], quantity);
                orders[noOfOrders] = order;
                noOfOrders++;
                return order;
            }
        }
        throw new InvalidItemException("Error: Item name not found");
    }

    public void addItem(FoodItem item) {
        menuItem[noOfItems] = item;
        noOfItems++;
    }

    public void displayMenu() {
        for (int i = 0; i < noOfItems; i++) {
            menuItem[i].displayItem();
        }
    }
}
