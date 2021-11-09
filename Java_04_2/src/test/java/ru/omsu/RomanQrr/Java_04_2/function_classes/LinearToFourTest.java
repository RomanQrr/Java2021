package ru.omsu.RomanQrr.Java_04_2.function_classes;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class LinearToFourTest {
    @Test
    public void FuncNorm() {
        SinFunction sin = new SinFunction(1, 1, 5, -5);
        assertEquals(1, sin.solve(1.5708), 1E-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void FuncFail_Arg() {
        SinFunction sin = new SinFunction(1, 1, 10, 2);
        sin.solve(1.5708);
    }

    @Test(expected = IllegalArgumentException.class)
    public void FuncFail_OOF() {
        SinFunction sin = new SinFunction(1, 1, -10, 5);
    }

    @Test
    public void SumStartEndMid_1() {
        FunctionAmount<RationalFunction> i = new FunctionAmount<>(-10, 10);
        assertEquals(6.0, i.solve(new RationalFunction(4, 10, 2, 5, 20, -20)), 1E-5);
    }

    @Test
    public void SumStartEndMid_2() {
        FunctionAmount<SinFunction> i = new FunctionAmount<>(-10, 10);
        assertEquals(0.0, i.solve(new SinFunction(-5, 10, 20, -20)), 1E-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SumStartEndMid_fail() {
        FunctionAmount<RationalFunction> i = new FunctionAmount<>(-10, 100);
        assertNotNull(i);
        i.solve(new RationalFunction(4, 10, 2, 5, 20, -20));
    }

}
