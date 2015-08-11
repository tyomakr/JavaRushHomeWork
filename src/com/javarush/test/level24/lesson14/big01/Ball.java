package com.javarush.test.level24.lesson14.big01;


public class Ball extends BaseObject {

    double speed;
    double direction;
    double dx;
    double dy;
    boolean isFrozen = true;


    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public void move() {

    }

    @Override
    public void draw(Canvas canvas) {

    }


    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public boolean isFrozen() {
        return isFrozen;
    }
}
