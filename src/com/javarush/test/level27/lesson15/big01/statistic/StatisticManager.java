package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {}

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) { statisticStorage.put(data); }

    public void register(Cook cook) { cooks.add(cook); }


    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> map = new HashMap<>();
        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                map.put(type, new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data) {
            map.get(data.getType()).add(data);
        }
        private List<EventDataRow> get(EventType eventType) {
            return map.get(eventType);
        }
    }


    public Map<Date, Double> getTotalMoneyPerDay() {
        Map<Date, Double> resultMap = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow event : statisticStorage.get(EventType.SELECTED_VIDEOS)) {
            Date date = dateWithoutTime(event.getDate());
            VideoSelectedEventDataRow eventData = (VideoSelectedEventDataRow) event;
            if (resultMap.containsKey(date)) {
                resultMap.put(date, resultMap.get(date) + (0.01d * (double) eventData.getAmount()));
            } else {
                resultMap.put(date, (0.01d * (double) eventData.getAmount()));
            }
        }
        return resultMap;
    }


    public TreeMap<Date, TreeMap<String, Integer>> getCookInfo() {
        TreeMap<Date, TreeMap<String, Integer>> map = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow e : statisticStorage.get(EventType.COOKED_ORDER)) {
            Date date = dateWithoutTime(e.getDate());
            CookedOrderEventDataRow cook = (CookedOrderEventDataRow) e;

            int time = cook.getTime();
            if (time == 0) continue;
            if (time % 60 == 0) time = time / 60;
            else time = time / 60 + 1;

            if (map.containsKey(date)) {
                TreeMap<String, Integer> value = map.get(date);
                if (value.containsKey(cook.getCookName())) {
                    value.put(cook.getCookName(), value.get(cook.getCookName()));
                }
                else value.put(cook.getCookName(), time);
            }
            else {
                TreeMap<String, Integer> value = new TreeMap<>();
                value.put(cook.getCookName(), time);
                map.put(date, value);
            }
        }
        return map;
    }


    private Date dateWithoutTime(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}