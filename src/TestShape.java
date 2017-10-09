import model.Field;
import model.Solution;
import model.shapes.NumberIncorrectException;
import model.shapes.collection.ConnectedShape;
import model.shapes.collection.Shape;
import model.shapes.collection.ShapeFabric;
import model.shapes.collection.SimpleShapeFabric;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public class TestShape {
    public static void main(String args[]) throws InterruptedException, NumberIncorrectException {
/**
 * ShapeFabric - шаблонная фабрика позволяет легко получать необходимые
 * реализации объектов Shape. Позволяет нам инициализировать экземпляры
 * по определенным правилам. В данном случае используется SimpleShapeFabric()
 */

        ShapeFabric shapeFabric = new SimpleShapeFabric();
        Shape line = shapeFabric.line(8);
        Shape square = shapeFabric.square(5, 10);
        line.print();
        square.print();
/**
 * Создаем экземпляр класс Solution, поместив экземпляр класса Field,
 * данный класс является контейнером для объектов класса Shape
 * класс Field - ограниченный экран new Field(30, 50)
 */

        Field field = new Field(30, 80);
        Solution solution = new Solution(field);
/**
 * Добавление фигур в класс Solution
 * метод putShape(Shape shape); возвращает себя же, это позволяет
 * делать удобные цепочки добавлений
 */

        Shape square2 = shapeFabric.square(5, 10);
        solution.putShape(line).putShape(square2).putShape(square);
/**
 * Разворачиваем уже созданную line (abstract методом rotate(),
 * аналог virtual, в супер классе Shape) и создаем еще одну
 * а после на их основе создаем объект ConnectedShape наследник Shape
 * в поле которого есть List<Shape> connectedList;
 * получаем новую форму ("крест")
 * добавляем его в поле
 */

        line.rotate();
        Shape line2 = shapeFabric.line(8);
        ConnectedShape connectedShapeCross = shapeFabric.connected();
/**
 * Метод append() в классе наследнике перегружен на три разных аргумента
 *      public ConnectedShape append(Shape shape) {return this}
 *      public ConnectedShape append(Shape ... args) {return this}
 *      public ConnectedShape append(List<Shape> collections) {return this}
 * при этом возвращает самого себя, позволяя делать удобные цепочки добавлений элементов
 */

        connectedShapeCross.append(line).append(line2);
        // или например connectedShape.append(line, line2);
        solution.putShape(connectedShapeCross);
        System.out.println(solution);
/**
 * Добавляем еще несколько фигур
 * строка громоздкая и не совсем возможно понятная.
 * лучше делать так:
 *          Shape square3 = shapeFabric.square(4,4);
 *          ConnectedShape connectedShape1 = shapeFabric.connected(shapeFabric.square(3,3), shapeFabric.square(7,7));
 *          solution.putShape(square3).putShape(connectedShape1);
 * еще одна причина мы можем управлять например square3.move(DAWN);
 * в варианте ниже у нас нет доступа к экземпляру.
 */

        solution.putShape(shapeFabric.square(4, 4)).putShape(shapeFabric.connected()
                .append(shapeFabric.square(3, 3), shapeFabric.square(7, 7)));
        System.out.println(solution);
/**
 * Создадим еще одну составную фигуру
 * поместим ее в solution
 * и начнем ее перемещать вправо
 * а ранее созданную фигуру "крест" из двух линий вниз
 * приостановим поток на 350 мс для визуализации процесса
 * соединенные фигуры больше не как не связаны с фигурами из которых были сделаны
 * поэтому и перемещаются независимо от них
 */
        Solution solutionTest2 = new Solution(new Field(30, 80));

        ConnectedShape connectedShape1 = shapeFabric.connected(shapeFabric.square(3, 3), shapeFabric.square(7, 7));

        solutionTest2.putShape(connectedShape1)
                     .putShape(connectedShapeCross)
                     .putShape(square)
                     .putShape(line)
                     .putShape(square2);
        /**
         * Временно за комитенно для тэста exception
         * ->
         */

/*        for (int i = 0; i < 80; i++) {
            if (i % 4 == 0)
                square.move(DAWN);
            square.move(RIGHT);
            if (i % 3 == 0) {
                square2.move(RIGHT);
            }
            square2.move(DAWN);
            if (i % 2 == 0)
                line.move(DAWN);

            line.move(RIGHT);
            connectedShapeCross.move(DAWN);
            connectedShape1.rotate();
            connectedShape1.move(RIGHT);
            System.out.println(solutionTest2);
            Thread.sleep(350);
        }*/

        /**
         * Протестируем исключительные ситуации
         * выше в коде я специально выкидывал его дальше чтобы улучшить читабельность
         * ниже метод сам обрабатывает исключительную ситуацию
         */

        Shape shape0 = testException(0);
        try {
            shape0.print();
        } catch (NullPointerException e) {
            System.out.println("shape23 == null");
        }
        Shape shape5 = testException(5);
        shape5.print();
    }




    private static Shape testException(final int test) {
        ShapeFabric shapeFabric = new SimpleShapeFabric();
        Shape line = null;
        try {
            line = shapeFabric.line(test);
        } catch (NumberIncorrectException e) {
            System.out.println(e.getMessage());
        }
        return line;
    }
}
