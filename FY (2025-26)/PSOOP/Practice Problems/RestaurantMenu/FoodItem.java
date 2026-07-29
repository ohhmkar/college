
/**
 * Write a description of class FoodItem here.
 *
 * @author Omkar Anil Gajare
 */
public class FoodItem {
    int itemId;
    String itemName;
    double price;

    FoodItem() {
    }

    FoodItem(int itemId, String itemName, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }

    protected void displayItem() {
        System.out.println("Item ID: " + itemId + " Item Name: " + itemName + " Price: Rs." + price);
    }
}
