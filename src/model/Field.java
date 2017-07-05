package model;


/**
 * Created by myasnikov
 * on 05.07.2017.
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
        int x = shape.getFieldPosition().getX();
        int y = shape.getFieldPosition().getY();
        for (int i = 0; i < tmp.length; i++) {
            for (int k = 0; k < tmp[i].length; k++) {
                field[x + i][y + k] = tmp[i][k];
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
}
