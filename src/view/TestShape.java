package view;

import model.Field;
import model.Solution;
import model.shapes.ConnectedShape;
import model.shapes.Line;
import model.shapes.Shape;
import model.shapes.Square;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public class TestShape {
    public static void main(String args[]) throws InterruptedException {
        Shape line = new Line(10);
        line.print();
        Shape box = new Square(6, 10);
        box.print();
        line.rotate();
        box.rotate();
        Shape conected = new ConnectedShape().append(line).append(box);
        conected.print();
        System.out.println(conected.getEndPosition());
        conected.rotate();
        conected.print();
        System.out.println(conected.getEndPosition() +"   " +conected.getStartingPosition());
        Solution solution = new Solution(new Field(20, 40));
        solution.putShape(conected);
        solution.putShape(line);
        System.out.println(solution);
    }
}
