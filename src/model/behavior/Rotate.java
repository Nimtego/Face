package model.behavior;

import model.Shape;

/**
 * Created by myasnikov
 * on 04.07.2017.
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
