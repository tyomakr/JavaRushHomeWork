package com.javarush.test.level14.lesson08.bonus01;

import java.io.File;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //2
        try
        {
            int a[] = new int[2];
            a[0] = 1;
            a[1] = 2;
            a[2] = 3;
            a[3] = 4;
        } catch (Exception e) {
            exceptions.add(e);
        }

        //3
        try
        {
            String s = null;
            System.out.println(s.toString());
        } catch (Exception e) {
            exceptions.add(e);
        }

        //4
        try
        {
            File.createTempFile("prefix/*", "");
        } catch (Exception e) {
            exceptions.add(e);
        }

        //5
        try
        {
            LinkedList list = new LinkedList();
            list.get(-1);
        } catch (Exception e) {
            exceptions.add(e);
        }

        //6
        try
        {
            throw new NoRouteToHostException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //7
        try
        {
            throw new StringIndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //8
        try
        {
            int [] a = new int[-1];
        } catch (Exception e) {
            exceptions.add(e);
        }

        //9
        try
        {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //10
        try
        {
            throw new UnknownHostException();
        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}
