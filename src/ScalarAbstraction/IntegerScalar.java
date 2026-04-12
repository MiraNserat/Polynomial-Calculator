package ScalarAbstraction;

public class IntegerScalar implements Scalar{
    //Field
    private final int number;

    //Constructor
    /*
     * Constructs an IntegerScalar with the given value
     * @param number that represents the value for the IntegerScalar
     */
    public IntegerScalar(int number){
        this.number = number;
    }

    /*
     * The default constructor
     */
    public IntegerScalar(){
        this(0);
    }

    //Methods

    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(number * -1);
    }

    @Override
    public Scalar power(int exponent) {
        if(exponent < 0)
            throw new IllegalArgumentException("non-positive exponent");
        return new IntegerScalar((int) Math.pow(number, exponent));
    }

    @Override
    public int sign(){
        if(number < 0)
            return -1;
        else
        if(number > 0)
            return 1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            throw new IllegalArgumentException("input argument is null");
        if(obj instanceof Scalar)
            return number == ((IntegerScalar) obj).getValue();
        return false;

    }

    public String toString(){
        return String.valueOf(number);
    }

    /*
     * Returns the Integer value of this Scalar
     */
    public int getValue(){
        return number;
    }

    /*
     * Creates and Returns a new Integer Scalar that represents the sum of
     * this Integer with the given Integer
     * @param "s" the Scalar that is added to this Integer Scalar
     */
    @Override
    public Scalar addInteger(Scalar s) {
        return new IntegerScalar(((IntegerScalar)s).number + number);
    }

    /*
     * Creates and Returns a new Scalar that represents the sum of
     * this Integer with the given Rational Scalar
     * @param "s" the Scalar that is added to this Integer Scalar
     */
    @Override
    public Scalar addRational(Scalar s) {
        int demo = ((RationalScalar) s).getDenominator();
        int nume = ((RationalScalar) s).getNumerator();
        return new RationalScalar((demo * number) + nume, demo).reduce();
    }

    /*
     * Creates and Returns a new Scalar that represents the result of
     *  multiplying this Integer with the given Integer Scalar
     * @param "s" the Scalar that is added to this Integer Scalar
     */
    public Scalar mulInteger(Scalar s){
        return new IntegerScalar(((IntegerScalar) s).number * number);
    }

    /*
     * Creates and Returns a new Scalar that represents the result of
     * multiplying this Integer with the given Rational Scalar
     * @param "s" the Rational Scalar that is multiplied with this Scalar
     */
    public Scalar mulRational (Scalar s) {
        int demo = ((RationalScalar) s).getDenominator();
        int nume = ((RationalScalar) s).getNumerator();
        return new RationalScalar(nume * number, demo).reduce();
    }
}
