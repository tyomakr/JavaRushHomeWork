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

    private static Date getStartOfDay(Date date)
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

    public Map<Date, Map<String, Integer>> getCookedTime()
    {

        Map<Date, Map<String, Integer>> arr = new TreeMap<>(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                return ((Date) o2).compareTo((Date) o1);
            }
        });

        for (EventDataRow el : storage.getData(EventType.COOKED_ORDER))
        {

            CookedOrderEventDataRow el2 = (CookedOrderEventDataRow) el;
            Date temp = getStartOfDay(el.getDate());
            if (arr.containsKey(temp))
            {
                Map<String, Integer> dd = arr.get(temp);
                String cookName = el2.getCookName();
                if (dd.containsKey(cookName))
                {
                    Integer dd2 = dd.get(cookName);
                    dd.put(cookName, dd2.intValue() + el.getTime());
                } else
                {
                    dd.put(cookName, el.getTime());
                }
                arr.put(temp, dd);
            } else
            {
                Map<String, Integer> dd = new TreeMap<>();
                dd.put(el2.getCookName(), el2.getTime());
                arr.put(temp, dd);
            }
        }
        return arr;
    }

    public Map<Date, Long> getVideoProfit()
    {
        Map<Date, Long> arr = new TreeMap<>(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                return ((Date) o2).compareTo((Date) o1);
            }
        });
        for (EventDataRow el : storage.getData(EventType.SELECTED_VIDEOS))
        {
            Date temp = getStartOfDay(el.getDate());
            if (arr.containsKey(temp))
            {
                Long dd = arr.get(temp);
                arr.put(temp, new Long(dd.longValue() + ((VideoSelectedEventDataRow) el).getAmount()));
            } else
            {
                arr.put(temp, new Long(((VideoSelectedEventDataRow) el).getAmount()));
            }
        }
        return arr;
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
    }


}
