package model.behavior;

import model.Shape;
import model.Square;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class RotateSquare implements RotateBehavior {
    @Override
    public boolean rotate(Shape shape) {
        Square square = (Square)shape;
        return square.getOppositePoint().swap();
    }
}
