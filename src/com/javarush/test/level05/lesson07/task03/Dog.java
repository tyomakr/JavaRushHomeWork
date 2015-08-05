package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    String dogName = null;
    int dogHeight = 0;
    String dogColor = null;

    public void initialize (String name) {
        this.dogName = name;
    }

    public void initialize (String name, int height) {
        this.dogName = name;
        this.dogHeight = height;

    }

    public void initialize (String name, int height, String color) {
        this.dogName = name;
        this.dogHeight = height;
        this.dogColor = color;
    }



}
