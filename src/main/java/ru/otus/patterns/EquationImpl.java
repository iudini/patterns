package ru.otus.patterns;

public class EquationImpl implements Equation {
    private final static double DELTA = 0.001;

    @Override
    public double[] resolveSquare(double a, double b, double c) {
        if (Math.abs(a) < DELTA
                || Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)
                || Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
            throw new IllegalArgumentException();
        }

        double d = (b * b) - (4d * a * c);

        if (d < -DELTA) {
            return new double[0];
        } else if (d > DELTA) {
            double x1 = ((-b) + Math.sqrt(d)) / (2 * a);
            double x2 = ((-b) - Math.sqrt(d)) / (2 * a);
            return new double[]{x1, x2};
        } else {
            double x = (-b) / (2 * a);
            return new double[]{x};
        }
    }
}
