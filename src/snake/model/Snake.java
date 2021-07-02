package snake.model;

import javafx.beans.property.IntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import snake.field.Direction;

public class Snake {
    public static int REDUCE_SNAKE_VALUE = 4;
    public IntegerProperty length;
    double velocity = 3;
    double stepX;
    double stepY;
    Direction direction = Direction.RIGHT;

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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        switch (direction) {
            case UP -> moveUp();
            case DOWN -> moveDown();
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
        }
    }

    protected void moveUp() {
        stepX = head.getCenterX();
        stepY = head.getCenterY() - velocity;
        actualMove();
    }

    protected void moveDown() {
        stepX = head.getCenterX();
        stepY = head.getCenterY() + velocity;
        actualMove();
    }

    protected void moveLeft() {
        stepX = head.getCenterX() - velocity;
        stepY = head.getCenterY();
        actualMove();
    }

    protected void moveRight() {
        stepX = head.getCenterX() + velocity;
        stepY = head.getCenterY();
        actualMove();
    }

    private void actualMove() {
        head.setCenterX(stepX);
        head.setTranslateX(stepX);
        head.setCenterY(stepY);
        head.setTranslateY(stepY);
    }

    private boolean isClashed() {
        return false;
    }
}
