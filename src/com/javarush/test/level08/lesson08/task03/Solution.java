package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap() throws Exception
    {
        HashMap<String, String> map = new HashMap();

        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Сидор");
        map.put("Мастеров", "Мастер");
        map.put("Александров", "Александр");
        map.put("Тестеров", "Тест");
        map.put("Админов", "Админ");
        map.put("Федоров","Федор");
        map.put("Джонсон","Джон");
        map.put("Марков","Марк");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {

        int counter = 0;

        for (Map.Entry<String, String> pair : map.entrySet()) {

            String value = pair.getValue();
            if (name.equals(value)) {
                counter ++;
            }
        }

        return counter;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int counter = 0;

        for (Map.Entry<String, String> pair : map.entrySet()) {

            String key = pair.getKey();
            if (familiya.equals(key)) {
                counter++;
            }
        }

        return counter;
    }
}
