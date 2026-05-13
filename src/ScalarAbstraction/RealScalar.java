package ScalarAbstraction;

public class RealScalar implements Scalar{
    // Fields
    private double number;

    // Constructors
    public RealScalar(double number){
        this.number = number;
    }
    public RealScalar(){
        this(0);
    }

    // Methods

    public Scalar add(Scalar s){
        return s.addReal(this);
    }

    @Override
    public Scalar power(int exponent) {
        if(exponent < 0)
            throw new IllegalArgumentException("exponent is negative");
        return new RealScalar(Math.pow(number, exponent));
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulReal(this);
    }

    @Override
    public int sign() {
        if(number > 0)
            return 1;
        else if(number < 0)
                return -1;

        return 0;
    }

    @Override
    public Scalar neg() {
        return new RealScalar(number * (-1));
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            throw new IllegalArgumentException("input argument is null");
        if(obj instanceof Scalar)
            return number == ((RealScalar) obj).number;
        return false;
    }

    public String toString(){ return String.valueOf(number); }

    @Override
    public Scalar addReal(RealScalar s) {
        return new RealScalar(s.number + this.number);
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        return new RealScalar(s.getNumber() + this.number);
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        int demo =  s.getDenominator();
        int nume =  s.getNumerator();
        return new RealScalar(this.number + ((double) (demo / nume)));
    }

    @Override
    public Scalar mulReal(RealScalar s) {
        return new RealScalar(s.number * this.number);
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return new RealScalar(s.getNumber() * this.number);
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        int demo =  s.getDenominator();
        int nume =  s.getNumerator();
        return new RealScalar(this.number * ((double) (demo / nume)));
    }

    public double getNumber(){
        return number;
    }
}
