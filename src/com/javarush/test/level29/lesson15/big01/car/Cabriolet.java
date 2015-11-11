package com.javarush.test.level29.lesson15.big01.car;


public class Cabriolet extends Car {

    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
    }


    @Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 90;
        return MAX_CABRIOLET_SPEED;
    }
}
