package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook implements Observer {

    private final String name;


    public Cook(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object arg) {
        ConsoleHelper.writeMessage("Start cooking - " + arg);
    }

}
