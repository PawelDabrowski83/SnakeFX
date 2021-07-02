package snake.endGameScore;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import snake.baseController.BaseController;

public class EndGameScoreController extends BaseController {
    @FXML
    Button saveButton;
    @FXML
    TextField name;
    @FXML
    Text points;

    public void savePoints() {
        Stage currentStage = getStage(saveButton);


    }
}
