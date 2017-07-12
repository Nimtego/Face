package model.shapes;
import model.Direction;
import model.behavior.Move;
import model.behavior.Rotate;

import static model.utilits.Constant.EMPTY;
import static model.utilits.Constant.SYMBOL;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class Square extends Shape {

    public Square(Point startingPosition, Point endPosition) {
        super(Type.SQUARE, startingPosition, endPosition);
        this.setRotateBehavior(new Rotate(this));
        this.setMoveBehavior(new Move(this));
    }

    @Override
    public void move(Direction direction) {
        getMoveBehavior().move(direction);
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