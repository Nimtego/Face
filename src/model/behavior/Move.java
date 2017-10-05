package model.behavior;

import model.Direction;
import model.shapes.Point;
import model.shapes.Shape;

/**
 * Created by myasnikov
 * on 05.10.2017.
 */
public class Move implements MoveBehavior {
    @Override
    public void move(Direction direction, Shape shape) {
        switch (direction) {
            case UP:
                up(shape);
                break;
            case DAWN:
                dawn(shape);
                break;
            case LEFT:
                left(shape);
                break;
            case RIGHT:
                right(shape);
                break;
            default:
                break;
        }
    }
    private void up(Shape shape) {
        Point pointStarting = new Point(shape.getStartingPosition().getX() - 1,
                shape.getStartingPosition().getY());
        Point pointEnd = new Point(shape.getEndPosition().getX() - 1,
                shape.getEndPosition().getY());
        shape.setStartingPosition(pointStarting);
        shape.setEndPosition(pointEnd);
    }
    private void dawn(Shape shape) {
        Point pointStarting = new Point(shape.getStartingPosition().getX() + 1,
                shape.getStartingPosition().getY());
        Point pointEnd = new Point(shape.getEndPosition().getX() + 1,
                shape.getEndPosition().getY());
        shape.setStartingPosition(pointStarting);
        shape.setEndPosition(pointEnd);
    }
    private void left(Shape shape) {
        Point pointStarting = new Point(shape.getStartingPosition().getX(),
                shape.getStartingPosition().getY() - 1);
        Point pointEnd = new Point(shape.getEndPosition().getX(),
                shape.getEndPosition().getY() - 1);
        shape.setStartingPosition(pointStarting);
        shape.setEndPosition(pointEnd);
    }
    private void right(Shape shape) {
        Point pointStarting = new Point(shape.getStartingPosition().getX(),
                shape.getStartingPosition().getY() + 1);
        Point pointEnd = new Point(shape.getEndPosition().getX(),
                shape.getEndPosition().getY() + 1);
        shape.setStartingPosition(pointStarting);
        shape.setEndPosition(pointEnd);
    }
}
