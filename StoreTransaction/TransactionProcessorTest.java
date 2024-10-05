package StoreTransaction;
public class TransactionProcessorTest {
    public static void main(String[] args) {
        //create ShoppingCart and TransactionProcessor
        ShoppingCart cart = new ShoppingCart();
        TransactionProcessor processor = new TransactionProcessor(cart);
        
        //add items to cart
        cart.addItem(new Item("Apple", 0.99));
        cart.addItem(new Item("Banana", 1.29));
        cart.addItem(new Item("Orange", 0.79));
        
        //display total amount due
        System.out.println(processor.displayTotal());
        
        //process a transaction with sufficient payment
        double payment = 3.00; // Example payment
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
