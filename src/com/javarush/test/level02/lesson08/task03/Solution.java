package com.javarush.test.level02.lesson08.task03;

/* Минимум трех чисел
Написать функцию, которая вычисляет минимум из трёх чисел.
*/
public class Solution
{
    public static int min(int a, int b, int c)
    {
        int m2;
        if (a < b & a < c)
            m2 = a;
        else if (b < a & b < c)
            m2 = b;
        else
            m2 = c;
        return m2;
    }

    public static void main(String[] args)
    {
        int n1 = 4;
        int n2 = 5;
        int n3 = 8;
        int cm = min(n1, n2, n3);
        System.out.println("Minimum is = " + cm);
    }
}