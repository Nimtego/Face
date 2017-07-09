package model;


import model.behavior.ReflectBehavior;
import model.behavior.RotateBehavior;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public abstract class Shape implements Print {
    private Type type;
    protected Point startingPosition;
    protected Point endPosition;
    private RotateBehavior rotateBehavior;
    private ReflectBehavior reflectBehavior;

    public Shape(Type type, Point startingPosition, Point endPosition) {
        this.type = type;
        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
    }

    public Shape(Type type,
                 Point startingPosition,
                 Point endPosition,
                 RotateBehavior rotateBehavior,
                 ReflectBehavior reflectBehavior) {
        this.type = type;
        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
        this.rotateBehavior = rotateBehavior;
        this.reflectBehavior = reflectBehavior;
    }
    
    public final void setRotateBehavior(RotateBehavior rotateBehavior) {// см. setReflectBehavior
        this.rotateBehavior = rotateBehavior;
    }
    
    public boolean rotate() { //делегирование поворота фигуры полиморфному обьекту
        return rotateBehavior.rotate(this);
    }
    public boolean reflect() { //см. rotate
        return reflectBehavior.reflect(this);
    }
    public abstract void move();
    public abstract char[][] toCharArray();

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
}
