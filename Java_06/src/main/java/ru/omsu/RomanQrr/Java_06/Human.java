package ru.omsu.RomanQrr.Java_06;

import java.util.Objects;

public class Human implements Comparable<Human>{
    private String surName;
    private String name;
    private String lastName;
    private int age;

    public Human(String surName, String name, String lastName, int age) {
        this.surName = surName;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Human(Human item) {
        this(item.getSurName(), item.getName(), item.getLastName(), item.getAge());
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() &&
                Objects.equals(getSurName(), human.getSurName()) &&
                Objects.equals(getName(), human.getName()) &&
                Objects.equals(getLastName(), human.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurName(), getName(), getLastName(), getAge());
    }

    @Override
    public String toString() {
        return "Human{" +
                "surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        int result = getSurName().compareTo(o.getSurName());

        if(result != 0) {
            return result;
        }
        if(getName().compareTo(o.getName()) != 0){
            return getName().compareTo(o.getName()) ;
        }
        return getLastName().compareTo(o.getLastName());

    }
}
