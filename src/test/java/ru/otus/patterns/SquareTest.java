package ru.otus.patterns;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
    private final Equation equation = new EquationImpl();

    @DisplayName("x^2+1 = 0")
    @Test
    public void x2Plus1Test() {
        double[] doubles = equation.resolveSquare(1d, 0d, 1d);

        assertEquals(doubles.length, 0);
    }

    @DisplayName("x^2-1 = 0")
    @Test
    public void x2Minus1Test() {
        double[] doubles = equation.resolveSquare(1d, 0d, -1d);

        assertEquals(doubles.length, 2);
        assertEquals(doubles[0], 1d);
        assertEquals(doubles[1], -1d);
    }

    @DisplayName("x^2+2x+1 = 0")
    @Test
    public void x2Plus2xPlus1Test() {
        double[] doubles = equation.resolveSquare(1d, 2d, 1d);

        assertEquals(doubles.length, 1);
        assertEquals(doubles[0], -1d);
    }

    @DisplayName("'a' cannot be == 0")
    @Test
    public void aIs0Test() {
        assertThrows(IllegalArgumentException.class, () -> equation.resolveSquare(0d, 2d, 1d));
    }

    @DisplayName("Not a number")
    @Test
    public void notANumberTest() {
        assertThrows(IllegalArgumentException.class, () -> equation.resolveSquare(Double.NaN, 1d, 0d));
        assertThrows(IllegalArgumentException.class, () -> equation.resolveSquare(1d, Double.NaN, 1d));
        assertThrows(IllegalArgumentException.class, () -> equation.resolveSquare(1d, 1d, Double.NaN));
    }

    @DisplayName("Infinity")
    @Test
    public void infinityTest() {
        assertThrows(IllegalArgumentException.class, () -> equation.resolveSquare(Double.POSITIVE_INFINITY, 1d, 0d));
        assertThrows(IllegalArgumentException.class, () -> equation.resolveSquare(1d, Double.NEGATIVE_INFINITY, 0d));
        assertThrows(IllegalArgumentException.class, () -> equation.resolveSquare(1d, 0d, Double.NEGATIVE_INFINITY));
    }
}
