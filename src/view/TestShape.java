package view;

import model.Direction;
import model.Field;
import model.Solution;
import model.shapes.*;


/**
 * Created by myasnikov
 * on 04.07.2017.
 */
public class TestShape {
    public static void main(String args[]) throws InterruptedException {
/*        Shape line = new Line(new Point(1,1), new Point(1,8));
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
        }*/
        Shape line = new Line(new Point(1,1), new Point(1,8));
        Shape square = new Square(new Point(4,4), new Point(6, 39));
        square.print();
        Shape square2 = new Square(new Point(6,6), new Point(32, 26));
        square2.print();
        Solution solution1 = new Solution(new Field(40, 340));
        solution1.putShape(square).putShape(square2).putShape(line);
        System.out.println(solution1);
        ConnectedShape connected = new ConnectedShape();
        connected.append(square).append(square2).append(line);
        solution1.putShape(connected);
        connected.print();
        System.out.println("\n\n\n");
        System.out.println(solution1);
        for (int i = 0; i < 140; i++) {
            connected.move(Direction.RIGHT);
            line.rotate();
            System.out.println(solution1);
            Thread.sleep(150);
        }
    }

}
