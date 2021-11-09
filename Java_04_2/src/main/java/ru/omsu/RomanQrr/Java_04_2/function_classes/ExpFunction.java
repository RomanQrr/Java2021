package ru.omsu.RomanQrr.Java_04_2.function_classes;

import ru.omsu.RomanQrr.Java_04_2.interfaces.IFunction;

public class ExpFunction implements IFunction {

    private double minArgument, maxArgument, a, b;
    public ExpFunction(double a, double b, double maxArgument, double minArgument) {
        if(maxArgument < minArgument){
            throw new IllegalArgumentException("The lower border is larger than the upper one");
        }
        this.maxArgument = maxArgument;
        this.minArgument = minArgument;
        this.a = a;
        this.b = b;
    }
    @Override
    public double solve(double arg){
        if (arg < minArgument || arg > maxArgument) {
            throw new IllegalArgumentException("The argument is not in the scope of the function");
        }
        return a * Math.exp(arg) + b;

    }
    @Override
    public double getMinArgument(){
        return minArgument;
    }
    public double getMaxArgument(){
        return maxArgument;
    }

}
