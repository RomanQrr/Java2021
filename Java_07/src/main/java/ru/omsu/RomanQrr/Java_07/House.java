package ru.omsu.RomanQrr.Java_07;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private String houseNumber;
    private String address;
    private Person headOfHouse;
    private List<Flat> listFlats;

    public House() {

    }

    public House(String houseNumber, String address, Person headOfHouse, List<Flat> listFlats) {
        this.houseNumber = houseNumber;
        this.address = address;
        this.headOfHouse = headOfHouse;
        this.listFlats = listFlats;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(Person headOfHouse) {
        this.headOfHouse = headOfHouse;
    }

    public List<Flat> getListFlats() {
        return listFlats;
    }

    public void setListFlats(List<Flat> listFlats) {
        this.listFlats = listFlats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        House house = (House) o;
        return Objects.equals(getHouseNumber(), house.getHouseNumber()) &&
                Objects.equals(getAddress(), house.getAddress()) &&
                Objects.equals(getHeadOfHouse(), house.getHeadOfHouse()) &&
                Objects.equals(getListFlats(), house.getListFlats());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHouseNumber(), getAddress(), getHeadOfHouse(), getListFlats());
    }
}
