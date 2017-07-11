package model;

/**
 * Created by myasnikov
 * on 05.07.2017.
 */
public class Triangle extends Shape{

    public Triangle(Type type, Point startingPosition, Point endPosition) {
        super(type, startingPosition, endPosition);
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void print() {

    }

    @Override
    public char[][] toCharArray() {
        return new char[0][];
    }
}
