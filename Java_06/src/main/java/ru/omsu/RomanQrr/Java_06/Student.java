package ru.omsu.RomanQrr.Java_06;

public class Student extends Human{
    private String faculty;

    public Student(String surName, String name, String lastName, int age, String faculty) {
        super(surName, name, lastName, age);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
