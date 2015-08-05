package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.1, "one");
        labels.put(2.1, "two");
        labels.put(3.1, "three");
        labels.put(4.5, "four");
        labels.put(5.6, "five");
    }


    public static void main(String[] args) {
        System.out.println(labels);
    }
}
