package view;

import model.*;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class TestShape {
    public static void main(String args[]) {
        Solution solution = new Solution(new Field(20, 20), new Line(new Point(1,1), new Point(1,8)));
        solution.generateField();
        System.out.println(solution);
    }

}
