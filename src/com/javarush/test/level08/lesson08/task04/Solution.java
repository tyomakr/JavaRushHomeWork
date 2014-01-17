package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Шварценеггер", new Date("MAY 10 1980"));
        map.put("Джобс", new Date("OCTOBER 20 1980"));
        map.put("Франклин", new Date("JULY 4 1980"));
        map.put("Вашингтон", new Date("AUGUST 8 1980"));
        map.put("Линкольн", new Date("SEPTEMBER 29 1980"));
        map.put("Джонсон", new Date("MARCH 5 1980"));
        map.put("Джефферсон", new Date("MAY 12 1980"));
        map.put("Уиллис", new Date("FEBRUARY 28 1980"));
        map.put("Браун", new Date("APRIL 1 1980"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            int month = iterator.next().getValue().getMonth() + 1;
            if (month >=6 && month <=8) {
                iterator.remove();
            }
        }

    }
}
