package model.behavior;

import model.Direction;
import model.shapes.Shape;

/**
 * Created by myasnikov
 * on 05.10.2017.
 */
public interface MoveBehavior {
    void move(Direction direction, Shape shape);
}
