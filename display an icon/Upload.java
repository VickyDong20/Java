import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *  This shows how to display an unpload icon.
 *  @author Vicky Dong
 *  @version 2019-11-29
 *
 */
public class Upload extends Application {

    /**
     *  @param stage The window to be displayed.
     */
    @Override
    public void start(Stage stage) throws Exception {
        Polygon polygon1 = new Polygon(300,30, 350,60,325,60,325,150, 275,150, 275,60, 250,60 );
        Polygon polygon2 = new Polygon(150,100, 200,100, 200,175, 400,175, 400,100, 450,100, 450,225, 150,225,
                150,225);
        //Creating a line object
        //Set the stroke colour in black.
        polygon1.setStroke(Color.BLACK);
        polygon2.setStroke(Color.BLACK);
        // Create a Group (scene graph) with the polygon1 and polygon2.
        Group root = new Group(polygon1,polygon2);
        // The scene consists of just one group.
        Scene scene = new Scene(root, 600, 300);

        // Give the stage (window) a title and add the scene.
        stage.setTitle("Upload");
        stage.setScene(scene);
        stage.show();
    }

    /*
     *  main method to launch the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}


