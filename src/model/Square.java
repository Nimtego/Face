package model;
import model.behavior.RotateSquare;

import static model.utilits.Constant.SYMBOL;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class Square extends Shape {
    private Point oppositePoint;

    public Square(Point fieldPosition, Point oppositePoint) {
        super(Type.SQUARE, fieldPosition, new RotateSquare(), null);
        this.oppositePoint = oppositePoint;
    }

    public Point getOppositePoint() {
        return oppositePoint;
    }

    public void setOppositePoint(Point oppositePoint) {
        this.oppositePoint = oppositePoint;
    }

    @Override
    public void print() {
        int a, b;
        a = oppositePoint.getX() - fieldPosition.getX();
        b = oppositePoint.getY() - fieldPosition.getY();
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
        int max = fieldPosition.getMax(oppositePoint);
        char[][] array = new char[max][max];

        return new char[max][max];
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