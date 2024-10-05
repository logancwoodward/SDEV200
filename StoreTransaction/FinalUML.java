package StoreTransaction;
/*Module 4 Final Project: Update 2 - UML

+-----------------------+
|        Item           |
+-----------------------+
| - name: String        |
| - price: double       |
+-----------------------+
| + getName(): String   |
| + getPrice(): double  |
+-----------------------+



+---------------------------+
|    ShoppingCart           |
+---------------------------+
| - items: List<Item>       |
| - total: double           |
+---------------------------+
| + ShoppingCart()          |
| + addItem(item: Item)     |
| + removeItem(item: Item)  |
| + getTotal(): double      |
| + getItems(): List<Item>  |
| + clearCart(): void       |
| - updateTotal(): void     |
+---------------------------+
        ^
        |
        |
+-----------------------------------------------+
|    TransactionProcessor                       |
+-----------------------------------------------+
| - cart: ShoppingCart                          |
+-----------------------------------------------+
| + TransactionProcessor(cart: ShoppingCart)    |
| + processTransaction(payment: double): double |
| + validatePayment(payment: double): double    |
| + displayTotal(): String                      |
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