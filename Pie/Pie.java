import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/*
 *  we represent expenditures as a pie chart. we write a class Pie.java to represent all expenditures in a corresponding
 *  array of type Expenditure. Write a method public void start(Stage stage) throws Exception that displays the
 * expenditures as a pie chart with the description placed next to the corresponding part of the pie chart.
 *  @author Vicky Dong
 *  @version 2019-11-30
 */

public class Pie extends Application {
    // the radius of the circle
    public static final int radius = 150;
    //X_OFFSET moves the board on the x-axis out of the left upper corner.
    public static final int X_OFFSET = 400;
    //Y_OFFSET moves the board on the y-axis out of the left upper corner.
    public static final int Y_OFFSET = 300;
    //the maximum elements of the array
    private static final int MAXIMUM = 8;
    private static String[] texts = new String[MAXIMUM];
    //the percentage of one elements in the array
    private static int[] amounts = new int[MAXIMUM];
    //initialize sum
    private static int sum = 0;

    /*
     * declare the elements in expenditures
     */
    private static Expenditure[] expenditures = new Expenditure[]{
            new Expenditure("Salaries", 11000),
            new Expenditure("Paper", 2000),
            new Expenditure("Rent", 5000),
            new Expenditure("Most popular books on Java etc.", 10000),
            new Expenditure("Heating", 3000),
            new Expenditure("Coffee/Tea", 7000),
            new Expenditure("Biscuits", 8000),
            new Expenditure("Travel", 18000),
            new Expenditure("Electricity", 1000),
            new Expenditure("Pencils", 3000)
    };

    //getter of expenditures
    public static Expenditure[] getExpenditures() {
        return expenditures;
    }

    /*
     * sort method that sort an array of type expenditure from biggest to smallest
     */
    public static void sortExpenditure() {
        Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) -> exp2.getValue() - exp1.getValue());
    }

    /*
     * the method to calculate the sum of the expenditures' value.
     */
    static void valueSum() {
        for (int i = 0; i < expenditures.length; i++) {
            sum = sum + expenditures[i].getValue();
        }
    }

   /*
    * A circle is defined by the coordinates of the center and the radius.
    */
   static void drawCircle(Group group) {
     Circle circle = new Circle(X_OFFSET, Y_OFFSET, radius);
     circle.setStroke(Color.BLACK);
     circle.setFill(Color.WHITE);
     Group root=new Group(circle);
     group.getChildren().add(circle);
   }

  /*
   *  A method to draw line and add the legend
   */
   public void drawLine(Group group) {
       double prevAngle = 0;
       double angle = 0;
       int temAmounts = 0;
       for (int i = 0; i < MAXIMUM - 1; i++) {
           texts[i] = expenditures[i].getDescription();
           amounts[i] = (int) Math.round(expenditures[i].getValue() * 360.0 / sum);
           temAmounts += amounts[i];
           texts[MAXIMUM - 1] = "Other";
           amounts[MAXIMUM - 1] = 360 - temAmounts;
       }
       for (int i = 0; i < MAXIMUM; i++) {
           angle = angle - amounts[i];
           double lineX = X_OFFSET + radius * Math.cos(Math.toRadians(angle));
           double lineY = Y_OFFSET + radius * Math.sin(Math.toRadians(angle));
           Line line = new Line(X_OFFSET, Y_OFFSET, lineX, lineY);
           Group root = new Group(line);
           group.getChildren().add(line);
           double textAngle = (angle + prevAngle) / 2;
           double textX = X_OFFSET + (radius + 45) * Math.cos(Math.toRadians(textAngle));
           double textY = Y_OFFSET + (radius + 45) * Math.sin(Math.toRadians(textAngle));

           Text text = new Text(textX, textY,texts[i]);
           if (angle > -270 && angle < -90)
               text.setX(text.getX() - (texts[i].length() * 6));
           group.getChildren().add(text);
           prevAngle = angle;}
       }

    /**
     *  We create a frame with a panel on which the Pie chart is displayed.
     *  @param stage The window to be displayed.
     */
       public void start (Stage stage) throws Exception {
           sortExpenditure();
           valueSum();
           // Create a Group (scene graph).
           Group root=new Group();
           drawCircle(root);
           drawLine(root);
           // The scene consists of just one group.
           Scene scene=new Scene(root,700,600);
           // Give the stage (window) a title and add the scene.
           stage.setTitle("Pie chart");
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
