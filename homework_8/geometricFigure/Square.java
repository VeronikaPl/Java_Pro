package geometricFigure;

public class Square implements GeometricFigure {
    private double sideSquare;

    public Square(double sideSquare) {
        this.sideSquare = sideSquare;
    }

    public double getSideSquare() {
        return sideSquare;
    }

    public void setSideSquare(double sideSquare) {
        this.sideSquare = sideSquare;
    }

    @Override
    public double getArea() {
        return Math.pow(getSideSquare(), 2);
    }
}
