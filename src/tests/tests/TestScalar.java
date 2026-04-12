package tests;
import ScalarAbstraction.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestScalar {

    Scalar s = new IntegerScalar(87365);
    Scalar s2 = new IntegerScalar(5);
    Scalar s3 = new RationalScalar(1,4);
    RationalScalar s4 = new RationalScalar(354,2);

    @Test
    void test_addIntegers(){

        Scalar results = s.add(s2);
        assertEquals(new IntegerScalar(87370),results);
    }

    @Test
    void test_addIntegerToRational(){
        Scalar results = s2.add(s3);
        assertEquals(new RationalScalar(21,4), results);
    }

    @Test
    void test_addRationalToInteger(){
        Scalar result = s4.add(s2);
        assertEquals(new IntegerScalar(182), result);
    }

    @Test
    void test_addRationals(){
        Scalar result = s3.add(s4);
        assertEquals(new RationalScalar(709,4), result);
    }
    @Test
    void test_MulIntegers(){

        Scalar results = s.mul(s2);
        assertEquals(new IntegerScalar(436825),results);
    }

    @Test
    void test_mulIntegerToRational(){
        Scalar results = s2.mul(s3);
        assertEquals(new RationalScalar(5,4), results);
    }

    @Test
    void test_mulRationalToInteger(){
        Scalar result = s4.mul(s2);
        assertEquals(new IntegerScalar(885), result);
    }

    @Test
    void test_mulRationals(){
        Scalar result = s3.mul(s4);
        assertEquals(new RationalScalar(177,4), result);
    }

    @Test
    void test_negInteger(){
        assertEquals(new IntegerScalar(-5), s2.neg());
    }

    @Test
    void tset_negRational(){
        assertEquals(new RationalScalar(-1,4) ,s3.neg());
    }

    @Test
    void test_powerInteger(){
        Scalar results = s2.power(10);
        assertEquals(new IntegerScalar(9765625), results);
    }

    @Test
    void test_powerRational(){
        Scalar results = s4.power(2);
        assertEquals(new IntegerScalar(31329), results);
    }

    @Test
    void test_signInteger(){
        Scalar sign = new IntegerScalar(-98475);
        assertEquals(-1,sign.sign());
        assertEquals(1,s.sign());
    }

    @Test
    void test_equalsInteger(){
        assertEquals(new IntegerScalar(87365), s);
        assertEquals(new IntegerScalar(5), s2);
    }

    @Test
    void test_equalsRational(){
        assertEquals(new RationalScalar(1, 4), s3);
        assertEquals(new RationalScalar(354,2), s4);
    }

    @Test
    void test_signRational(){
        Scalar sign = new RationalScalar(-2,4);
        Scalar sign2 = new RationalScalar(2,-4);
        Scalar sign3 = new RationalScalar(-2,-4);
        assertEquals(-1, sign.sign());
        assertEquals(-1, sign2.sign());
        assertEquals(1, sign3.sign());
        assertEquals(1, s3.sign());
    }

    @Test
    void test_toString(){
        assertEquals("87365", s.toString());
        assertEquals("354/2", s4.toString());
    }

    @Test
    void test_reduceRational(){
        RationalScalar red = new RationalScalar(16,-32);
        RationalScalar red1 = new RationalScalar(-1, -5);
        RationalScalar red3 = new RationalScalar(3,4);
        assertEquals(new RationalScalar(-1,2),red.reduce());
        assertEquals(new RationalScalar(1,5),red1.reduce());
        assertEquals(new IntegerScalar(177),s4.reduce());
        assertEquals(red3, red3.reduce());

    }
}
