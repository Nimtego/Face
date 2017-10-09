package model.constant;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public enum Direction {
    UP(4, 4),
    RIGHT(4, 4),
    DAWN(4, 4),
    LEFT(4, 4);
    private int first;
    private int second;

    Direction(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
