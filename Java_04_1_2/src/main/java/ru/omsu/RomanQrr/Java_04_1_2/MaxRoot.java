package ru.omsu.RomanQrr.Java_04_1_2;

import ru.omsu.RomanQrr.Java_04_1_1.SquarePolynomial;

import java.util.Objects;

public class MaxRoot {
    SquarePolynomial squarePolynomial;
    public MaxRoot(double a, double b, double c) {
        this.squarePolynomial = new SquarePolynomial(a,b,c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxRoot maxRoot = (MaxRoot) o;
        return squarePolynomial.equals(maxRoot.squarePolynomial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(squarePolynomial);
    }

    public double getMaxRoot() throws IllegalArgumentException {
        double[] bla = squarePolynomial.solve();

        if (bla == null){
            throw new IllegalArgumentException("Polynomial has no real roots.");
        }
        if (Double.compare(bla[0], bla[1]) < 0){
            return bla[1];
        } else {
            return bla[0];
        }

    }
}
