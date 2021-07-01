package snake.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import snake.baseController.BaseController;

import java.io.IOException;

public class MenuController extends BaseController {

    @FXML
    Button newGameButton;

    public void startNewGame() throws IOException {
        Stage currentStage = getStage(newGameButton);
        Parent root = FXMLLoader.load(getClass().getResource("../pickSize/pickSize.fxml"));
        Scene nextScene = new Scene(root, 800, 600);
        currentStage.setScene(nextScene);
    }
}
