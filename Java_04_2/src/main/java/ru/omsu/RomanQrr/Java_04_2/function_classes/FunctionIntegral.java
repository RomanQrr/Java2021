package ru.omsu.RomanQrr.Java_04_2.function_classes;

import ru.omsu.RomanQrr.Java_04_2.interfaces.*;

public class FunctionIntegral <T extends IFunction> implements IFunctional<T> {
    private static final int SPLIT = 500;

    private double a,b;

    public FunctionIntegral(double a, double b) {
        if(a > b) {
            throw new IllegalArgumentException("incorrect segment bounds");
        }

        this.a = a;
        this.b = b;
    }

    @Override
    public double solve(T func) {
        if (func.getMinArgument() > a || func.getMaxArgument() < b) {
            throw new IllegalArgumentException("The boundaries of the function segment are not included in the integral domain");
        }
        double integ = 0;
        double h = Math.abs(b - a) / (double) SPLIT;
        for (int i = 0; i < SPLIT; i++) {
            integ += func.solve(a + i * h + h / 2);
        }
        return integ * h;
    }


}
