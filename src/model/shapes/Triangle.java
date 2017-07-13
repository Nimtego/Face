package model.shapes;

import model.behavior.Move;
import model.behavior.Reflect;
import model.behavior.Rotate;

/**
 * Created by myasnikov
 * on 05.07.2017.
 */
public class Triangle extends Shape {

    public Triangle(Point startingPosition, Point endPosition) {
        super(Type.TRIANGLE, startingPosition, endPosition);
        this.setMoveBehavior(new Move(this));
        this.setReflectBehavior(new Reflect(this));
        this.setRotateBehavior(new Rotate(this));
    }

    @Override
    public Shape copy() {
        return new Triangle(getStartingPosition(), getEndPosition());
    }

    @Override
    public void print() {

    }

    @Override
    public char[][] toCharArray() {
        return new char[0][];
    }
}
