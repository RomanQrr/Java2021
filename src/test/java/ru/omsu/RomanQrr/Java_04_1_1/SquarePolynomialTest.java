package ru.omsu.RomanQrr.Java_04_1_1;
//import SquarePolynomial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquarePolynomialTest {
    @Test
    public void findRoots() {
        SquarePolynomial one = new SquarePolynomial(2, 3, -27);
        double[] expected = {-4.5, 3.0};
        double[] a = one.solve();
        assertEquals(a[0], expected[0], 0.00000001);
        assertEquals(a[1], expected[1], 0.00000001);
    }
    @Test
        public void findRootsTwo() {
            SquarePolynomial two= new SquarePolynomial(1,4,4);
        double[] expectedTwo= {-2.0 , -2.0};
        double[] b = two.solve();
        assertEquals(b[0], expectedTwo[0],0.00001);
        assertEquals(b[1], expectedTwo[1],0.00001);
    }
}
