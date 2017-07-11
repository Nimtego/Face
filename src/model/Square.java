package model;
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
    public void print() {
        int a, b;
        a = endPosition.getX() - startingPosition.getX();
        b = endPosition.getY() - startingPosition.getY();
        for (int i = 0; i < a + 1; i++) {
            System.out.print(SYMBOL + " ");
        }
        System.out.println();
        for (int i = 0; i < b - 1; i++) {
            System.out.print(SYMBOL);
            for (int k = 0; k < a - 1; k++) {
                System.out.print("  ");
            }
            System.out.println(" " + SYMBOL);
        }
        for (int i = 0; i < a + 1; i++) {
            System.out.print(SYMBOL + " ");
        }
    }

    @Override
    public void move(Direction direction) {

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

/**       double diagonalLength = Math.ceil(Math.sqrt((Math.pow((double)oppositePoint.getX() - fieldPosition.getX(), 2)) +
                (Math.pow((double)oppositePoint.getX() - fieldPosition.getX(), 2))));
        System.out.println(diagonalLength);
        int party = (int)Math.ceil(diagonalLength / Math.sqrt(2));
        System.out.println(party);
        for (int i = 0; i < party; i++) {
            System.out.print("* ");
        }
        System.out.println();
        for (int i = 0; i < party - 2; i++) {
            System.out.print("*");
            for (int k = 0; k < party - 2; k++) {
                System.out.print("  ");
            }
            System.out.println(" *");
        }
        for (int i = 0; i < party; i++) {
            System.out.print("* ");
        }**/