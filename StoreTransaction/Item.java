package StoreTransaction;
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
//
public class Item {
    private final String name;
    private final double price;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    
    public double getPrice() {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }        
        return price;
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', price=" + price + "}";
}
    
}
