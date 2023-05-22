package strategy;

public class SquareCalculate {
    private GeometricFigure geometricFigure;

    public GeometricFigure getGeometricFigure() {
        return geometricFigure;
    }

    public void setGeometricFigure(GeometricFigure geometricFigure) {
        this.geometricFigure = geometricFigure;
    }

    public double calculateFigureSquare() {
        return geometricFigure.calculateSquare();
    }
}
