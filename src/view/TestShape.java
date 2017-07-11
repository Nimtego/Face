package view;

import model.*;

import static model.Direction.UP;


/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class TestShape {
    public static void main(String args[]) throws InterruptedException {
        Shape line = new Line(new Point(1,1), new Point(1,8));
        Solution solution = new Solution(new Field(20,40));
        solution.putShape(line);
        System.out.println(solution);
        for(;;) {
            line.move(UP);
            System.out.println(solution);
        }
    }

}
