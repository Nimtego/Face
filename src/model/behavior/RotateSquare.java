package model.behavior;

import model.Line;
import model.Shape;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class RotateSquare implements RotateBehavior {
    @Override
    public boolean rotate(Shape shape) {
        Line square = (Line)shape;
        return square.getOppositePoint().swap();
    }
}
