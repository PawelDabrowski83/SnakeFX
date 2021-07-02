package snake.field;

import javafx.animation.PauseTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import snake.baseController.BaseController;
import snake.model.Snake;

import java.net.URL;
import java.util.ResourceBundle;


public class FieldController extends BaseController implements Initializable {

    public static final int PADDING = 25;
    public static final int TOP_BAR = 30;
    Snake snake;
    Circle head;
    Thread gameThread;
    Thread counterThread;

    @FXML
    GridPane grid;
    @FXML
    Text counter;
//    IntegerProperty counterSeconds = new SimpleIntegerProperty(0);
    int counterSeconds;

    public static boolean running = true;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize");
        gameThread = new Thread(this::run);
        gameThread.start();

        counterThread = new Thread(() -> {
            while(running && !counterThread.isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    counterSeconds++;
                    System.out.println(counterSeconds);
                    counter.setText(String.valueOf(counterSeconds));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        counterThread.start();
    }

    public void run() {
        snake = new Snake(grid);
        head = snake.getHead();
        grid.setPrefSize(100, 1000);

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
        while(running && !gameThread.isInterrupted()) {
            try {
                Thread.sleep(100);
                snake.move();
            } catch (InterruptedException e) {
                e.printStackTrace();
                counterThread.interrupt();
            }
        }
        stop();
    }

    public void stop() {
        running = false;
        counterThread.interrupt();
    }
}
