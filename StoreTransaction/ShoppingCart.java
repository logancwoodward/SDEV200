package StoreTransaction;
/*Program name: ShoppingCart.java 1.0
Author: Logan Woodward
The ShoppingCart class stores instances of Item.java in a list. 
Methods exist to add and remove instances of Item.java from ShoppingCart.java

Additionally, the price of each item from the list is added up and stored as a total value.

+---------------------------+
|    ShoppingCart           |
+---------------------------+
| - items: List<Item>       |
| - total: double           |
+---------------------------+
| + ShoppingCart()          |
| + addItem(item: Item)     |
| + removeItem(item: Item)  |
| + getTotal(): double      |
| + getItems(): List<Item>  |
| + clearCart(): void       |
| - updateTotal(): void     |
+---------------------------+
        ^
        |
        |
+-----------------------------------------------+
|    TransactionProcessor                       |
+-----------------------------------------------+
        ^
        |
        |
+-------------------------------------------------------+
|     TransactionHandler                                |
+-------------------------------------------------------+

*/

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
        private final List<Item> items;
        private double total;

        public ShoppingCart() {
                this.items = new ArrayList<>();
                this.total = 0.0;
        }
        //add and remove methods for items list and update total shopping cart value               
        public void addItem(Item item) {
                if (item == null) { //no null values
                        throw new IllegalArgumentException("Item cannot be null");
                    }
                items.add(item);
                
                updateTotal();
        }

        public void removeItem(Item item) {
                items.remove(item);
                updateTotal();
        }
        //methods to return current total and item names in shopping cart
        public double getTotal() {
                return total;
        }

        public List<Item> getItems() {
                return new ArrayList<>(items); //return copy to prevent external modifications
        }
        //empty all items
        public void clearCart() {
                items.clear();
                total = 0.0;
        }
        //calculate shopping cart total value
        private void updateTotal() {
                total = 0.0;
                for (Item item : items) {
                total += item.getPrice();
                }
        }
        @Override
        public String toString() {
                StringBuilder sb = new StringBuilder("ShoppingCart{\n");
                for (Item item : items) {
                        sb.append("  ").append(item.getName()).append(": $").append(item.getPrice()).append("\n");
                }
                sb.append("Total: $").append(total).append("\n");
                sb.append("}");
                return sb.toString();
        }
}
