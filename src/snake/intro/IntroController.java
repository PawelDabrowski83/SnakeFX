package snake.intro;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroController {

    @FXML
    Button welcomeButton;

    public void exit() {
        Platform.exit();
    }

    public void showMenu() throws IOException {
        Scene currentScene = welcomeButton.getScene();
        Stage currentWindow = (Stage) currentScene.getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene nextScene = new Scene(root, 800, 600);
        currentWindow.setScene(nextScene);

    }

    public void startGame() {

    }
}
