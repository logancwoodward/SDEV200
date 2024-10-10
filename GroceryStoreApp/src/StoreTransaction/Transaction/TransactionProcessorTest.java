package StoreTransaction.Transaction;

import StoreTransaction.Cart.ShoppingCart;
import StoreTransaction.Items.FoodItem; //import FoodItem
import StoreTransaction.Items.NonFoodItem; //import NonFoodItem

public class TransactionProcessorTest {
    public static void main(String[] args) {
        //create ShoppingCart and TransactionProcessor
        ShoppingCart cart = new ShoppingCart();
        TransactionProcessor processor = new TransactionProcessor(cart);
        
        //add items to cart
        cart.addItem(new FoodItem("Apple", 0.99)); //food item
        cart.addItem(new FoodItem("Banana", 1.29)); //food item
        cart.addItem(new FoodItem("Orange", 0.79)); //food item
        cart.addItem(new NonFoodItem("Soap", 2.99)); //non-food item
        cart.addItem(new NonFoodItem("Cat Litter", 7.49)); //non-food item
        cart.addItem(new NonFoodItem("Paper Towels", 3.99)); //non-food item
        cart.addItem(new NonFoodItem("Toilet Paper", 5.49)); //non-food item
        
        //display total amount due
        System.out.println(processor.displayTotal());
        
        //process a transaction with sufficient payment
        double payment = 20.00; // Example payment
        double change = processor.processTransaction(payment);
        System.out.println("Transaction successful! Change: $" + change);
        
        //try to process a transaction with insufficient payment
        try {
            payment = 1.00; //example insufficient payment
            processor.processTransaction(payment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); //output: Insufficient payment.
        }
    }
}
