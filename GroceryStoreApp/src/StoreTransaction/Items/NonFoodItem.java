package StoreTransaction.Items;
/*Program name: Item.java 1.0
Author: Logan Woodward

The Item class simulates various customer-selected merchandise. 
Each instance of an Item has a name and a price stored in it. 
The Items are stored in ShoppingCart.java to be later handled by TransactionProcessor.java

+-----------------------+
|        Item           |
+-----------------------+
| - name: String        |
| - price: double       |
+-----------------------+
| + getName(): String   |
| + getPrice(): double  |
+-----------------------+

*/
public class NonFoodItem extends Item {
    private static final double TAX_RATE = 0.07; //7% tax rate for non-food items

    public NonFoodItem(String name, double price) {
        super(name, price);
    }

    //non-food items have tax applied
    @Override
    public double getTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String toString() {
        return String.format("%s (Non-Food): $%.2f + Tax: $%.2f (Total: $%.2f)", 
            getName(), getPrice(), getTax(), getTotalPrice());
    }
}