package ru.omsu.RomanQrr.Java_07;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
   private String surName;
   private String name;
   private String secondName;
   private String birthDate;

   public Person() {

   }

    public Person(String surName, String name, String secondName, String birthDate) {
        this.surName = surName;
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getSurName(), person.getSurName()) &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getSecondName(), person.getSecondName()) &&
                Objects.equals(getBirthDate(), person.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurName(), getName(), getSecondName(), getBirthDate());
    }
}
