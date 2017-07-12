package model;

import model.shapes.ConnectedShape;
import model.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov
 * on 05.07.2017.
 */
public class Solution {
    private List<Shape> listShape;
    private List<ConnectedShape> connectedShapeList;
    private Field field;


    public Solution(Field field, Shape shape) {
        listShape = new ArrayList<>();
        listShape.add(shape);
        this.field = field;
    }

    public Solution(Field field) {
        this.field = field;
        listShape = new ArrayList<>();
    }

    public List<Shape> getListShape() {
        return listShape;
    }

    public void setListShape(List<Shape> listShape) {
        this.listShape = listShape;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void generateField() {
        field.fieldClear();
        for (Shape shape : listShape) {
            field.put(shape);
        }
    }
    public boolean connect(Shape first, Shape second) {
        return true; // TODO: 13.07.2017
    }

    public boolean putShape(final Shape shape) {
        return listShape.add(shape);
    }
    @Override
    public String toString() {
        generateField();
        return field.toString();
    }

}
