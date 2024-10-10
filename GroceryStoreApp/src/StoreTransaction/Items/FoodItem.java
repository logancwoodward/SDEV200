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

public class FoodItem extends Item {

    public FoodItem(String name, double price) {
        super(name, price);
    }

    //food items have no tax
    @Override
    public double getTax() {
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("%s (Food): $%.2f (Tax-Free)", getName(), getPrice());
    }
    
}
