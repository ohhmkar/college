import java.io.*;
import java.util.*;

/**
 * Write a description of class Main here.
 *
 * @author Omkar Anil Gajare
 */
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        Middleware menu = new Middleware();
        FoodItem Pizza = new FoodItem(3, "Pizza", 300);
        menu.addItem(Pizza);
        FoodItem Pasta = new FoodItem(2, "Pasta", 170);
        menu.addItem(Pasta);
        FoodItem Fries = new FoodItem(1, "Fries", 90);
        menu.addItem(Fries);

        String name = "";
        String address = "";
        while (true) {
            assert name != null;
            if (!name.trim().isEmpty()) break;
            System.out.println("Enter Customer Name: ");
            name = in.nextLine();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Input cannot be empty");
            }
        }
        while (true) {
            assert address != null;
            if (!address.trim().isEmpty()) break;
            System.out.println("Enter Address: ");
            address = in.nextLine();
            if (address == null || address.trim().isEmpty()) {
                System.out.println("Input cannot be empty");
            }
        }
        Random r = new Random();
        Customer customer = new Customer(r.nextInt(1000), name.trim(), address.trim());
        while (true) {
            try {
                System.out.println("1. Display all food items");
                System.out.println("2. Place order using Item ID");
                System.out.println("3. Place order using Item Name");
                System.out.println("4. Display customer details");
                System.out.println("5. Display total number of orders");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int choice = in.nextInt();
                in.nextLine();
                int quantity = 0;
                switch (choice) {
                    case 1: {
                        menu.displayMenu();
                        break;
                    }
                    case 2:
                        try {
                            System.out.println("Enter Item Id:");
                            int itemId = in.nextInt();
                            in.nextLine();
                            System.out.println("Enter quantity:");
                            quantity = in.nextInt();
                            in.nextLine();
                            Order order = menu.placeOrder(itemId, quantity);
                            order.displayOrder();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type. Please enter correct data");
                            in.nextLine();
                        } catch (InvalidItemException | InvalidQuantityException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            System.out.println("Total orders so far: " + Order.totalOrders);
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Enter Item Name:");
                            String itemName = in.nextLine();
                            if (itemName == null || itemName.trim().isEmpty()) {
                                throw new NullPointerException("Input cannot be empty");
                            }
                            System.out.println("Enter quantity:");
                            quantity = in.nextInt();
                            in.nextLine();
                            Order order = menu.placeOrder(itemName, quantity);
                            order.displayOrder();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type. Please enter correct data");
                            in.nextLine();
                        } catch (NullPointerException | InvalidItemException | InvalidQuantityException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            System.out.println("Total orders so far: " + Order.totalOrders);
                        }
                        break;
                    case 4:
                        customer.displayUser();
                        break;
                    case 5:
                        System.out.println("Number of orders: " + Order.totalOrders);
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter correct data");
                in.nextLine();
            } finally {
                System.out.println();
            }
        }
    }
}
