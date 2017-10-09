package model.shapes.collection;

import static model.constant.Constant.EMPTY;
import static model.constant.Constant.SYMBOL;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
class Triangle extends Shape {


    public Triangle(Point startingPosition, Point endPosition) {

        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
    }

    @Override
    public Shape copy() {
        return new Triangle(new Point(getStartingPosition().getX(), getStartingPosition().getY()),
                new Point(getEndPosition().getX(), getEndPosition().getY()));
    }

    @Override
    public char[][] toCharArray() {
        int x = endPosition.getX() * 2;
        int y  = endPosition.getY() - startingPosition.getY();
        char[][] triangle = new char[y][x];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0;  j < triangle[i].length; j++) {
                triangle[i][j] = SYMBOL;
            }
        }
        for (int i = 0; i < triangle.length; i++) {
            for (int k = 0; k < triangle[i].length / 2 - i - 1; k++) {
                triangle[i][k] = EMPTY;
            }
            for (int k = triangle[i].length / 2 + i; k < triangle[i].length; k++) {
                triangle[i][k] = EMPTY;
            }
        }
        return triangle;
    }
}
