package snake.pickSize;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Dimension2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import snake.baseController.BaseController;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class PickSizeController extends BaseController {
    public static final int MAX_SIDE_WIDTH = 20;
    public static final int MAX_SIDE_HEIGHT = 12;
    public static final int MIN_SIDE_WIDTH = 5;
    public static final int MIN_SIDE_HEIGHT = 5;
    public static final int CELL_SIZE = 50;
    public static final String ILLEGAL_SIDE_BUTTON = "Unexpected value on pickSize button. Contact project owner.";
    public static final String SIDE_NOT_VALID_NUMBER = "Value must be a number greater than 4.";

    @FXML
    public TextField sideWidth;

    @FXML
    public TextField sideHeight;

    public void startGame() throws IOException {
        if (!checkSides()) {
            System.out.println("Invalid sides");
        } else {
            Stage currentStage = getStage(sideHeight);
            int fieldWidth = Integer.parseInt(sideWidth.getText()) * CELL_SIZE;
            int fieldHeight = Integer.parseInt(sideHeight.getText()) * CELL_SIZE;

            Parent root = FXMLLoader.load(getClass().getResource("../field/field.fxml"));
            Scene nextScene = new Scene(root, fieldWidth, fieldHeight);

            currentStage.setScene(nextScene);
        }

    }

    private boolean checkSides() {
        String widthAsString = sideWidth.getText();
        String heightAsString = sideHeight.getText();
        int width;
        int height;
        try {
            width = Integer.parseInt(widthAsString);
            if (width < MIN_SIDE_WIDTH) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            sideWidth.setText(SIDE_NOT_VALID_NUMBER);
            return false;
        }
        try {
            height = Integer.parseInt(heightAsString);
            if (height < MIN_SIDE_HEIGHT) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            sideHeight.setText(SIDE_NOT_VALID_NUMBER);
            return false;
        }

        return true;
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
        sideWidth.setText(String.valueOf((int) fieldSize.getWidth()));
        sideHeight.setText(String.valueOf((int) fieldSize.getHeight()));
    }

}
