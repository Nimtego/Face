package model.shapes.collection;

import model.behavior.interfaces.RotateBehavior;

/**
 * Created by myasnikov
 * on 05.10.2017.
 */
public class RotateForConnectedShape implements RotateBehavior {

    @Override
    public boolean rotate(Shape shape) {
        for (Shape sh : ((ConnectedShape)shape).getConnectList())
            sh.rotate();
        return true;
    }
}
