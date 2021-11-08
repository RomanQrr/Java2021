package ru.omsu.RomanQrr.Java_04_1_1;

public class SquarePolynomial {
    private double a;
    private double b;
    private double c;

    public SquarePolynomial(double a, double b, double c) {

        setA(a);
        setB(b);
        setC(c);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (a == 0)
            throw new IllegalArgumentException("Not a SquarePolynomial. A must be != 0.");
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SquarePolynomial)) return false;
        SquarePolynomial that = (SquarePolynomial) o;
        return Double.compare(that.a, a) == 0 &&
                Double.compare(that.b, b) == 0 &&
                Double.compare(that.c, c) == 0;
    }

    public double[] solve()
    {
        double[] roots = new double[2];
        double D;
        D = b*b - 4*a*c;
        if (D < 0)
        {
            return null;
        }
        roots[0] = ( -b - Math.sqrt(D)) / (2 * a);
        roots[1] = ( -b + Math.sqrt(D)) / (2 * a);
        return roots;

    }
}
