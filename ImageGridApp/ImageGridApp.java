import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GifGridDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        //create a GridPane to hold the images
        GridPane gridPane = new GridPane();

        //load GIF images with relative paths
        Image image1 = new Image("file:Images/flag1.gif");
        Image image2 = new Image("file:Images/flag2.gif");
        Image image3 = new Image("file:Images/flag6.gif");
        Image image4 = new Image("file:Images/flag7.gif");

        //create ImageViews
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        //set preferred size for images (optional)
        imageView1.setFitWidth(200);
        imageView1.setFitHeight(200);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(200);
        imageView3.setFitWidth(200);
        imageView3.setFitHeight(200);
        imageView4.setFitWidth(200);
        imageView4.setFitHeight(200);

        //add ImageViews to the GridPane
        gridPane.add(imageView1, 0, 0);
        gridPane.add(imageView2, 1, 0);
        gridPane.add(imageView3, 0, 1);
        gridPane.add(imageView4, 1, 1);

        //create a Scene
        Scene scene = new Scene(gridPane, 400, 400);

        //set up the Stage
        primaryStage.setTitle("GIF Grid Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
