package model;

import model.behavior.RotateLine;

import static model.utilits.Constant.SYMBOL;

/**
 * Created by myasnikov
 * on 05.07.2017.
 */
public class Line extends Shape {
    private Point oppositePoint;

    public Line(Point fieldPosition, Point oppositePoint) {
        super(Type.LINE, fieldPosition, new RotateLine(), null);
        this.oppositePoint = oppositePoint;
    }

    public Point getOppositePoint() {
        return oppositePoint;
    }

    public void setOppositePoint(Point oppositePoint) {
        this.oppositePoint = oppositePoint;
    }

    @Override
    public char[][] toCharArray() {
        int lengthX = 1;
        int lengthY = 1;
        if (fieldPosition.getX() == oppositePoint.getX()) {
            lengthY = Math.abs(fieldPosition.getY()) + Math.abs(oppositePoint.getY());
        }
        else
            lengthX = Math.abs(fieldPosition.getX()) + Math.abs(oppositePoint.getX());
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
}
