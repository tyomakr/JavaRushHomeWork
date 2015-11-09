package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;


public class Student extends UniversityPerson {

    private double averageGrade;

    private int course;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {

        super(name, age);
        this.averageGrade = averageGrade;
    }


    public void live() {
        learn();
    }

    public void learn() {
    }


    public void incAverageGradeBy01()
    {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02()
    {
        averageGrade += 0.2;
    }

    public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int)value;
            return;
        }
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public void setBeginningOfSession(int day, int month, int year) {
        beginningOfSession = new Date(year, month, day);
    }

    public void setEndOfSession(int day, int month, int year) {
        endOfSession = new Date(year, month, day);
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getCourse() {
        return course;
    }
}
