package model.shapes;

import model.behavior.Move;
import model.behavior.Reflect;
import model.behavior.Rotate;
import model.utilits.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov
 * on 12.07.2017.
 */
public class ConnectedShape extends Shape{
    private List<Shape> connectList;

    public ConnectedShape() {
        super(Type.CONNECTED, new Point(0, 0), new Point(0,0));
        connectList = new ArrayList<>();
        setRotateBehavior(new Rotate(this));
        setReflectBehavior(new Reflect(this));
        setMoveBehavior(new Move(this));
    }
    public ConnectedShape append(Shape shape) {
        connectList.add(shape.copy());
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
    private void setingCoordinate(char[][] connected) { // TODO: 13.07.2017
        Point endPoint = new Point(connected.length, connected[connected.length].length);
        setStartingPosition(new Point(0, 0));
        setEndPosition(endPoint);
    }
}
