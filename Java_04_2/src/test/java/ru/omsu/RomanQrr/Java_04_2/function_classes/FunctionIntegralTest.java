package ru.omsu.RomanQrr.Java_04_2.function_classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FunctionIntegralTest {
    @Test
    public void SumStartEndMid_1() {
        FunctionIntegral<RationalFunction> i = new FunctionIntegral<>(-10, 10);
        assertEquals(40.0, i.solve(new RationalFunction(4, 10, 2, 5, 20, -20)), 1E-5);
    }

    @Test
    public void SumStartEndMid_2() {
        FunctionIntegral<SinFunction> i = new FunctionIntegral<>(-10, 10);
        assertEquals(0.0, i.solve(new SinFunction(-5, 10, 20, -20)), 1E-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SumStartEndMid_fail() {
        FunctionIntegral<RationalFunction> i = new FunctionIntegral<>(-10, 100);
        assertNotNull(i);
        i.solve(new RationalFunction(4, 10, 2, 5, 20, -20));
    }
}
