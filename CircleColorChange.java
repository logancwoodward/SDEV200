/*15.7 (CHANGE COLOR USING A MOUSE) 
Write a program that displays the color of a 
circle as black when the mouse button is pressed, 
and as white when the mouse button is released.

*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CircleColorChange extends Application {

    @Override
    public void start(Stage primaryStage) {
        //create a circle
        Circle circle = new Circle(100); // radius of 100
        circle.setFill(Color.WHITE); // initial color is white

        //add mouse pressed event
        circle.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                circle.setFill(Color.BLACK); // change color to black when pressed
            }
        });

        //add mouse released event
        circle.setOnMouseReleased(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                circle.setFill(Color.WHITE); // change color to white when released
            }
        });

        //set up the layout
        StackPane root = new StackPane(circle);
        Scene scene = new Scene(root, 400, 400);

        //set up the Stage
        primaryStage.setTitle("Circle Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
