package polynomials;
import java.util.*;
import scalars.*;

public class  Polynomial {
    private Collection<Monomial> monomials;

    public Polynomial() {
        this.monomials = new ArrayList<>();
    }
    public static Polynomial build(String input)
    {
        Polynomial p = new Polynomial();
        String[] parts = input.split(" ");
        for (int i = 0; i < parts.length; i++)
        {
            if (!parts[i].equals("0"))
            {
                Scalar coeff;
                if (parts[i].contains("/"))
                {
                    String[] fraction = parts[i].split("/");
                    int num = Integer.parseInt(fraction[0]);
                    int den = Integer.parseInt(fraction[1]);
                    coeff = new RationalScalar(num, den);
                } else {
                    int num = Integer.parseInt(parts[i]);
                    coeff = new IntegerScalar(num);
                }
                Monomial m = new Monomial(coeff, i);
                p.monomials.add(m);
            }
        }
        return p;
    }
    public Polynomial add(Polynomial p) {

        Polynomial result = new Polynomial();
        for (Monomial m : this.monomials) {
            result.monomials.add(m);
        }
        for (Monomial m2 : p.monomials) {
            Monomial toReplace = null;
            for (Monomial r : result.monomials) {
                if (r.add(m2) != null)
                {
                    toReplace = r;
                }
            }
            if (toReplace != null)
            {
                result.monomials.remove(toReplace);
                result.monomials.add(toReplace.add(m2));
            } else {
                result.monomials.add(m2);
            }
        }

        return result;
    }
    public Polynomial mul(Polynomial p) {

        Polynomial result = new Polynomial();

        for (Monomial m1 : this.monomials) {
            for (Monomial m2 : p.monomials) {

                Monomial product = m1.mul(m2);

                boolean found = false;
                Monomial toReplace = null;
                Monomial newMono = null;

                for (Monomial r : result.monomials)
                {
                    Monomial temp = r.add(product);

                    if (temp != null) {
                        toReplace = r;
                        newMono = temp;
                        found = true;
                    }
                }
                if (found)
                {
                    result.monomials.remove(toReplace);
                    result.monomials.add(newMono);
                } else {
                    result.monomials.add(product);
                }
            }
        }
        return result;
    }
    public Scalar evaluate(Scalar s) {

        Scalar result = new IntegerScalar(0);

        for (Monomial m : this.monomials) {
            Scalar value = m.evaluate(s);
            result = result.add(value);
        }

        return result;
    }
    public Polynomial derivative() {

        Polynomial res = new Polynomial();

        for (Monomial m : this.monomials) {
            Monomial tmp = m.derivative();

            if (tmp.sign() != 0) {
                res.monomials.add(tmp);
            }
        }

        return res;
    }
    public boolean equals(Object o) {

        if (!(o instanceof Polynomial))
        {
            return false;
        }
        Polynomial p = (Polynomial) o;
        if (this.monomials.size() != p.monomials.size())
        {
            return false;
        }
        for (Monomial m : this.monomials)
        {
            boolean found = false;
            for (Monomial m2 : p.monomials)
            {
                if (m.equals(m2))
                {
                    found = true;
                }
            }
            if (!found)
            {
                return false;
            }
        }
        return true;
    }
    public String toString() {
        if (this.monomials.isEmpty())
        {
            return "0";
        }
        String result = "";
        for (Monomial m : this.monomials)
        {
            if (result.equals(""))
            {
                result = m.toString();
            } else {
                if (m.sign() == 1)
                {
                    result = result + "+" + m.toString();
                } else {
                    result = result + m.toString();
                }
            }
        }
        return result;
    }
}
