package snake.field;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Cell;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import snake.baseController.BaseController;

import java.net.URL;
import java.util.ResourceBundle;


public class FieldController extends BaseController implements Initializable {

    @FXML
    Circle head;
    @FXML
    GridPane grid;

    double velocity = 1000;
    boolean running = true;
    Direction direction = Direction.RIGHT;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize");
        Thread thread = new Thread(this::run);
        thread.start();

    }

    public void run() {
        Circle circle = new Circle(22);
        grid.setPrefSize(100, 100);
        circle.setFill(Color.MEDIUMPURPLE);
        grid.add(circle, 10, 10);


        // game loop
        while(running) {
            try {

                Thread.sleep(100);
                move();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void move() {
//        System.out.println("move");
    }

    public void moveKey(KeyEvent event) {
        System.out.println(event.getText());
    }

    public void stop() {
        running = false;
    }
}
