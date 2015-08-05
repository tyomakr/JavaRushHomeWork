package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 12 2012".
*/


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Solution
{
    public static void main(String[] args)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        Calendar currentTime = new GregorianCalendar();
        System.out.println(format.format(currentTime.getTime()));
    }
}
