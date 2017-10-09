package model.shapes.collection;


import model.constant.Direction;
import model.behavior.CapActions;
import model.behavior.interfaces.MoveBehavior;
import model.behavior.interfaces.ReflectBehavior;
import model.behavior.interfaces.RotateBehavior;
import model.constant.Type;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public abstract class Shape {
    private Type type;
    protected Point startingPosition;
    protected Point endPosition;
    /**
     * Инкапсуляция поведения позволяет менять поведение на лету,
     */
    private RotateBehavior rotateBehavior;
    private ReflectBehavior reflectBehavior;
    private MoveBehavior moveBehavior;

    /**
     * в данном случае экземплярам поведения делегируется поведение
     * выполнения операции. В дальнейшем я могу за счет set методов изменить
     * поведение, например поворота, просто создав новую реализацию интерфейса
     * RotateBehavior.
     * Механизм - "композиция".
     * Паттерн проектирования -"strategy".
     */
    public Shape() {
        CapActions capActions = new CapActions();
        setRotateBehavior(capActions);
        setMoveBehavior(capActions);
        setReflectBehavior(capActions);
    }

    public abstract char[][] toCharArray();

    public abstract Shape copy();

    /**
     * абстрактный метод создания копии объекта.
     * Например для создания соединенных фигур.
     */

    public final void setRotateBehavior(RotateBehavior rotateBehavior) {// см. setReflectBehavior
        this.rotateBehavior = rotateBehavior;
    }

    public final void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public final void setReflectBehavior(ReflectBehavior reflectBehavior) {
        this.reflectBehavior = reflectBehavior;
    }

    public RotateBehavior getRotateBehavior() {
        return rotateBehavior;
    }

    public ReflectBehavior getReflectBehavior() {
        return reflectBehavior;
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public Point getStartingPosition() {
        return startingPosition;
    }

    public Type getType() {
        return type;
    }
    public void setEndPosition(Point endPosition) {
        this.endPosition = endPosition;
    }

    public Point getEndPosition() {
        return endPosition;
    }

    public void setStartingPosition(Point startingPosition) {
        this.startingPosition = startingPosition;
    }

    public final boolean rotate() { //делегирование поворота фигуры полиморфному обьекту
        return rotateBehavior != null && rotateBehavior.rotate(this);
    }

    public final boolean reflect() { //см. rotate
        return reflectBehavior != null && reflectBehavior.reflect(this);
    }

    public final boolean move(Direction direction) {
        if (moveBehavior == null)
            return false;
        moveBehavior.move(direction, this);
        return true;
    }

    public void print() {
        char[][] current = toCharArray();  // Паттерн шаблонный метод. Реализуют субклассы (Template method)
        for (char[] ch : current) {
            for (char c : ch) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void setType(Type type) {
        this.type = type;
    }

}


/*    public Shape(Type type, Point startingPosition, Point endPosition) {
        this.type = type;
        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
    }

    public Shape(Type type,
                 Point startingPosition,
                 Point endPosition,
                 RotateBehavior rotateBehavior,
                 ReflectBehavior reflectBehavior,
                 MoveBehavior moveBehavior) {
        this.type = type;
        this.startingPosition = startingPosition;
        this.endPosition = endPosition;
        this.rotateBehavior = rotateBehavior;
        this.reflectBehavior = reflectBehavior;
        this.moveBehavior = moveBehavior;
    }*/