package snake.intro;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import snake.baseController.BaseController;

import java.io.IOException;

public class IntroController extends BaseController {

    @FXML
    Button welcomeButton;



    public void showMenu() throws IOException {
        Stage currentStage = getStage(welcomeButton);

        Parent root = FXMLLoader.load(getClass().getResource("../menu/menu.fxml"));
        Scene nextScene = new Scene(root, 800, 600);
        currentStage.setX(200);
        currentStage.setY(80);
        currentStage.setScene(nextScene);

    }



    public void startGame() {

    }
}
