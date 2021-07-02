package snake.model;

import javafx.beans.property.IntegerProperty;

public class Snake {
    public static int REDUCE_SNAKE_VALUE = 4;
    public IntegerProperty length;

    public void add() {
        length.add(1);
    }

    public void reduce() {
        if (length.get() <= REDUCE_SNAKE_VALUE) {
            length.setValue(1);
        } else {
            length.subtract(REDUCE_SNAKE_VALUE);
        }
    }
}
