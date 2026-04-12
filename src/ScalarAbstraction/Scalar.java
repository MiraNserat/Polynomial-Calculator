package ScalarAbstraction;

public interface Scalar {
    //returns a new Scalar that represents the sum of the scalar and a given scalar
    Scalar add(Scalar s);

    //returns a new Scalar that represents the result of multiplying this scalar with the given scalar
    Scalar mul(Scalar s);

    //returns a new Scalar that represents the negation of this scalar
    Scalar neg();

    //returns a Scalar that represents this scalar raised to the given exponent
    Scalar power(int exponent);

    //returns the sign of this scalar
    int sign();

    //returns the sum of the given scalar to this Integer Scalar
    Scalar addInteger(Scalar s);

    //returns the sum of the given scalar to this Rational Scalar
    Scalar addRational(Scalar s);

    //returns the result of multiplying the given scalar to this Integer Scalar
    Scalar mulInteger(Scalar s);

    //returns the result of multiplying the given scalar to this Rational Scalar
    Scalar mulRational(Scalar s);


}
