package StoreTransaction.Transaction;

import StoreTransaction.Cart.ShoppingCart;
import StoreTransaction.Items.Item;
import java.util.List;

/* Program name: TransactionProcessor.java 1.0
 * Author: Logan Woodward
 * This program simulates the first half of a sales transaction.
 * Instances of Item.java and their values have already been stored in ShoppingCart.java.
 *
 * +---------------------------+
 * |    TransactionProcessor    |
 * +---------------------------+
 * | - cart: ShoppingCart      |
 * +---------------------------+
 * | + TransactionProcessor(cart: ShoppingCart)    |
 * | + processTransaction(payment: double): double |
 * | + validatePayment(payment: double): double    |
 * | + displayTotal(): String                      |
 * +---------------------------+
 */

public class TransactionProcessor {
    private final ShoppingCart cart;

    public TransactionProcessor(ShoppingCart cart) {
        this.cart = cart;
    }

    //get items from method in ShoppingCart
    public List<Item> getItems() {
        return cart.getItems();
    }

    //process transaction and return change if payment is valid
    public double processTransaction(double payment) {
        if (payment < 0) { //no negative payment
            throw new IllegalArgumentException("Payment cannot be negative.");
        }
        double change = validatePayment(payment);
    
        if (change >= 0) {
            cart.clearCart(); //clear cart after successful transaction
            //round change to two decimal places
            return Math.round(change * 100.0) / 100.0;
        } else {
            throw new IllegalArgumentException("Insufficient payment.");
        }
    }


    //validate payment against total amount
    public double validatePayment(double payment) {
        double total = cart.getTotal(); //retrievetotal
        if (payment < total) {
            return -1; //indicate insufficient payment
        }
        return payment - total; //return change
    }

    //return string displaying total amount due
    public String displayTotal() {
        return String.format("Total amount due: $%.2f", cart.getTotal());
    }

    @Override
    public String toString() {
        return displayTotal();
    }
}
