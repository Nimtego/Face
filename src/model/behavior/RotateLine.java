package model.behavior;

import model.Shape;

/**
 * Created by myasnikov
 * on 05.07.2017.
 */
public class RotateLine implements RotateBehavior {
    @Override
    public boolean rotate(Shape shape) {
        return true;
    }
}
