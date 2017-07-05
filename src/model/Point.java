package model;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean swap() {
        int tmp;
        tmp = x;
        x = y;
        y = tmp;
        return true;
    }

    public int getMax(Point oppositePoint) {
        int maxX = this.x > oppositePoint.x ? this.x : oppositePoint.x;
        int maxY = this.y > oppositePoint.y ? this.y : oppositePoint.y;
        return maxX > maxY ? maxX : maxY;
    }

    @Override
    public String toString() {
        return "X = " +x +" Y = " +y;
    }

}
