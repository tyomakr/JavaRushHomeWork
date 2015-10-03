package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if (string == null || string.equals("")) {
            throw new TooShortStringException();
        }

        int firstTabIndex = string.indexOf("\t");
        int secondTabIndex = string.indexOf("\t", firstTabIndex + 1);
        if ((firstTabIndex == -1 || secondTabIndex == -1) || (firstTabIndex == -1 && secondTabIndex == -1)) {
            throw new TooShortStringException();
        }

        String s = string.substring(firstTabIndex + 1, secondTabIndex);

        return s;

    }

    public static class TooShortStringException extends Exception {

    }
}
