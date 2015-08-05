package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        sortInt(array);
        sortStr(array);

    }

    public static void sortInt (String[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {
                for (int j = 0; j < array.length; j++)
                {
                    if (isNumber(array[j]))
                    {
                        int n = Integer.parseInt(array[i]);
                        int m = Integer.parseInt(array[j]);
                        if (m<n)
                        {
                            String temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }
                }
            }
        }
    }



    public static void sortStr (String[] array)
    {

        for (int i = 0; i < array.length; i++)
        {
            if (!isNumber(array[i]))
            {
                for (int k = 0; k < array.length; k++)
                {
                    if (!isNumber(array[k]))
                    {
                        String c  = Character.toString(array[i].charAt(0));
                        String h = Character.toString(array[k].charAt(0));
                        if (isGreaterThen(h, c))
                        {
                            String temp = array[i];
                            array[i] = array[k];
                            array[k] = temp;
                        }
                    }
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        for (char c : s.toCharArray())
        {
            if (!Character.isDigit(c) && c != '-') return false;
        }
        return true;
    }
}
