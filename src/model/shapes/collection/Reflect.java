package model.shapes.collection;

import model.behavior.interfaces.ReflectBehavior;
import model.shapes.collection.Shape;

/**
 * Created by myasnikov
 * on 05.10.2017.
 */
public class Reflect implements ReflectBehavior {

    @Override
    public boolean reflect(Shape shape) {
        int y = shape.getEndPosition().getY();
        System.out.println(shape.getEndPosition());
        shape.getEndPosition().setY(y - y * 2);
        System.out.println(shape.getEndPosition());
        return false;
    }
}
