package snake.field;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import snake.baseController.BaseController;

import java.net.URL;
import java.util.ResourceBundle;


public class FieldController extends BaseController implements Initializable {

    Circle head;
    double stepX;
    double stepY;
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

        grid.setOnKeyPressed(e ->
                {
                    switch(e.getCode()) {
                        case NUMPAD8, W, UP -> direction = Direction.UP;
                        case NUMPAD2, S, DOWN -> direction = Direction.DOWN;
                        case NUMPAD4, A, LEFT -> direction = Direction.LEFT;
                        case NUMPAD6, D, RIGHT -> direction = Direction.RIGHT;
                        case Q -> exit();
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
        switch (direction) {
            case UP -> moveUp();
            case DOWN -> moveDown();
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
        }
    }

    private void moveUp() {
        stepX = head.getCenterX();
        stepY = head.getCenterY() - velocity;
        actualMove();
    }

    private void moveDown() {
        stepX = head.getCenterX();
        stepY = head.getCenterY() + velocity;
        actualMove();
    }

    private void moveLeft() {
        stepX = head.getCenterX() - velocity;
        stepY = head.getCenterY();
        actualMove();
    }

    private void moveRight() {
        stepX = head.getCenterX() + velocity;
        stepY = head.getCenterY();
        actualMove();
    }

    private void actualMove() {
        head.setCenterX(stepX);
        head.setTranslateX(stepX);
        head.setCenterY(stepY);
        head.setTranslateY(stepY);
    }

    private boolean isClashed() {
        return false;
    }

    public void moveKey(KeyEvent event) {
        System.out.println(event.getText());
    }

    public void stop() {
        running = false;
    }
}
