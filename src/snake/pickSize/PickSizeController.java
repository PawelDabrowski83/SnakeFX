package snake.pickSize;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import snake.baseController.BaseController;

import java.util.concurrent.ThreadLocalRandom;

public class PickSizeController extends BaseController {
    public static final int MAX_SIDE_WIDTH = 20;
    public static final int MAX_SIDE_HEIGHT = 15;
    public static final int MIN_SIDE_WIDTH = 5;
    public static final int MIN_SIDE_HEIGHT = 5;

    @FXML
    public TextField sideWidth;

    @FXML
    public TextField sideHeight;

    public void startGame() {

    }

    private boolean checkSides() {
        return false;
    }

    public void randomizeSides() {
        System.out.println(sideWidth);
        sideWidth.setText(
                String.valueOf(
                        ThreadLocalRandom.current().nextInt(MIN_SIDE_WIDTH, MAX_SIDE_WIDTH)
                )
        );
        sideHeight.setText(
                String.valueOf(
                        ThreadLocalRandom.current().nextInt(MIN_SIDE_HEIGHT, MAX_SIDE_HEIGHT)
                )
        );
    }
}
