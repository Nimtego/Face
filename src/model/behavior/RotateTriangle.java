package model.behavior;

import model.Shape;
import model.Triangle;

/**
 * Created by myasnikov
 * on 05.07.2017.
 */
public class RotateTriangle implements RotateBehavior{
    @Override
    public boolean rotate(Shape shape) {
        Triangle triangle = (Triangle) shape;
      //  return square.getOppositePoint().swap();
        return true;
    }
}
