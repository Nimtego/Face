package model.shapes.collection;

import static model.constant.Constant.SYMBOL;

/**
 * Created by myasnikov
 * on 05.10.2017.
 */
class Line extends Shape {

    public Line(Point startingPosition, Point endPosition) {
        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
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
    public Shape copy() {
        return new Line(new Point(getStartingPosition().getX(), getStartingPosition().getY()),
                              new Point(getEndPosition().getX(), getEndPosition().getY()));
    }

}
