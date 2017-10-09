package model.behavior;

import model.constant.Direction;
import model.behavior.interfaces.MoveBehavior;
import model.behavior.interfaces.ReflectBehavior;
import model.behavior.interfaces.RotateBehavior;
import model.shapes.collection.Shape;

/**
 * Created by myasnikov
 * on 06.10.2017.
 */
public class CapActions implements MoveBehavior, ReflectBehavior, RotateBehavior {
    @Override
    public boolean rotate(Shape shape) {return false;}

    @Override
    public boolean reflect(Shape shape) {return false;}

    @Override
    public void move(Direction direction, Shape shape) {}
}
