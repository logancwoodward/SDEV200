import java.util.List;

public class ShoppingCartTest {
    public static void main(String[] args) {
        //create a ShoppingCart instance
        ShoppingCart cart = new ShoppingCart();
        
        //create some Item instances
        Item item1 = new Item("Apple", 0.99);
        Item item2 = new Item("Banana", 1.29);
        Item item3 = new Item("Orange", 0.79);
        
        //add items to the cart
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        
        //display total and items in the cart
        System.out.println("Total after adding items: $" + cart.getTotal());
        printCartItems(cart.getItems());

        //remove an item from the cart
        cart.removeItem(item2);
        System.out.println("Total after removing Banana: $" + cart.getTotal());
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
