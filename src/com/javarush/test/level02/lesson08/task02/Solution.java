package com.javarush.test.level02.lesson08.task02;

/* Максимум двух чисел
Написать функцию, которая вычисляет максимум из двух чисел.
*/
public class Solution
{
    public static int max(int a, int b)
    {
        int m2;
        if (a > b)
            m2 = a;
        else
            m2 = b;

        return m2;

    }

    public static void main(String[] args)
    {
        int n1 = 4;
        int n2 = 5;
        int c = max(n1, n2);
        System.out.println("Maximum is = " + c);

    }
}