package com.javarush.test.level08.lesson08.task01;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> list = new HashSet<String>();

        list.add("ла");
        list.add("лб");
        list.add("лв");
        list.add("лг");
        list.add("лд");
        list.add("ле");
        list.add("лж");
        list.add("лз");
        list.add("ли");
        list.add("лй");
        list.add("лк");
        list.add("лм");
        list.add("лл");
        list.add("лн");
        list.add("ло");
        list.add("лп");
        list.add("лр");
        list.add("лс");
        list.add("лт");
        list.add("лу");

        return list;
    }
}
