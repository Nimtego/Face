package model.shapes;
import model.behavior.Move;
import model.behavior.Rotate;

import static model.constant.Constant.EMPTY;
import static model.constant.Constant.SYMBOL;
import static model.shapes.Type.SQUARE;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public class Square extends Shape {

    public Square(int height, int width) {
        this(new Point(0, 0), new Point(height, width));

    }
    public Square(Point startingPosition, Point endPosition) {
        setType(SQUARE);
        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
        this.setRotateBehavior(new Rotate());
        this.setMoveBehavior(new Move());
    }

    @Override
    public Shape copy() {
        return new Square(new Point(getStartingPosition().getX(), getStartingPosition().getY()),
                new Point(getEndPosition().getX(), getEndPosition().getY()));
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