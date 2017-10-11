package model.shapes.collection;

/**
 * Created by nimtego_loc on 11.10.2017.
 */
public class Trapezoid extends Shape{
    private Point endBasePosition;
    @Override
    public char[][] toCharArray() {
        char trapezoid[][] = new char[endBasePosition.getY()][endBasePosition.getX()];
        for (int i = 0; i < trapezoid.length; i++) {
            for (int j = 0; j < trapezoid[i].length; j++) {

            }
        }
        return new char[0][];
    }

    @Override
    public Shape copy() {
        return null;
    }

    public Point getEndBasePosition() {
        return endBasePosition;
    }

    public void setEndBasePosition(Point endBasePosition) {
        this.endBasePosition = endBasePosition;
    }
}
