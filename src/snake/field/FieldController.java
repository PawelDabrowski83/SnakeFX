package snake.field;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import snake.baseController.BaseController;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FieldController extends BaseController implements Initializable {

    @FXML
    Circle head;
    @FXML
    GridPane grid;

    double velocity = 1000;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize");
        Thread thread = new Thread(this::run);
        thread.start();

    }

    public void run() {
        // game loop
        while(true) {
            try {

                Thread.sleep(100);
                move();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void move() {
        System.out.println("move");
    }

    public void moveKey(KeyEvent event) {
        System.out.println(event.getText());
    }
}
