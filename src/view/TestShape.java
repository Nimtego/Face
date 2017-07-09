package view;

import model.*;

/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class TestShape {
    public static void main(String args[]) throws InterruptedException {
        Shape line = new Line(new Point(1,1), new Point(1,8));
        Solution solution = new Solution(new Field(20,20));
        solution.putShape(line);
        for (int i = 0; i < 10; i++) {
            System.out.println(solution);
            line.rotate();
        }
        Shape line2 = new Line(new Point(5,5), new Point(5, 10));
        solution.putShape(line2);
        System.out.println(solution);
        Shape square = new Square(new Point(3,3), new Point(15,15));
        solution.putShape(square);
        for (int i = 0; i < 100; i++) {
            line.rotate();
            line2.rotate();
            square.rotate();
            System.out.println(solution);
            Thread.sleep(500);
        }
/*        Shape square = new Square(new Point(5,4), new Point(5, 8));
        solution.putShape(square);
        solution.generateField();
        System.out.println(solution);*/
    }

}
