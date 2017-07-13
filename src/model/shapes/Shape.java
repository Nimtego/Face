package model.shapes;


import model.Direction;
import model.behavior.MoveBehavior;
import model.behavior.ReflectBehavior;
import model.behavior.RotateBehavior;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public abstract class Shape {
    private Type type;
    private long id;
    protected Point startingPosition;
    protected Point endPosition;
    private RotateBehavior rotateBehavior;
    private ReflectBehavior reflectBehavior;
    private MoveBehavior moveBehavior;

    public Shape(Type type, Point startingPosition, Point endPosition) {
        this.type = type;
        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
    }

    public Shape(Type type,
                 Point startingPosition,
                 Point endPosition,
                 RotateBehavior rotateBehavior,
                 ReflectBehavior reflectBehavior,
                 MoveBehavior moveBehavior) {
        this.type = type;
        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
        this.rotateBehavior = rotateBehavior;
        this.reflectBehavior = reflectBehavior;
        this.moveBehavior = moveBehavior;
    }
    public abstract Shape copy();

    public final void setRotateBehavior(RotateBehavior rotateBehavior) {// см. setReflectBehavior
        this.rotateBehavior = rotateBehavior;
    }

    public final void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public final void setReflectBehavior(ReflectBehavior reflectBehavior) {
        this.reflectBehavior = reflectBehavior;
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public Point getStartingPosition() {
        return startingPosition;
    }

    public void setEndPosition(Point endPosition) {
        this.endPosition = endPosition;
    }

    public Point getEndPosition() {
        return endPosition;
    }

    public void setStartingPosition(Point startingPosition) {
        this.startingPosition = startingPosition;
    }

    public boolean rotate() { //делегирование поворота фигуры полиморфному обьекту
        return rotateBehavior.rotate();
    }

    public boolean reflect() { //см. rotate
        return reflectBehavior.reflect();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void print() {
        char[][] array = toCharArray();
        for (char[] ch : array) {
            for (char c : ch) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void move(Direction direction) {
        moveBehavior.move(direction);
    }

    public abstract char[][] toCharArray();
}
