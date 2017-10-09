package model.shapes.collection;


import model.shapes.NumberIncorrectException;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public interface ShapeFabric {
    Shape line(int width) throws NumberIncorrectException;
    Shape square(int height, int width) throws NumberIncorrectException;
    Shape triangle(int bisector) throws NumberIncorrectException;
    ConnectedShape connected(Shape ... args) throws NumberIncorrectException;
}
