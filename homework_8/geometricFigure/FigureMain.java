package geometricFigure;

public class FigureMain {
    public static void main(String[] args) {
        GeometricFigure[] geometricFigures = {
                new Circle(3),
                new Triangle(3, 4, 5),
                new Square(4)
        };
        System.out.println("Area of Circle + Triangle + Square = " + GeometricFigure.summAreas(geometricFigures));
    }
}
