/*35.1 (Batch update) Write a program that inserts a thousand records to a database, and 
compare the performance with and without batch updates, as shown in Figure 35.5a. 
Suppose the table is defined as follows:
create table Temp(num1 double, num2 double, num3 double)
 Use the Math.random() method to generate random numbers for each record. 
Create a dialog box that contains DBConnectionPanel, discussed in Exercise 
34.3. Use this dialog box to connect to the database. When you click the Connect 
to Database button in Figure 35.5a, the dialog box in Figure 35.5b is displayed.*/



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Random;

public class BatchUpdateDemo extends Application {
    private Connection connection;
    private TextField urlField, userField, passwordField;

    @Override
    public void start(Stage primaryStage) {
        //set up the main layout
        Button connectButton = new Button("Connect to Database");
        Button insertButton = new Button("Insert Records");
        Button batchInsertButton = new Button("Batch Insert Records");

        connectButton.setOnAction(e -> showConnectionDialog());
        insertButton.setOnAction(e -> insertRecords(false));
        batchInsertButton.setOnAction(e -> insertRecords(true));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(connectButton, insertButton, batchInsertButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Batch Update Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showConnectionDialog() {
        Stage dialog = new Stage();
        dialog.setTitle("Database Connection");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        urlField = new TextField();
        userField = new TextField();
        passwordField = new TextField();

        grid.add(new Label("Database URL:"), 0, 0);
        grid.add(urlField, 1, 0);
        grid.add(new Label("Username:"), 0, 1);
        grid.add(userField, 1, 1);
        grid.add(new Label("Password:"), 0, 2);
        grid.add(passwordField, 1, 2);

        Button connect = new Button("Connect");
        connect.setOnAction(e -> connectToDatabase(dialog));
        grid.add(connect, 1, 3);

        Scene dialogScene = new Scene(grid, 300, 150);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private void connectToDatabase(Stage dialog) {
        String url = urlField.getText();
        String user = userField.getText();
        String password = passwordField.getText();

        try {
            connection = DriverManager.getConnection(url, user, password);
            dialog.close();
            showAlert("Connected to the database!");
        } catch (SQLException e) {
            showAlert("Failed to connect to the database: " + e.getMessage());
        }
    }

    private void insertRecords(boolean useBatch) {
        if (connection == null) {
            showAlert("Please connect to the database first.");
            return;
        }

        String query = "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < 1000; i++) {
                double num1 = Math.random();
                double num2 = Math.random();
                double num3 = Math.random();
                
                statement.setDouble(1, num1);
                statement.setDouble(2, num2);
                statement.setDouble(3, num3);
                
                if (useBatch) {
                    statement.addBatch();
                    if (i % 100 == 0) {  //execute batch every 100 records
                        statement.executeBatch();
                    }
                } else {
                    statement.executeUpdate();
                }
            }

            if (useBatch) {
                statement.executeBatch();  //execute remaining records
            }

            long endTime = System.currentTimeMillis();
            showAlert((useBatch ? "Batch " : "") + "Insert completed in " + (endTime - startTime) + " ms");

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error during insertion: " + e.getMessage());
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
