package StoreTransaction.Items;
/*Program name: Item.java
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

public abstract class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //abstract method to be implemented by subclasses
    public abstract double getTax();
    
    //total price includes price + tax
    public double getTotalPrice() {
        return price + getTax();
    }
    
    //toString method for displaying item details
    @Override
    public String toString() {
        return String.format("%s: $%.2f (Total: $%.2f)", name, price, getTotalPrice());
    }
}
