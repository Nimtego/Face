package model.shapes;

import model.behavior.Move;
import model.behavior.Reflect;
import model.behavior.Rotate;

import static model.constant.Constant.EMPTY;
import static model.constant.Constant.SYMBOL;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
    public class Triangle extends Shape {

    public Triangle(Point startingPosition, Point endPosition) {
     //   super(Type.TRIANGLE, startingPosition, endPosition);
        this.setMoveBehavior(new Move());
        this.setReflectBehavior(new Reflect());
        this.setRotateBehavior(new Rotate());
    }

    @Override
    public Shape copy() {
        return new Triangle(new Point(getStartingPosition().getX(), getStartingPosition().getY()),
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
