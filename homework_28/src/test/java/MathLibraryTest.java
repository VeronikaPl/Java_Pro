import org.homework_28.Math.MathLibrary;
import org.homework_28.Math.MathOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathLibraryTest {
    private MathLibrary mathLibrary;

    @BeforeEach
    public void setup() {
        this.mathLibrary = new MathOperations();
    }

    @AfterEach
    public void tearDown() {
        this.mathLibrary = null;
    }

    @Test
    public void whenPerformSumOperationThenReturnCorrectResult() {
        double a = 10;
        double b = 10;

        double result = this.mathLibrary.sum(a, b);
        assertEquals(20, result, "Actual result doesn`t match to expected");
    }

    @Test
    public void whenPerformSubtractOperationThenReturnCorrectResult() {
        double a = 10;
        double b = 10;

        double result = this.mathLibrary.subtract(a, b);
        assertEquals(0, result, "Actual result doesn`t match to expected");
    }

    @Test
    public void whenPerformMultiplyOperationThenReturnCorrectResult() {
        double a = 10;
        double b = 10;

        double result = this.mathLibrary.multiply(a, b);
        assertEquals(100, result, "Actual result doesn`t match to expected");
    }

    @Test
    public void whenPerformDivideOperationThenReturnCorrectResult() {
        double a = 10;
        double b = 10;

        double result = this.mathLibrary.divide(a, b);
        assertEquals(1, result, "Actual result doesn`t match to expected");
    }

    @Test
    public void whenDividedByZeroThenThrowException() {
        double a = 10;
        double b = 0;

        ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> {
                    this.mathLibrary.divide(a, b);
                });
        assertNotNull(exception);
        assertEquals("Number cannot be divided by 0", exception.getMessage());
    }

    @Test
    public void whenPerformPowOperationThenReturnCorrectResult() {
        double a = 2;
        int n = 3;

        double result = this.mathLibrary.pow(a, n);
        assertEquals(8, result, "Actual result doesn`t match to expected");
    }

    @Test
    public void whenExponentIsZeroThenPowResultIsOne() {
        double a = 2;
        int n = 0;

        double result = this.mathLibrary.pow(a, n);
        assertEquals(1, result, "Actual result doesn`t match to expected");
    }

    @Test
    public void whenPerformMaxOperationThenReturnCorrectResult() {
        double a = 5;
        double b = 10;

        double result = this.mathLibrary.max(a, b);
        assertEquals(b, result, "Actual result doesn`t match to expected");
    }

    @Test
    public void whenPerformMinOperationThenReturnCorrectResult() {
        double a = 5;
        double b = 10;

        double result = this.mathLibrary.min(a, b);
        assertEquals(a, result, "Actual result doesn`t match to expected");
    }
}
