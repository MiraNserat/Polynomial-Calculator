package tests;
import org.junit.jupiter.api.Test;
import polynomials.Monomial;
import scalars.IntegerScalar;
import static org.junit.jupiter.api.Assertions.*;

public class MonomialTest {

    @Test
    public void testAddSameExponent() {
        Monomial m1 = new Monomial(new IntegerScalar(3), 2);
        Monomial m2 = new Monomial(new IntegerScalar(5), 2);

        Monomial result = m1.add(m2);

        assertEquals(new Monomial(new IntegerScalar(8), 2), result);
    }

    @Test
    public void testAddDifferentExponent() {
        Monomial m1 = new Monomial(new IntegerScalar(3), 2);
        Monomial m2 = new Monomial(new IntegerScalar(5), 3);

        Monomial result = m1.add(m2);

        assertNull(result);
    }

    @Test
    public void testMul() {
        Monomial m1 = new Monomial(new IntegerScalar(2), 3);
        Monomial m2 = new Monomial(new IntegerScalar(4), 2);

        Monomial result = m1.mul(m2);

        assertEquals(new Monomial(new IntegerScalar(8), 5), result);
    }

    @Test
    public void testEvaluate() {
        Monomial m = new Monomial(new IntegerScalar(3), 2);

        assertEquals(new IntegerScalar(12), m.evaluate(new IntegerScalar(2)));
    }

    @Test
    public void testDerivative() {
        Monomial m = new Monomial(new IntegerScalar(3), 2);

        Monomial result = m.derivative();

        assertEquals(new Monomial(new IntegerScalar(6), 1), result);
    }

    @Test
    public void testDerivativeConstant() {
        Monomial m = new Monomial(new IntegerScalar(5), 0);

        Monomial result = m.derivative();

        assertEquals(new Monomial(new IntegerScalar(0), 0), result);
    }

    @Test
    public void testSign() {
        Monomial m = new Monomial(new IntegerScalar(-7), 3);

        assertEquals(-1, m.sign());
    }

    @Test
    public void testEquals() {
        Monomial m1 = new Monomial(new IntegerScalar(4), 2);
        Monomial m2 = new Monomial(new IntegerScalar(4), 2);

        assertEquals(m1, m2);
    }

    @Test
    public void testToString() {
        Monomial m = new Monomial(new IntegerScalar(3), 2);

        assertEquals("3x^2", m.toString());
    }
}
