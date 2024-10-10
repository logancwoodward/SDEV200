package StoreTransaction.Transaction;

import StoreTransaction.Cart.ShoppingCart;
import StoreTransaction.Items.FoodItem; //import FoodItem
import StoreTransaction.Items.NonFoodItem; //import NonFoodItem

public class TransactionHandlerTest {
    public static void main(String[] args) {
        //create ShoppingCart and TransactionProcessor
        ShoppingCart cart = new ShoppingCart();
        TransactionProcessor processor = new TransactionProcessor(cart);
        TransactionHandler handler = new TransactionHandler(processor);

        //add items to cart
        cart.addItem(new FoodItem("Apple", 0.99)); //food item
        cart.addItem(new FoodItem("Banana", 1.29)); //food item
        cart.addItem(new FoodItem("Orange", 0.79)); //food item
        cart.addItem(new NonFoodItem("Soap", 2.99)); //non-food item
        cart.addItem(new NonFoodItem("Cat Litter", 7.49)); //non-food item
        cart.addItem(new NonFoodItem("Paper Towels", 3.99)); //non-food item
        cart.addItem(new NonFoodItem("Toilet Paper", 5.49)); //non-food item

        //display items and handle payment
        handler.displayItems();
        handler.handlePayment(); //prompt for payment and process transaction
    }
}
