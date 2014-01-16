package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз – ягода, банан – трава, вишня – ягода, груша – фрукт, дыня – овощ, ежевика – куст, жень-шень – корень,
земляника – ягода, ирис – цветок, картофель – клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель – овощ
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Map <String, String> map = createMap();
        printMap(map);

    }
    public static Map <String, String> createMap()
    {
        Map <String, String> map = new HashMap <String,String>();
        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");

        return map;
    }
    public static void printMap(Map <String, String> map)
    {
        for(Map.Entry<String,String> pair: map.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
    }
}