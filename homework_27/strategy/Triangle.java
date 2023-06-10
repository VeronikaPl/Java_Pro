package strategy;

import java.util.Objects;

public class Triangle implements GeometricFigure {
    private double side;
    private double height;

    public Triangle(double side, double height) {
        if (side > 0 && height > 0) {
            this.side = side;
            this.height = height;
        } else {
            throw new IllegalArgumentException("Side`s value cannot be less or equal 0");
        }
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateSquare() {
        return 0.5 * getSide() * getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side, side) == 0 && Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side, height);
    }
}
