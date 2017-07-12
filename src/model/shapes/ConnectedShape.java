package model.shapes;

import model.utilits.GeneratorId;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by myasnikov
 * on 12.07.2017.
 */
public class ConnectedShape {
    private long  serialNumber;
    private List<Shape> connectList;

    public ConnectedShape() {
        connectList = new LinkedList<>();
        serialNumber = GeneratorId.createSerialNumber();
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<Shape> getConnectList() {
        return connectList;
    }

    public void setConnectList(List<Shape> connectList) {
        this.connectList = connectList;
    }
}
