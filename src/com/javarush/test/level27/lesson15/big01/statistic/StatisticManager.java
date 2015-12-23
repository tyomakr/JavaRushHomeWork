package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {

    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cookSet = new HashSet();


    public static StatisticManager getInstance() {
        return ourInstance;
    }


    private StatisticManager() {}


    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }


    public void register(Cook cook) {
        cookSet.add(cook);
    }


    private Date getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        GregorianCalendar g = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        return g.getTime();
    }


    private class ComparatorDate implements Comparator<Date> {
        @Override
        public int compare(Date o1, Date o2) {
            return o2.compareTo(o1);
        }
    }


    public Map<Date, Double> getAdvertisementProfit() {
        Map<Date, Double> resultMap = new TreeMap<>(new ComparatorDate());
        List<EventDataRow> listEvent = statisticStorage.get(EventType.SELECTED_VIDEOS);

        for (EventDataRow v : listEvent) {

            if (listEvent == null) continue;
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) v;
            Date date = getDay(videoEvent.getDate());
            long amount = videoEvent.getAmount();

            if (amount==0) continue;
            double profit = amount * 1d / 100d;

            if (resultMap.containsKey(date)) {
                profit += resultMap.get(date);
            }
            resultMap.put(date, profit);
        }
        return resultMap;
    }


    public Map<Date, Map<String, Integer>> getCookWorkloading() {

        List<EventDataRow> eventDataRows = statisticStorage.get(EventType.COOKED_ORDER);
        Map<Date, Map<String, Integer>> result = new TreeMap<>(new ComparatorDate());

        for (EventDataRow eventDataRow : eventDataRows) {
            if (eventDataRow == null) continue;

            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) eventDataRow;
            Map<String, Integer> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            Date date = getDay(cookEvent.getDate());

            int workTime = cookEvent.getTime();

            if (workTime == 0) continue;
            workTime = (workTime + 59) / 60;
            String cookName = cookEvent.getCookName();

            if (result.containsKey(date)) {
                treeMap = result.get(date);

                if (treeMap.containsKey(cookName)) {
                    workTime += treeMap.get(cookName);
                }
            }
            treeMap.put(cookName, workTime);
            result.put(date, treeMap);
        }
        return result;
    }



    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> eventTypeListMap = new HashMap<>();

        private StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                eventTypeListMap.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            if (data == null) return;
            eventTypeListMap.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType eventType) {
            return eventTypeListMap.get(eventType);
        }
    }
}
