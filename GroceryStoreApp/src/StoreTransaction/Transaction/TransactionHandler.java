package StoreTransaction.Transaction;
/*Program name: TransactionHandler.java
Author: Logan Woodward


+---------------------------+
|    ShoppingCart           |
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
| - processor: TransactionProcessor                     |
+-------------------------------------------------------+
| + TransactionHandler(processor: TransactionProcessor) |
| + displayItems: void                                  |
| + promptForPayment(payment: double)                   |
| + handlePayment(payment: double)                      |
| + printReceipt()                                      |
+-------------------------------------------------------+

*/
import StoreTransaction.Items.Item;
import java.util.List;
import java.util.Scanner;

public class TransactionHandler {
    private final TransactionProcessor processor;

    public TransactionHandler(TransactionProcessor processor) {
        this.processor = processor;
    }

    //display items in the shopping cart
    public void displayItems() {
        List<Item> items = processor.getItems(); //use the new method
        System.out.println("Items in your cart:");
        if (items.isEmpty()) {
            System.out.println("  (No items)");
        } else {
            for (Item item : items) {
                System.out.printf("  - %s: $%.2f%n", item.getName(), item.getTotalPrice());
            }
        }
        System.out.println(processor.displayTotal());
    }

    //prompt the user for payment
    public double promptForPayment() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter your payment amount: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); //clear the invalid input
            }
            return scanner.nextDouble();
        }
    }

    //handle the payment process
    public void handlePayment() {
        double payment = promptForPayment();
        try {
            double change = processor.processTransaction(payment);
            System.out.println("Transaction successful! Your change is: $" + change);
            printReceipt();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); //output: Insufficient payment.
        }
    }

    //print a simple receipt
    public void printReceipt() {
        System.out.println("Receipt:");
        System.out.println("Thank you for your purchase!");
        System.out.println("Items purchased:");
        displayItems(); //reuse displayItems to show the items again
    }
}
