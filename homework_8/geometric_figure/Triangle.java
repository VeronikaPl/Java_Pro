package geometric_figure;

public class Triangle implements GeometricFigure {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double Perimetr() {
        return getA() + getB() + getC();
    }

    @Override
    public double Area() {
        return Math.sqrt(Perimetr() * (Perimetr() - getA()) * (Perimetr() - getB()) * (Perimetr() - getC()));
    }
}
