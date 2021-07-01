package snake.baseController;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class BaseController {

    public void exit() {
        Platform.exit();
    }

    protected Stage getStage(Control control) {
        Scene currentScene = control.getScene();
        return (Stage) currentScene.getWindow();
    }
}
