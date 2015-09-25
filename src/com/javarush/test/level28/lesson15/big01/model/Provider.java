package com.javarush.test.level28.lesson15.big01.model;

public class Provider {

    private Strategy strategy;

    public Provider(Strategy strategy) {
    }


    //Getters and setters

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
