package ru.omsu.RomanQrr.Java_04_2.function_classes;

import ru.omsu.RomanQrr.Java_04_2.interfaces.IFunction;

public class RationalFunction implements IFunction {

    private double minArgument, maxArgument, a, b, c, d;
    public RationalFunction(double a, double b, double c, double d, double maxArgument, double minArgument) {
        if(maxArgument < minArgument){
            throw new IllegalArgumentException("The lower border is larger than the upper one");
        }
        this.maxArgument = maxArgument;
        this.minArgument = minArgument;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    @Override
    public double solve(double arg){
        if (arg < minArgument || arg > maxArgument) {
            throw new IllegalArgumentException("The argument is not in the scope of the function");
        }
        double denominator = c * arg + d;
        if(Double.compare(denominator, 0.0) == 0){
            throw new IllegalArgumentException("division by 0");
        }
        return (a * arg + b ) / denominator;
    }
    @Override
    public double getMaxArgument() {
        return maxArgument;
    }

    @Override
    public double getMinArgument() {
        return minArgument;
    }
}
