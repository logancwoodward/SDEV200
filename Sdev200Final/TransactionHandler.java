/*Program name: TransactionHandler.java 1.0
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

import java.util.List;
import java.util.Scanner;

public class TransactionHandler {
    private final TransactionProcessor processor;

    public TransactionHandler(TransactionProcessor processor) {
        this.processor = processor;
    }

    // Display items in the shopping cart
    public void displayItems() {
        List<Item> items = processor.getItems(); // Use the new method
        System.out.println("Items in your cart:");
        if (items.isEmpty()) {
            System.out.println("  (No items)");
        } else {
            for (Item item : items) {
                System.out.println("  - " + item.getName() + ": $" + item.getPrice());
            }
        }
        System.out.println(processor.displayTotal());
    }

    // Prompt the user for payment
    public double promptForPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your payment amount: ");
        return scanner.nextDouble();
    }

    // Handle the payment process
    public void handlePayment() {
        double payment = promptForPayment();
        try {
            double change = processor.processTransaction(payment);
            System.out.println("Transaction successful! Your change is: $" + change);
            printReceipt();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Output: Insufficient payment.
        }
    }

    // Print a simple receipt
    public void printReceipt() {
        System.out.println("Receipt:");
        System.out.println("Thank you for your purchase!");
        System.out.println("Items purchased:");
        displayItems(); // Reuse displayItems to show the items again
    }
}
