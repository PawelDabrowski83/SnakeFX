package snake.endGameScore;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import snake.baseController.BaseController;

import java.io.IOException;

public class EndGameScoreController extends BaseController {
    @FXML
    Button saveButton;
    @FXML
    TextField name;
    @FXML
    Text points;

    public void savePoints() throws IOException {

    }
}
