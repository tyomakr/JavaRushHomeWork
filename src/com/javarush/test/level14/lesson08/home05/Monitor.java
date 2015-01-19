package com.javarush.test.level14.lesson08.home05;

public class Monitor implements CompItem {

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
