package snake.field;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import snake.baseController.BaseController;

import java.net.URL;
import java.util.ResourceBundle;


public class FieldController extends BaseController implements Initializable {

    Circle head;
    @FXML
    GridPane grid;

    double velocity = 3;
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
        head = new Circle(22);
        grid.setPrefSize(100, 100);
        head.setFill(Color.MEDIUMPURPLE);
        grid.add(head, 10, 10);

        Scene currentScene = grid.getScene();
        grid.setOnKeyPressed(e ->
                {   e.consume();
                    switch(e.getCode()) {
                        case NUMPAD8: direction = Direction.UP;
                        case NUMPAD2: direction = Direction.DOWN;
                        case NUMPAD4: direction = Direction.LEFT;
                        case NUMPAD6: direction = Direction.RIGHT;
                        case Q: exit();
                    }
                }
        );
        grid.requestFocus();

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
        double stepX = head.getCenterX() + velocity;
        head.setCenterX(stepX);
        head.setTranslateX(stepX);
        System.out.print(direction + " ");

    }

    public void moveKey(KeyEvent event) {
        System.out.println(event.getText());
    }

    public void stop() {
        running = false;
    }
}
