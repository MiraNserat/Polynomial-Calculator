import polynomials.*;
import polynomials.Polynomial;
import ScalarAbstraction.RealScalar;
public class testToString {

    public static void main(String []args){
        Polynomial p = Polynomial.build("1.5 2.6 3.7");
        System.out.print(p);
        System.out.println();
        Polynomial p1 = Polynomial.build("1 0.5 3");

        System.out.println(p1);
        System.out.println(p1.evaluate(new RealScalar(2.0)));
    }
}
