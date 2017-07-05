package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov
 * on 05.07.2017.
 */
public class Solution {
    private List<Shape> listShape;
    private Field field;

    public Solution(Field field, Shape shape) {
        listShape = new ArrayList<>();
        listShape.add(shape);
        this.field = field;
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
        for (Shape shape : listShape) {
            field.put(shape);
        }
    }

    @Override
    public String toString() {
        return field.toString();
    }
}
