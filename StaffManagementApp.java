/*34.1 (Access and update a Staff table) Write a program that views, inserts, and updates 
staff information stored in a database, as shown in Figure 34.27a. The View button 
displays a record with a specified ID. The Insert button inserts a new record. The 
Update button updates the record for the specified ID. The Staff table is created 
as follows:
create table Staff (
 id char(9) not null,
 lastName varchar(15),
 firstName varchar(15),
 mi char(1),
 address varchar(20),
 city varchar(20),
 state char(2),
 telephone char(10),
 email varchar(40),
 primary key (id)
);
*/


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class StaffManagementApp extends Application {
    
    private Connection connection;
    
    private TextField idField, lastNameField, firstNameField, miField, 
                     addressField, cityField, stateField, telephoneField, emailField;
    
    @Override
    public void start(Stage primaryStage) {
        //set up the UI elements
        idField = new TextField();
        lastNameField = new TextField();
        firstNameField = new TextField();
        miField = new TextField();
        addressField = new TextField();
        cityField = new TextField();
        stateField = new TextField();
        telephoneField = new TextField();
        emailField = new TextField();
        
        Button viewButton = new Button("View");
        Button insertButton = new Button("Insert");
        Button updateButton = new Button("Update");
        
        viewButton.setOnAction(e -> viewRecord());
        insertButton.setOnAction(e -> insertRecord());
        updateButton.setOnAction(e -> updateRecord());
        
        //set up layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);
        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(new Label("First Name:"), 0, 2);
        grid.add(firstNameField, 1, 2);
        grid.add(new Label("MI:"), 0, 3);
        grid.add(miField, 1, 3);
        grid.add(new Label("Address:"), 0, 4);
        grid.add(addressField, 1, 4);
        grid.add(new Label("City:"), 0, 5);
        grid.add(cityField, 1, 5);
        grid.add(new Label("State:"), 0, 6);
        grid.add(stateField, 1, 6);
        grid.add(new Label("Telephone:"), 0, 7);
        grid.add(telephoneField, 1, 7);
        grid.add(new Label("Email:"), 0, 8);
        grid.add(emailField, 1, 8);
        
        grid.add(viewButton, 0, 9);
        grid.add(insertButton, 1, 9);
        grid.add(updateButton, 2, 9);
        
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Staff Management");
        primaryStage.show();

        //initialize database connection
        initializeDatabase();
    }
    
    private void initializeDatabase() {
        try {
            //replace with your database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/yourdatabase";
            String user = "yourusername";
            String password = "yourpassword";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void viewRecord() {
        String id = idField.getText();
        String query = "SELECT * FROM Staff WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                lastNameField.setText(rs.getString("lastName"));
                firstNameField.setText(rs.getString("firstName"));
                miField.setText(rs.getString("mi"));
                addressField.setText(rs.getString("address"));
                cityField.setText(rs.getString("city"));
                stateField.setText(rs.getString("state"));
                telephoneField.setText(rs.getString("telephone"));
                emailField.setText(rs.getString("email"));
            } else {
                showAlert("No record found for ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void insertRecord() {
        String query = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idField.getText());
            statement.setString(2, lastNameField.getText());
            statement.setString(3, firstNameField.getText());
            statement.setString(4, miField.getText());
            statement.setString(5, addressField.getText());
            statement.setString(6, cityField.getText());
            statement.setString(7, stateField.getText());
            statement.setString(8, telephoneField.getText());
            statement.setString(9, emailField.getText());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                showAlert("Record inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void updateRecord() {
        String query = "UPDATE Staff SET lastName = ?, firstName = ?, mi = ?, address = ?, city = ?, state = ?, telephone = ?, email = ? WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lastNameField.getText());
            statement.setString(2, firstNameField.getText());
            statement.setString(3, miField.getText());
            statement.setString(4, addressField.getText());
            statement.setString(5, cityField.getText());
            statement.setString(6, stateField.getText());
            statement.setString(7, telephoneField.getText());
            statement.setString(8, emailField.getText());
            statement.setString(9, idField.getText());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                showAlert("Record updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
