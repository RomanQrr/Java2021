package ru.omsu.RomanQrr.Java_08.usingClass;

public class Bla extends Exsec {
    private int a;
    private int b;

    public Bla(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }

    public void vs(){
        int j = a+b;
    }

    private void empty(){}

    protected void doNothing(){

    }
}
