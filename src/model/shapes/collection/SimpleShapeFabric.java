package model.shapes.collection;

import model.shapes.NumberIncorrectException;

import static model.constant.Type.*;

/**
 * Created by myasnikov
 * on 06.10.2017.
 */
public class SimpleShapeFabric implements ShapeFabric{

    @Override
    public Shape line(int width) throws NumberIncorrectException {
        if (width == 0)
            throw new NumberIncorrectException("Линия не может быть длинной = " +width);
        Shape line = new Line(new Point(0, 0), new Point(0, width));
        line.setType(LINE);
        line.setMoveBehavior(new Move());
        line.setReflectBehavior(new Reflect());
        line.setRotateBehavior(new Rotate());
        return line;
    }

    @Override
    public Shape square(int height, int width) throws NumberIncorrectException{
        if (height == 0 || width == 0)
            throw new NumberIncorrectException("Ширина или длинна не могут быть = " +(width == 0 ? width : height));
        Shape square = new Square(new Point(0, 0), new Point(height, width));
        square.setType(SQUARE);
        square.setMoveBehavior(new Move());
        square.setReflectBehavior(new Reflect());
        square.setRotateBehavior(new Rotate());
        return square;
    }

    @Override
    public Shape triangle(int bisector) throws NumberIncorrectException {
        if (bisector == 0)
            throw new NumberIncorrectException("Биссектриса не может быть = " +bisector);
        Shape triangle = new Triangle(new Point(0,0), new Point(9,bisector));
        triangle.setType(TRIANGLE);
        triangle.setMoveBehavior(new Move());
        triangle.setReflectBehavior(new Reflect());
        triangle.setRotateBehavior(new RotateTriangle());
        return triangle;
    }

    @Override
    public ConnectedShape connected(Shape... args) throws NumberIncorrectException{
/*        if (args.length == 0)
            throw new NumberIncorrectException("Необходима хотя бы одна форма");*/
        ConnectedShape connected = new ConnectedShape();
        connected.setType(CONNECTED);
        connected.setMoveBehavior(new Move());
        connected.setReflectBehavior(new Reflect());
        connected.setRotateBehavior(new RotateForConnectedShape());
        connected.append(args);
        return connected;
    }
}
