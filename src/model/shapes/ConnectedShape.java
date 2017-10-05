package model.shapes;

import model.behavior.Move;
import model.behavior.Reflect;
import model.behavior.RotateForConnectedShape;
import model.constant.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static model.shapes.Type.CONNECTED;

/**
 * Created by myasnikov
 * on 05.10.2017.
 */
public class ConnectedShape extends Shape {
    private List<Shape> connectList;

    public ConnectedShape() {
        setType(CONNECTED);
        this.startingPosition = new Point(0, 0);
        this.endPosition = new Point(0,0);
        setRotateBehavior(new RotateForConnectedShape());
        setMoveBehavior(new Move());
        setReflectBehavior(new Reflect());
        connectList = new ArrayList<>();
    }
    public ConnectedShape append(Shape shape) {
        Shape copyShape = shape.copy();
        connectList.add(copyShape);
        return this;
    }
    public ConnectedShape append(Shape ... args) {
        Collections.addAll(connectList, args);
        return this;
    }
    @Override
    public Shape copy() { // TODO: 13.07.2017
        return null;
    }

    @Override
    public char[][] toCharArray() {
        char[][] arrayConnected = generateSize();
        int centerConA = arrayConnected.length / 2;
        for (int i = 0; i < arrayConnected.length; i++) {
            for (int k = 0; k < arrayConnected[i].length; k++) {
                arrayConnected[i][k] = Constant.EMPTY;
            }
        }
        for (Shape shape : connectList) {
            char[][] tmpArray = shape.toCharArray();
            int centerTmpA = tmpArray.length / 2;
            for (int i = centerConA - centerTmpA, a = 0; a < tmpArray.length; i++) {
                for (int k = arrayConnected[i].length / 2 - tmpArray[centerTmpA].length / 2, b = 0;
                                                        b < tmpArray[a].length; k++) {
                    if (tmpArray[a][b] == Constant.SYMBOL) {
                        arrayConnected[i][k] = tmpArray[a][b];
                    }
                    b++;
                }
                a++;
            }
        }
        endPosition = new Point(arrayConnected.length, arrayConnected[0].length);
        return arrayConnected;
    }
    private char[][] generateSize() {
        int x = 0;
        int y = 0;
        for (Shape shape : connectList) {
            char[][] tmp = shape.toCharArray();
            x = x < tmp.length ? tmp.length : x;
            y = y < tmp[0].length ? tmp[0].length : y;
        }
        return new char[x][y];
    }

    public List<Shape> getConnectList() {
        return connectList;
    }

    public void setConnectList(List<Shape> connectList) {
        this.connectList = connectList;
    }
    public void clearList() {
        connectList = new ArrayList<>();
    }
}
