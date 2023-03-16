package geometric_figure;

public class FigureMain {
    public static void main(String[] args){
        GeometricFigure[] geometricFigures = {
                new Circle(3),
                new Triangle(3,4,5),
                new Square(4)
        };
        double area_S = 0;
        for (GeometricFigure figure: geometricFigures) {
            area_S += figure.Area();
        }
        System.out.println("Area of Circle + Triangle + Square = " + area_S);
    }
}
