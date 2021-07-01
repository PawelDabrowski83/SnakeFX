package snake.pickSize;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Dimension2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import snake.baseController.BaseController;

import java.util.concurrent.ThreadLocalRandom;

public class PickSizeController extends BaseController {
    public static final int MAX_SIDE_WIDTH = 20;
    public static final int MAX_SIDE_HEIGHT = 15;
    public static final int MIN_SIDE_WIDTH = 5;
    public static final int MIN_SIDE_HEIGHT = 5;
    public static final String ILLEGAL_SIDE_BUTTON = "Unexpected value on pickSize button. Contact project owner.";

    @FXML
    public TextField sideWidth;

    @FXML
    public TextField sideHeight;

    public void startGame() {

    }

    private boolean checkSides() {
        return false;
    }

    public void setSides(ActionEvent event) {
        Button button = (Button) event.getSource();
        String option = button.getText();
        Dimension2D fieldSize = switch(option) {
            case "Small" -> new Dimension2D(MIN_SIDE_WIDTH, MIN_SIDE_HEIGHT);
            case "Medium" -> new Dimension2D((MAX_SIDE_WIDTH - MIN_SIDE_WIDTH) / 3 * 2, (MAX_SIDE_WIDTH - MIN_SIDE_WIDTH) / 3 * 2);
            case "Large" -> new Dimension2D(MAX_SIDE_WIDTH, MAX_SIDE_HEIGHT);
            case "Random" -> new Dimension2D(ThreadLocalRandom.current().nextInt(MIN_SIDE_WIDTH, MAX_SIDE_WIDTH), ThreadLocalRandom.current().nextInt(MIN_SIDE_HEIGHT, MAX_SIDE_HEIGHT));
            default -> throw new IllegalStateException(ILLEGAL_SIDE_BUTTON);
        };
//        int width = switch(option) {
//            case "Small" -> MIN_SIDE_WIDTH;
//            case "Medium" -> (MAX_SIDE_WIDTH - MIN_SIDE_WIDTH) / 3 * 2;
//            case "Large" -> MAX_SIDE_WIDTH;
//            case "Random" -> ThreadLocalRandom.current().nextInt(MIN_SIDE_WIDTH, MAX_SIDE_WIDTH);
//            default -> throw new IllegalStateException(ILLEGAL_SIDE_BUTTON);
//        };
//        int height = switch (option) {
//            case "Small" -> MIN_SIDE_HEIGHT;
//            case "Medium" -> (MAX_SIDE_HEIGHT - MIN_SIDE_HEIGHT) / 3 * 2;
//            case "Large" -> MAX_SIDE_HEIGHT;
//            case "Random" -> ThreadLocalRandom.current().nextInt(MIN_SIDE_HEIGHT, MAX_SIDE_HEIGHT);
//            default -> throw new IllegalStateException(ILLEGAL_SIDE_BUTTON);
//        };
        sideWidth.setText(String.valueOf((int) fieldSize.getWidth()));
        sideHeight.setText(String.valueOf((int) fieldSize.getHeight()));
    }

}
