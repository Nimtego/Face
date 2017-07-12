package view;

import model.*;
import model.shapes.Line;
import model.shapes.Point;
import model.shapes.Shape;
import model.shapes.Square;

import static model.Direction.*;


/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class TestShape {
    public static void main(String args[]) throws InterruptedException {
        Shape line = new Line(new Point(1,1), new Point(1,8));
        Shape square = new Square(new Point(4,4), new Point(6, 10));
        Solution solution = new Solution(new Field(20,40));
        solution.putShape(line);
        solution.putShape(square);
        System.out.println(solution);
        line.rotate();
        for(int i = 0; i < 5; i++) {
            line.move(RIGHT);
            square.move(RIGHT);
            System.out.println(solution);
        }
        line.move(DAWN);
        System.out.println(solution);
        for(int i = 0; i < 5; i++) {
            line.move(LEFT);
            square.move(RIGHT);
            System.out.println(solution);
        }
    }

}
