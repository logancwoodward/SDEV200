import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSliderApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a text label
        Text colorText = new Text("Change My Color");
        colorText.setFill(Color.BLACK); // Initial color

        // Create sliders for red, green, blue, and opacity
        Slider redSlider = createColorSlider("Red", colorText);
        Slider greenSlider = createColorSlider("Green", colorText);
        Slider blueSlider = createColorSlider("Blue", colorText);
        Slider opacitySlider = createOpacitySlider(colorText);

        // Create a VBox layout and add components
        VBox root = new VBox(10, colorText, redSlider, greenSlider, blueSlider, opacitySlider);
        root.setPadding(new Insets(20));

        // Create a Scene
        Scene scene = new Scene(root, 400, 300);

        // Set up the Stage
        primaryStage.setTitle("Color Slider Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create color sliders
    private Slider createColorSlider(String colorName, Text colorText) {
        Slider slider = new Slider(0, 255, 0); // Range from 0 to 255
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(51);
        slider.setBlockIncrement(1);
        
        // Set listener to update text color
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateTextColor(colorText);
        });

        return slider;
    }

    // Method to create opacity slider
    private Slider createOpacitySlider(Text colorText) {
        Slider slider = new Slider(0, 1, 1); // Range from 0 to 1
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(0.2);
        slider.setBlockIncrement(0.01);
        
        // Set listener to update text opacity
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorText.setOpacity(newValue.doubleValue());
        });

        return slider;
    }

    // Method to update the text color based on sliders
    private void updateTextColor(Text colorText) {
        double red = ((Slider) colorText.getScene().lookup("#redSlider")).getValue() / 255;
        double green = ((Slider) colorText.getScene().lookup("#greenSlider")).getValue() / 255;
        double blue = ((Slider) colorText.getScene().lookup("#blueSlider")).getValue() / 255;

        colorText.setFill(new Color(red, green, blue, colorText.getOpacity()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
