package com.javarush.test.level27.lesson15.big01.statistic;


import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {

    private static StatisticManager ourInstance = new StatisticManager();
    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    private StatisticStorage storage = new StatisticStorage();


    public void register(EventDataRow data) {
        storage.put(data);
    }


    //storage
    private static class StatisticStorage {

        private Map<EventType, List<EventDataRow>> eventTypeListMap = new HashMap<>();

        public StatisticStorage() {

            for (EventType el : EventType.values()) {
                eventTypeListMap.put(el, new ArrayList<EventDataRow>());
            }
        }


        private void put(EventDataRow data) {
            eventTypeListMap.get(data.getType()).add(data);
        }

    }
}
