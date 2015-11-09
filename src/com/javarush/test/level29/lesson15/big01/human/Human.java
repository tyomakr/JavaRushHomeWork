package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human {

    private List<Human> children = new ArrayList<>();

    public static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected int course;

    protected int[] size;


    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private int bloodGroup;


    public void setBloodGroup(int code) {
        bloodGroup = code;
    }
    public int getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void live() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human){
        children.add(human);
    }

    public void removeChild(Human human) {
        children.remove(human);
    }

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }


}
