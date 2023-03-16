package geometric_figure;

public class Square implements GeometricFigure {
    private double a;

    public Square(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double Area() {
        return Math.pow(getA(), 2);
    }
}
