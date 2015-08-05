package com.javarush.test.level13.lesson11.bonus03;

public class Robot extends AbstractRobot implements Attackable, Defensable
{

    private String name;

    public Robot(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

}
