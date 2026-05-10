
/**
 * Write a description of class Order here.
 *
 * @author Omkar Anil Gajare
 */
public class Order {
    int orderId;
    FoodItem item = new FoodItem();
    int quantity;
    static int totalOrders = 0;

    Order(FoodItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        totalOrders++;
        orderId = totalOrders;
    }

    protected double calculateBill() {
        return quantity * item.price;
    }

    protected void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Item Name: " + item.itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Item Price: Rs." + item.price);
        System.out.println("Bill: Rs." + calculateBill());
    }
}
