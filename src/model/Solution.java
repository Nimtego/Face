package model;

import model.shapes.Shape;
import view.ObserverWin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public class Solution implements ObservableWin {
    private List<Shape> listShape;
    private Field field;
    private List<ObserverWin> observerWinList;

    public Solution(Field field) {
        this.field = field;
        listShape = new ArrayList<>();
        observerWinList = new ArrayList<>();
    }

    public Solution(int x, int y) {
        this(new Field(x, y));
    }

    public void generateField() {
        field.fieldClear();
        for (Shape shape : listShape) {
            field.put(shape);
        }
    }

    public Solution putShape(final Shape shape) {
        listShape.add(shape);
        return this;
    }
    @Override
    public String toString() {
        generateField();
        return field.toString();
    }

    @Override
    public void setObserver(ObserverWin observer) {
        this.observerWinList.add(observer);
    }

    @Override
    public void removeObserver(ObserverWin observerWin) {
        this.observerWinList.remove(observerWin);
    }

    @Override
    public void update() {
        for (ObserverWin ow : observerWinList)
            ow.update();
    }
}
