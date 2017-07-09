package model;
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
        this.setRotateBehavior(new Rotate());
    }

    @Override
    public void print() {
        int a, b;
        a = endPosition.getX() - startingPosition.getX();
        b = endPosition.getY() - startingPosition.getY();
        for (int i = 0; i < a + 1; i++) {
            System.out.print(SYMBOL +" ");
        }
        System.out.println();
        for (int i = 0; i < b - 1; i++) {
            System.out.print(SYMBOL);
            for (int k = 0; k < a - 1; k++) {
                System.out.print("  ");
            }
            System.out.println(" " +SYMBOL);
        }
        for (int i = 0; i < a + 1; i++) {
            System.out.print(SYMBOL +" ");
        }
    }

    @Override
    public char[][] toCharArray() {
        StringBuilder sb = new StringBuilder();
        int a, b;
        a = endPosition.getX() - startingPosition.getX();
        b = endPosition.getY() - startingPosition.getY();
        char[][] array = new char[a][b];
        for (int i = 0; i < a; i++) {
            array[0][i] = SYMBOL;
        }
        for (int i = 1; i < b - 1; i++) {
            array[i][0] = SYMBOL;
            for (int k = 1; k < a - 1; k++) {
                array[i][k] = EMPTY;
            }
            array[i][array[0].length - 1] = SYMBOL;
        }
        for (int i = 0; i < a; i++) {
            array[array.length - 1][i] = SYMBOL;
        }
        return array;
    }

    @Override
    public void move() {

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