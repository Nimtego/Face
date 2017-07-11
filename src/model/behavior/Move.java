package model.behavior;

import model.Direction;
import model.Point;
import model.Shape;

/**
 * Created by nimtego_loc on 11.07.2017.
 */
public class Move implements MoveBehavior {
    private Shape owner;

    public Move(Shape owner) {
        this.owner = owner;
    }
    @Override
    public void move(Direction direction) {
        switch (direction) {
            case UP:
                up();
                break;
            case DAWN:
                dawn();
                break;
            case LEFT:
                left();
                break;
            case RIGHT:
                right();
                break;
            default:   // TODO: 11.07.2017 exception
                break;
        }
    }
    private void up() { // TODO: 11.07.2017 not works 
        Point pointStarting = new Point(owner.getStartingPosition().getY() + 1,
                owner.getStartingPosition().getX());
        Point pointEnd = new Point(owner.getEndPosition().getY() + 1,
                owner.getEndPosition().getX());
        owner.setStartingPosition(pointStarting);
        owner.setEndPosition(pointEnd);
    }
    private void dawn() {
        Point pointStarting = new Point(owner.getStartingPosition().getY() - 1,
                owner.getStartingPosition().getX());
        Point pointEnd = new Point(owner.getEndPosition().getY() - 1,
                owner.getEndPosition().getX());
        owner.setStartingPosition(pointStarting);
        owner.setEndPosition(pointEnd);
    }
    private void left() {
        Point pointStarting = new Point(owner.getStartingPosition().getX() - 1,
                owner.getStartingPosition().getY());
        Point pointEnd = new Point(owner.getEndPosition().getX() - 1,
                owner.getEndPosition().getY());
        owner.setStartingPosition(pointStarting);
        owner.setEndPosition(pointEnd);
    }
    private void right() {
        Point pointStarting = new Point(owner.getStartingPosition().getX() + 1,
                owner.getStartingPosition().getY());
        Point pointEnd = new Point(owner.getEndPosition().getX() + 1,
                owner.getEndPosition().getY());
        owner.setStartingPosition(pointStarting);
        owner.setEndPosition(pointEnd);
    }
}
