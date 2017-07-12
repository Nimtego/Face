package model.behavior;

import model.shapes.Shape;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class Rotate implements RotateBehavior {
    private Shape owner;

    public Rotate(Shape owner) {
        this.owner = owner;
    }
    @Override
    public boolean rotate() {
        int tmp = owner.getEndPosition().getX();
        owner.getEndPosition().setX(owner.getEndPosition().getY());
        owner.getEndPosition().setY(tmp);
        return true;
    }
}
