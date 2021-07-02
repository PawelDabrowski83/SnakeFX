package snake.model;

import javafx.beans.property.IntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Snake {
    public static int REDUCE_SNAKE_VALUE = 4;
    public IntegerProperty length;
    Circle head = new Circle(22, Color.MEDIUMPURPLE);

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

    public Circle getHead() {
        return head;
    }
}
