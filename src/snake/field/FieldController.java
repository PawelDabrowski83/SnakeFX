package snake.field;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import snake.baseController.BaseController;
import snake.model.Snake;

import java.net.URL;
import java.util.ResourceBundle;


public class FieldController extends BaseController implements Initializable {

    Circle head;

    Snake snake;
    @FXML
    GridPane grid;
    boolean running = true;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize");
        Thread thread = new Thread(this::run);
        thread.start();
    }

    public void run() {
        snake = new Snake();
        head = snake.getHead();
        grid.setPrefSize(100, 100);

        grid.add(head, 10, 10);

        grid.setOnKeyPressed(e ->
                {
                    switch(e.getCode()) {
                        case NUMPAD8, W, UP -> snake.setDirection(Direction.UP);
                        case NUMPAD2, S, DOWN -> snake.setDirection(Direction.DOWN);
                        case NUMPAD4, A, LEFT -> snake.setDirection(Direction.LEFT);
                        case NUMPAD6, D, RIGHT -> snake.setDirection(Direction.RIGHT);
                        case Q -> exit();
                    }
                }
        );
        grid.requestFocus();

        // game loop
        while(running) {
            try {
                Thread.sleep(100);
                snake.move();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }
}
