package snake.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import snake.field.Direction;
import snake.field.FieldController;

public class Snake {
    public static final int REDUCE_SNAKE_VALUE = 4;
    public static final int BASE_SPEED = 5;
    public static final int HEAD_RADIUS = 11;
    public IntegerProperty length;
    double velocity;
    double stepX;
    double stepY;
    Direction direction = Direction.RIGHT;
    Circle head;
    private final Scene myScene;
    private final GridPane grid;
    double topMargin;
    double bottomMargin;
    double leftMargin;
    double rightMargin;

    public Snake(GridPane grid) {
        this.length = new SimpleIntegerProperty(1);
        this.velocity = BASE_SPEED;
        this.myScene = grid.getScene();
        this.grid = grid;
        this.head = new Circle(HEAD_RADIUS * 2, Color.MEDIUMPURPLE);

    }

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

        this.topMargin = 0;
        this.bottomMargin =  grid.getHeight() - FieldController.PADDING - HEAD_RADIUS * 2;
        this.leftMargin = 0;
        this.rightMargin = grid.getWidth() - FieldController.PADDING - HEAD_RADIUS * 2;

        if (isConflicted()) {
            FieldController.running = false;
            System.out.println("stop");
            System.out.println("x:" + head.getCenterX());
            System.out.println("y:" + head.getCenterY());
            System.out.println(bottomMargin);
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

    private boolean isConflicted() {
        return isClashed() || isAway();
    }

    private boolean isClashed() {
        return false;
    }

    private boolean isAway() {
        return (head.getCenterY() < topMargin) || (head.getCenterY() > bottomMargin) ||
                (head.getCenterX() < leftMargin) || (head.getCenterX() > rightMargin);
    }

    public void speedUp() {
        velocity++;
    }
}
