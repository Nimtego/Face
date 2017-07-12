package model.shapes;

import model.Direction;
import model.behavior.Move;
import model.behavior.Rotate;

import static model.utilits.Constant.SYMBOL;

/**
 * Created by myasnikov
 * on 05.07.2017.
 */
public class Line extends Shape {

    public Line(Point startingPosition, Point endPosition) {
        super(Type.LINE, startingPosition, endPosition);
        this.setRotateBehavior(new Rotate(this));
        this.setMoveBehavior(new Move(this));
    }

    @Override
    public char[][] toCharArray() {
        int lengthX = 1;
        int lengthY = 1;
        if (startingPosition.getX() == endPosition.getX()) {
            lengthY = Math.abs(endPosition.getY()) - Math.abs(startingPosition.getY());
            //lengthY = Math.abs(startingPosition.getY()) + Math.abs(endPosition.getY());
        }
        else
            lengthX = Math.abs(endPosition.getX()) - Math.abs(startingPosition.getX());
        char[][] array = new char[lengthX][lengthY];
        for (int i = 0; i < lengthX; i++) {
            for (int k = 0; k < lengthY; k++) {
                array[i][k] = SYMBOL;
            }
        }
        return array;
    }
    @Override
    public void move(final Direction direction) {
        getMoveBehavior().move(direction);
    }
}
