package com.javarush.test.level27.lesson15.big01.statistic;


import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;

public class StatisticManager {

    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }


    public void register(EventDataRow data) {
        //TODO
    }
}
