package org.homework_28.Math;

import org.homework_28.Math.MathLibrary;

public class MathOperations implements MathLibrary {

    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (a == 0 || b == 0) {
            throw new ArithmeticException("Number cannot be divided by 0");
        }
        return a / b;
    }

    @Override
    public double pow(double a, int n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= a;
        }
        return result;
    }

    @Override
    public double max(double a, double b) {
        return (a >= b) ? a : b;
    }

    @Override
    public double min(double a, double b) {
        return (a <= b) ? a : b;
    }
}
