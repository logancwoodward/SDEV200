package StoreTransaction;
public class TransactionHandlerTest {
    public static void main(String[] args) {
        //create ShoppingCart and TransactionProcessor
        ShoppingCart cart = new ShoppingCart();
        TransactionProcessor processor = new TransactionProcessor(cart);
        TransactionHandler handler = new TransactionHandler(processor);

        //add items to cart
        cart.addItem(new Item("Apple", 0.99));
        cart.addItem(new Item("Banana", 1.29));
        cart.addItem(new Item("Orange", 0.79));

        //display items and handle payment
        handler.displayItems();
        handler.handlePayment(); //prompt for payment and process transaction
    }
}
