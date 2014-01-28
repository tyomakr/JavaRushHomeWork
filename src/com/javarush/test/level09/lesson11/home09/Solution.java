package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap <String,Cat> map = new HashMap();

        map.put("cat1", new Cat("cat1"));
        map.put("cat2", new Cat("cat2"));
        map.put("cat3", new Cat("cat3"));
        map.put("cat4", new Cat("cat4"));
        map.put("cat5", new Cat("cat5"));
        map.put("cat6", new Cat("cat6"));
        map.put("cat7", new Cat("cat7"));
        map.put("cat8", new Cat("cat8"));
        map.put("cat9", new Cat("cat9"));
        map.put("cat10", new Cat("cat10"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        return new HashSet<Cat>(map.values());
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
