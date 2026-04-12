package ScalarAbstraction;

public class RationalScalar implements Scalar{
    //fields
    private final int numerator;
    private final int denominator;

    //constructors
    /*
     * Constructs a new Rational Scalar
     */
    public RationalScalar(int numerator, int denominator){
        if(denominator == 0)
            throw new IllegalArgumentException("denominator must not be 0");
        this.numerator = numerator;
        this.denominator = denominator;

    }

    /*
     * Returns a new Rational Scalar that is a simplified version of this Rational Scalar
     * @param "nume" the integer that represents the numerator
     * @param "denom" the integer that represents the denominator
     */
    public Scalar reduce(){
        if(numerator % denominator == 0)
            return new IntegerScalar(numerator / denominator);
        int gcd = Gcd(numerator, denominator);
        int newNume = numerator / gcd;
        int newDeno = denominator / gcd;
        if(newDeno < 0) {
            newNume *= -1;
            newDeno *= -1;
        }
        return new RationalScalar(newNume, newDeno);

    }

    //helper functions
    /*
     * Computes the greatest common divisor of two integers
     * @param "a" the first integer
     * @param "b" the second integer
     */
    public static int Gcd(int a, int b){
        int r = a % b;
        while(r != 0){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
    }


    //methods

    @Override
    public Scalar add(Scalar s){
        return s.addRational(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar neg(){
        if(denominator < 0)
            return new RationalScalar(numerator, denominator * (-1));
        return new RationalScalar(numerator * (-1), denominator );
    }

    @Override
    public Scalar power(int exponent) {
        int nume = (int) Math.pow(numerator, exponent);
        int deno = (int) Math.pow(denominator, exponent);
        return new RationalScalar(nume, deno).reduce();
    }

    @Override
    public int sign() {
        if(denominator < 0){
            if(numerator < 0)
                return 1;
            return -1;
        }
        else {
            if (numerator < 0)
                return -1;
            else
                return 1;
        }
    }
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            throw new IllegalArgumentException("input argument is null");
        if(obj instanceof Scalar) {
            RationalScalar other = (RationalScalar) obj;
            return (numerator * other.getDenominator()) == (denominator * other.getNumerator());
        }
        return false;
    }
    @Override
    public String toString(){
        return numerator + "/" + denominator;
    }

    /*
     * Creates and Returns a new Rational Scalar that represents the sum
     * Of this Rational Scalar with the given Integer Scalar
     * @param "s" the Integer Scalar that is added to this Rational Scalar
     */
    @Override
    public Scalar addInteger(Scalar s){
        int num = ((IntegerScalar) s).getValue();
        return new RationalScalar((denominator * num) + numerator, denominator).reduce();
    }

    /*
     * Creates and Returns a new Rational Scalar that represents the sum of
     * This Rational scalar with the given Rational Scalar
     * @param "s" the Rational Scalar that is added to this Rational Scalar
     */
    @Override
    public Scalar addRational(Scalar s){
        int nume = ((RationalScalar) s).numerator;
        int deno = ((RationalScalar) s).denominator;
        int nResult = (nume * denominator ) + (numerator * deno);
        int dResult = deno * denominator;
        return new RationalScalar(nResult, dResult).reduce();
    }

    /*
     * Creates and Returns a new Scalar that represents the result of
     * Multiplying this Rational with the given Integer Scalar
     * @param "s" the Integer Scalar that is multiplied with this Rational Scalar
     */
    @Override
    public Scalar mulInteger(Scalar s){
        int num = ((IntegerScalar) s).getValue();
        return new RationalScalar(num * numerator, denominator).reduce();
    }

    /*
     * Creates and Returns a new Scalar that represents the result of
     * Multiplying this Rational Scalar with the given Rational Scalar
     * @param "s" the Rational Scalar that is multiplied with this Rational Scalar
     */
    @Override
    public Scalar mulRational(Scalar s){
        int nume = ((RationalScalar) s).numerator;
        int deno = ((RationalScalar) s).denominator;
        return new RationalScalar(nume * numerator, deno * denominator).reduce();
    }

    /*
     * Returns the value of the numerator of this Rational Scalar
     */
    public int getNumerator(){
        return numerator;
    }

    /*
     * Returns the value of the denominator of this Rational Scalar
     */
    public int getDenominator(){
        return denominator;
    }
}
