package model.behavior;

import model.Shape;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class Reflect implements ReflectBehavior {
    private Shape owner;

    public Reflect(Shape owner) {
        this.owner = owner;
    }

    @Override
    public boolean reflect() {
        return false;
    }
}
