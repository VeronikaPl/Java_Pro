package geometricFigure;

public interface GeometricFigure {
    double getArea();

    static double summAreas(GeometricFigure[] geometricFigures) {
        double areaSumm = 0;
        for (GeometricFigure figure : geometricFigures) {
            areaSumm += figure.getArea();
        }
        return areaSumm;
    }
}
