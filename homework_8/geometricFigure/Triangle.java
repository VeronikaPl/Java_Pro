package geometricFigure;

public class Triangle implements GeometricFigure {
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(double firstSide) {
        this.firstSide = firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(double secondSide) {
        this.secondSide = secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }

    public void setThirdSide(double thirdSide) {
        this.thirdSide = thirdSide;
    }

    public double calculatePerimetr() {
        return getFirstSide() + getSecondSide() + getThirdSide();
    }

    @Override
    public double getArea() {
        return Math.sqrt(calculatePerimetr() * (calculatePerimetr() - getFirstSide()) * (calculatePerimetr() - getSecondSide()) * (calculatePerimetr() - getThirdSide()));
    }
}
