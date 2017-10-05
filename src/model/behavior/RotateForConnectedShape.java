package model.behavior;

import model.shapes.ConnectedShape;
import model.shapes.Shape;

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
