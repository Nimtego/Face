package model;


import model.behavior.ReflectBehavior;
import model.behavior.RotateBehavior;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public abstract class Shape implements Print, FormSet {
    private Type type;
    protected Point fieldPosition;
    private RotateBehavior rotateBehavior;
    private ReflectBehavior reflectBehavior;

    public Shape(Type type,
                 Point fieldPosition,
                 RotateBehavior rotateBehavior,
                 ReflectBehavior reflectBehavior
                 ) {
        this.fieldPosition = fieldPosition;
        this.rotateBehavior = rotateBehavior;
        this.reflectBehavior = reflectBehavior;
        this.type = type;
    }

    public Point getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(Point fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public RotateBehavior getRotateBehavior() {
        return rotateBehavior;
    }

    public final void setRotateBehavior(RotateBehavior rotateBehavior) {
        this.rotateBehavior = rotateBehavior;
    }

    public ReflectBehavior getReflectBehavior() {
        return reflectBehavior;
    }

    public void setReflectBehavior(ReflectBehavior reflectBehavior) {
        this.reflectBehavior = reflectBehavior;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean rotate() {
        if (rotateBehavior == null)
            return false;
        return rotateBehavior.rotate(this);
    }
}
