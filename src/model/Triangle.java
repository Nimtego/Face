package model;

import model.behavior.ReflectBehavior;
import model.behavior.RotateBehavior;

/**
 * Created by myasnikov
 * on 05.07.2017.
 */
public class Triangle extends Shape{

    public Triangle(Type type, Point fieldPosition, RotateBehavior rotateBehavior, ReflectBehavior reflectBehavior) {
        super(type, fieldPosition, rotateBehavior, reflectBehavior);
    }

    @Override
    public void move() {

    }

    @Override
    public void print() {

    }

    @Override
    public char[][] toCharArray() {
        return new char[0][];
    }
}
