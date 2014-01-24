package com.javarush.test.level08.lesson11.home09;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(isDateOdd(reader.readLine()));
    }

    public static boolean isDateOdd(String date)
    {

        Date yearBegin = new Date(113,0,1);
        Date dateNow = new Date(date);


        long difference = dateNow.getTime()  - yearBegin.getTime();
        long days = difference/(24*60*60*1000);

        if(days % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}