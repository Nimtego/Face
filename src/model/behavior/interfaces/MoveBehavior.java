package model.behavior.interfaces;

import model.constant.Direction;
import model.shapes.collection.Shape;

/**
 * Created by myasnikov
 * on 05.10.2017.
 */
public interface MoveBehavior {
    void move(Direction direction, Shape shape);
}
