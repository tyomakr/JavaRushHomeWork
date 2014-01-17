package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> list = new HashSet<Integer>();

        list.add(2);
        list.add(20);
        list.add(41);
        list.add(88);
        list.add(33);
        list.add(9);
        list.add(6);
        list.add(4);
        list.add(7);
        list.add(11);
        list.add(12);
        list.add(63);
        list.add(812);
        list.add(4132);
        list.add(543);
        list.add(481);
        list.add(888);
        list.add(84);
        list.add(105);
        list.add(61);

        return list;

    }

    public static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set)
    {
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() > 10) {
                iterator.remove();
            }

        }
        return set;

    }
}
