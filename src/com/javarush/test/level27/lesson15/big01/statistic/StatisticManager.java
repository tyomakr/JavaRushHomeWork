package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager
{

    private static final StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage storage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager()
    {
    }

    public static StatisticManager getInstance()
    {
        return ourInstance;
    }

    private static Date getDay(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public void register(EventDataRow data)
    {
        storage.put(data);
    }

    public void register(Cook cook)
    {
        cooks.add(cook);
    }


    public Map<Date, Map<String, Integer>> getCookWorkloading() {
        List<EventDataRow> eventDataRows = storage.get(EventType.COOKED_ORDER);
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
    public Map<Date, Double> getVideoProfit() {
        Map<Date, Double> resultMap = new TreeMap<>(new ComparatorDate());
        List<EventDataRow> listEvent = storage.get(EventType.SELECTED_VIDEOS);
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


    private class ComparatorDate implements Comparator<Date> {
        @Override
        public int compare(Date o1, Date o2) {
            return o2.compareTo(o1);
        }
    }


    private static class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> eventTypeListMap = new HashMap<>();

        public StatisticStorage()
        {
            for (EventType el : EventType.values())
            {
                eventTypeListMap.put(el, new ArrayList<EventDataRow>());
            }

        }

        private void put(EventDataRow data)
        {
            eventTypeListMap.get(data.getType()).add(data);
        }

        private ArrayList<EventDataRow> getData(EventType eventType)
        {
            return new ArrayList<>(eventTypeListMap.get(eventType));
        }

        private List<EventDataRow> get(EventType eventType) {
            return eventTypeListMap.get(eventType);
        }

    }


}
