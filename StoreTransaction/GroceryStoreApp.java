package StoreTransaction;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GroceryStoreApp extends Application {
    private ShoppingCart cart;
    private List<Item> availableItems;

    @Override
    public void start(Stage primaryStage) {
        cart = new ShoppingCart();
        availableItems = createSampleItems();

        // Create the GUI components
        primaryStage.setTitle("Grocery Store Simulator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Item selection
        ComboBox<Item> itemComboBox = new ComboBox<>();
        itemComboBox.getItems().addAll(availableItems);
        grid.add(new Label("Select Item:"), 0, 0);
        grid.add(itemComboBox, 1, 0);

        // Add item button
        Button addButton = new Button("Add to Cart");
        grid.add(addButton, 2, 0);

        // Display cart contents
        TextArea cartDisplay = new TextArea();
        cartDisplay.setEditable(false);
        grid.add(cartDisplay, 0, 1, 3, 1);

        // Process transaction
        TextField paymentField = new TextField();
        grid.add(new Label("Enter Payment:"), 0, 2);
        grid.add(paymentField, 1, 2);

        Button checkoutButton = new Button("Checkout");
        grid.add(checkoutButton, 2, 2);

        // Set actions for buttons
        addButton.setOnAction(e -> {
            Item selectedItem = itemComboBox.getValue();
            if (selectedItem != null) {
                cart.addItem(selectedItem);
                updateCartDisplay(cartDisplay);
            }
        });

        checkoutButton.setOnAction(e -> {
            double payment = Double.parseDouble(paymentField.getText());
            TransactionProcessor processor = new TransactionProcessor(cart);
            try {
                double change = processor.processTransaction(payment);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, 
                        "Transaction successful! Your change is: $" + change);
                alert.showAndWait();
                cart.clearCart();  // Clear cart after transaction
                updateCartDisplay(cartDisplay);
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.showAndWait();
            }
        });

        // Set up the scene
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Sample items for the combo box
    private List<Item> createSampleItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Apple", 0.99));
        items.add(new Item("Banana", 0.59));
        items.add(new Item("Carrot", 0.39));
        items.add(new Item("Doughnut", 1.29));
        return items;
    }

    // Update cart display
    private void updateCartDisplay(TextArea cartDisplay) {
        StringBuilder displayText = new StringBuilder("Items in Cart:\n");
        for (Item item : cart.getItems()) {
            displayText.append(String.format("  - %s: $%.2f\n", item.getName(), item.getPrice()));
        }
        displayText.append("Total: $" + String.format("%.2f", cart.getTotal()));
        cartDisplay.setText(displayText.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
