package model.shapes;

import java.util.List;

/**
 * Created by myasnikov
 * on 12.07.2017.
 */
public class ConnectedShape extends Shape{
    private List<Shape> connectList;

    public ConnectedShape(Point startingPosition, Point endPosition) { // TODO: 13.07.2017  
        super(Type.CONNECTED, startingPosition, endPosition);
    }

    public List<Shape> getConnectList() {
        return connectList;
    }

    public void setConnectList(List<Shape> connectList) {
        this.connectList = connectList;
    }

    @Override
    public char[][] toCharArray() {
        return new char[0][];
    }
}
