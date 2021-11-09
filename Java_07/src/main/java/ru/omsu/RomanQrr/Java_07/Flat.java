package ru.omsu.RomanQrr.Java_07;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {

    private int number;
    private double space;
    private List<Person> dataPerson;

    public Flat() {

    }

    public Flat(int number, double space, List<Person> dataPerson) {
        this.number = number;
        this.space = space;
        this.dataPerson = dataPerson;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSpace() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    public List<Person> getDataPerson() {
        return dataPerson;
    }

    public void setDataPerson(List<Person> dataPerson) {
        this.dataPerson = dataPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat)) return false;
        Flat flat = (Flat) o;
        return getNumber() == flat.getNumber() &&
                Double.compare(flat.getSpace(), getSpace()) == 0 &&
                Objects.equals(getDataPerson(), flat.getDataPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getSpace(), getDataPerson());
    }
}
