package model;


import model.shapes.Shape;

import static model.constant.Constant.EMPTY;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public class Field {
    private char[][] field;

    public Field(int x, int y) {
        if (x > 0 && y > 0)
            this.field = new char[x][y];
        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field[i].length; k++) {
                field[i][k] = '.';
            }
        }
    }

    public char[][] getField() {
        return field;
    }

    public void setField(char[][] field) {
        this.field = field;
    }

    public void put(Shape shape) {
        char[][] tmp = shape.toCharArray();
        int x = shape.getStartingPosition().getX();
        int y = shape.getStartingPosition().getY();
        for (int i = 0; i < tmp.length; i++) {
            if (x + i >= 0 && x + i <= field.length - 1) {
                for (int k = 0; k < tmp[i].length; k++) {
                    if (y + k >= 0 && y + k <= field[k].length - 1) {
                        if (field[x + i][y + k] == EMPTY)
                            field[x + i][y + k] = tmp[i][k];
                    }
                }
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] aField : field) {
            for (char anAField : aField) {
                sb.append(anAField);
            }
            sb.append("\n");
        }
        return String.valueOf(sb);
    }
    public void fieldClear() {
        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field[i].length; k++) {
                field[i][k] = EMPTY;
            }
        }
    }

}
