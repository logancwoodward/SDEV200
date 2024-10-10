package StoreTransaction.Cart;

import StoreTransaction.Items.FoodItem;
import StoreTransaction.Items.Item;
import StoreTransaction.Items.NonFoodItem;
import java.util.List;

public class ShoppingCartTest {
    public static void main(String[] args) {
        //create ShoppingCart instance
        ShoppingCart cart = new ShoppingCart();
        
        //create some Item instances
        Item apple = new FoodItem("Apple", 0.99);
        Item soap = new NonFoodItem("Soap", 3.49);
        Item bread = new FoodItem("Bread", 2.49);
        
        //add items to the cart
        cart.addItem(apple);
        cart.addItem(soap);
        cart.addItem(bread);
        
        //display total and items in the cart
        System.out.println("Total after adding items: $" + cart.getTotal());
        printCartItems(cart.getItems());

        //remove an item from the cart
        cart.removeItem(soap);
        System.out.println("Total after removing Soap: $" + cart.getTotal());
        printCartItems(cart.getItems());

        //clear the cart
        cart.clearCart();
        System.out.println("Total after clearing cart: $" + cart.getTotal());
        printCartItems(cart.getItems());
    }

    private static void printCartItems(List<Item> items) {
        System.out.println("Items in cart:");
        if (items.isEmpty()) {
            System.out.println("  (No items)");
        } else {
            for (Item item : items) {
                System.out.println("  - " + item.getName() + " ($" + item.getPrice() + ")");
            }
        }
    }
}
