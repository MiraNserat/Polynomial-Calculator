package tests;

import org.junit.jupiter.api.Test;

import polynomials.Polynomial;
import scalars.IntegerScalar;

import static org.junit.jupiter.api.Assertions.*;

public class PolynomialTest {

    @Test
    public void testBuild() {
        Polynomial p = Polynomial.build("1 2 3");

        assertEquals("1+2x+3x^2", p.toString());
    }

    @Test
    public void testAdd() {
        Polynomial p1 = Polynomial.build("1 2");
        Polynomial p2 = Polynomial.build("3 4");

        Polynomial result = p1.add(p2);

        assertEquals("4+6x", result.toString());
    }

    @Test
    public void testMul() {
        Polynomial p1 = Polynomial.build("1 1");
        Polynomial p2 = Polynomial.build("1 1");

        Polynomial result = p1.mul(p2);

        assertEquals("1+2x+x^2", result.toString());
    }

    @Test
    public void testEvaluate() {
        Polynomial p = Polynomial.build("1 2 3");

        assertEquals(new IntegerScalar(17), p.evaluate(new IntegerScalar(2)));
    }

    @Test
    public void testEquals() {
        Polynomial p1 = Polynomial.build("1 2 3");
        Polynomial p2 = Polynomial.build("1 2 3");

        assertEquals(p1, p2);
    }

    @Test
    public void testToString() {
        Polynomial p = Polynomial.build("1 2 3");

        assertEquals("1+2x+3x^2", p.toString());
    }
    @Test
    public void testDerivative() {
        Polynomial p = Polynomial.build("1 2 3");

        Polynomial result = p.derivative();

        assertEquals("2+6x", result.toString());
    }
}
