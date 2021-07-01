package snake.pickSize;

import javafx.fxml.FXML;

import java.util.concurrent.ThreadLocalRandom;

public class PickSizeController {
    public static final int MAX_SIDE_WIDTH = 20;
    public static final int MAX_SIDE_HEIGHT = 15;
    public static final int MIN_SIDE_WIDTH = 5;
    public static final int MIN_SIDE_HEIGHT = 5;

    @FXML
    public String sideWidth;

    @FXML
    public String sideHeight;

    public void startGame() {

    }

    private boolean checkSides() {
        return false;
    }

    public void randomizeSides() {
        sideWidth = String.valueOf(ThreadLocalRandom.current().nextInt(MIN_SIDE_WIDTH, MAX_SIDE_WIDTH));
        sideHeight = String.valueOf(ThreadLocalRandom.current().nextInt(MIN_SIDE_HEIGHT, MAX_SIDE_HEIGHT));

    }
}
