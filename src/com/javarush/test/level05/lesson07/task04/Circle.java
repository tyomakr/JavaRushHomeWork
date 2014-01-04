package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    private int cCenterX = 0;
    private int cCenterY = 0;
    private int cRadius = 0;
    private int cWidth = 0;
    private String cColor = null;


    public void initialize (int centerX, int centerY, int radius) {
        this.cCenterX = centerX;
        this.cCenterY = centerY;
        this.cRadius = radius;
    }

    public void initialize (int centerX, int centerY, int radius, int width) {
        this.cCenterX = centerX;
        this.cCenterY = centerY;
        this.cRadius = radius;
        this.cWidth = width;
    }

    public void initialize (int centerX, int centerY, int radius, int width, String color) {
        this.cCenterX = centerX;
        this.cCenterY = centerY;
        this.cRadius = radius;
        this.cWidth = width;
        this.cColor = color;
    }


}
