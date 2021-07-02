package snake.field;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import snake.baseController.BaseController;
import snake.model.Snake;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class FieldController extends BaseController implements Initializable {

    public static final int PADDING = 25;
    Snake snake;
    Circle head;
    Thread gameThread;
    Thread counterThread;

    @FXML
    GridPane grid;
    @FXML
    Text counter;
    int counterSeconds;

    public static volatile boolean running = true;

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
        try {
            stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() throws IOException {
        running = false;
        counterThread.interrupt();

//        Stage currentStage = (Stage) grid.getScene().getWindow();
//
//        Parent root = FXMLLoader.load(getClass().getResource("../endGameScore/endGameScore.fxml"));
//        Scene nextScene = new Scene(root, 800, 600);
//        currentStage.setScene(nextScene);
    }
}
