package model.shapes.collection;

import model.behavior.interfaces.RotateBehavior;
import model.shapes.collection.Shape;

/**
 * Created by myasnikov
 * on 05.10.2017.
 */
public class Rotate implements RotateBehavior {
    @Override
    public boolean rotate(Shape shape) {
        int tmp = shape.getEndPosition().getX();
        shape.getEndPosition().setX(shape.getEndPosition().getY());
        shape.getEndPosition().setY(tmp);
        return true;
    }
}
