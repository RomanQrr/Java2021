package ru.omsu.RomanQrr.Java_04_2.interfaces;

public interface IFunctional <T extends IFunction> {
        double solve(T arg);
}
