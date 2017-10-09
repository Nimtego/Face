package model.shapes.collection;

import static model.constant.Constant.EMPTY;
import static model.constant.Constant.SYMBOL;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
class Square extends Shape {

    public Square(Point startingPosition, Point endPosition) {
        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
    }

    @Override
    public Shape copy() {
        Square square = new Square(new Point(getStartingPosition().getX(), getStartingPosition().getY()),
                new Point(getEndPosition().getX(), getEndPosition().getY()));
        square.setRotateBehavior(getRotateBehavior());
        square.setReflectBehavior(getReflectBehavior());
        square.setMoveBehavior(getMoveBehavior());
        square.setType(getType());
        return square;
    }

    @Override
    public char[][] toCharArray() {
        int a, b;
        a = endPosition.getX() - startingPosition.getX() + 1;
        b = endPosition.getY() - startingPosition.getY() + 1;
        char[][] array = new char[a][b];
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                if (i == 0 || i + 1 == a) {
                    array[i][k] = SYMBOL;
                    continue;
                }
                array[i][k] = EMPTY;
                array[i][0] = SYMBOL;
                array[i][b - 1] = SYMBOL;
            }
        }
        return array;
    }

}