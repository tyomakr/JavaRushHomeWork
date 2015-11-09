package com.javarush.test.level29.lesson15.big01.human;


public class Teacher extends Human {

    private int numberOfStudents;
    private String university;

    public Teacher(String name, int age, int numberOfStudents) {

        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }


    public void live() {
        teach();
    }

    public void teach() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void printData() {
        System.out.println("Преподаватель: " + name);
    }
}
