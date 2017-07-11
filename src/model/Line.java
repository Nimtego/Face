package model;

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
            lengthY = Math.abs(startingPosition.getY()) + Math.abs(endPosition.getY());
        }
        else
            lengthX = Math.abs(startingPosition.getX()) + Math.abs(endPosition.getX());
        char[][] array = new char[lengthX][lengthY];
        for (int i = 0; i < lengthX; i++) {
            for (int k = 0; k < lengthY; k++) {
                array[i][k] = SYMBOL;
            }
        }
        return array;
    }

    @Override
    public void print() {
        char[][] array = toCharArray();
        for (char[] ch : array) {
            for (char c : ch) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    @Override
    public void move(final Direction direction) {

    }
}
