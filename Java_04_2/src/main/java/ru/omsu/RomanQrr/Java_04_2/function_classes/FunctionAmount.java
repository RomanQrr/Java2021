package ru.omsu.RomanQrr.Java_04_2.function_classes;

import ru.omsu.RomanQrr.Java_04_2.interfaces.*;

public class FunctionAmount<T extends IFunction> implements IFunctional<T>{
    private double a,b;

    public FunctionAmount(double a,double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double solve(T f) {
        if (f.getMinArgument() > a || f.getMaxArgument() < b)
            throw new IllegalArgumentException("The boundaries of the function segment are not included in the functional scope");
        return f.solve(f.getMinArgument()) + f.solve(f.getMaxArgument()) + f.solve((f.getMinArgument() + f.getMaxArgument())/2);
    }
}
