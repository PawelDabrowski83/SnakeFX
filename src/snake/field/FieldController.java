package snake.field;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import snake.baseController.BaseController;

import java.net.URL;
import java.util.ResourceBundle;

public class FieldController extends BaseController implements Initializable {

    @FXML
    Circle head;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        head.setCenterX(head.getCenterX() + 10);
    }

    public void move(ActionEvent event) {
        System.out.println(event.toString());
    }
}
