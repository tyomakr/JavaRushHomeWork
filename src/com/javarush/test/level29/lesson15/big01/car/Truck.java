package com.javarush.test.level29.lesson15.big01.car;


public class Truck extends Car {

    public Truck(int numberOfPassengers) {
        super(0, numberOfPassengers);
    }


    @Override
    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }
}
