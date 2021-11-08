package ru.omsu.RomanQrr.Java_04_1_2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxRootTest {
    @Test
    public void findRoots() {
        MaxRoot one = new MaxRoot(2, 3, -27);
        double expected = 3.0;
        double a = one.getMaxRoot();
        assertEquals(a, expected, 0.00000001);
    }
    @Test
    public void findRootsTwo() {
        MaxRoot two = new MaxRoot(1,4,4);
        double expectedTwo = -2.0;
        double b = two.getMaxRoot();
        assertEquals(b, expectedTwo,0.00001);
    }
}
