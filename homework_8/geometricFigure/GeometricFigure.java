package geometricFigure;

public interface GeometricFigure {
    double getArea();

    static void summAreas(GeometricFigure[] geometricFigures) {
        double areaSumm = 0;
        for (GeometricFigure figure : geometricFigures) {
            areaSumm += figure.getArea();
        }
        System.out.println("Area of Circle + Triangle + Square = " + areaSumm);
    }
}
