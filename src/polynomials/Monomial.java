package polynomials;
import scalars.*;

public class Monomial {
    private int exponent;   //k>=0
    private Scalar coefficient;

    public Monomial(Scalar coefficient, int exponent) {
            if (exponent < 0) {
                throw new IllegalArgumentException("Exponent must be non negative");
            }
            this.coefficient = coefficient;
            this.exponent = exponent;
        }

    public Monomial add(Monomial m) {
        if (this.exponent != m.exponent) {
            return null;
        }
        Scalar newCoefficient = this.coefficient.add(m.coefficient);
        return new Monomial(newCoefficient, this.exponent);
    }
    public Monomial mul(Monomial m) {

        Scalar newCoefficient = this.coefficient.mul(m.coefficient);
        int newExponent = this.exponent + m.exponent;
        return new Monomial(newCoefficient, newExponent);
    }
    public Scalar evaluate(Scalar s) {

        Scalar val = s.power(this.exponent);
        return this.coefficient.mul(val);
    }
    public Monomial derivative() {

        if (this.exponent == 0) {
            return new Monomial(new IntegerScalar(0), 0);
        }
        Scalar newCoefficient = this.coefficient.mul(new IntegerScalar(this.exponent));
        return new Monomial(newCoefficient, this.exponent - 1);
    }
    public int sign() {
        return this.coefficient.sign();
    }
    public boolean equals(Object o) {

        if (!(o instanceof Monomial)) {
            return false;
        }
        Monomial m = (Monomial) o;
        if (this.exponent != m.exponent) {
            return false;
        }
        return this.coefficient.equals(m.coefficient);
    }
    public String toString() {

        if (this.exponent == 0) {
            return this.coefficient.toString();
        }
        if (this.exponent == 1) {
            return this.coefficient.toString() + "x";
        }
        return this.coefficient.toString() + "x^" + this.exponent;
    }
    }


