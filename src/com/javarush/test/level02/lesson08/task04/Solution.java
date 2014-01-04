package com.javarush.test.level02.lesson08.task04;

/* Минимум четырех чисел
Написать функцию, которая вычисляет минимум из четырёх чисел.
Использовать функцию из задачи 1.
*/
public class Solution
{
    public static int min(int a, int b, int c, int d)
    {
        int m2;
        if (a < b & a < c & a < d)
            m2 = a;
        else if (b < a & b < c & b < d)
            m2 = b;
        else if (c < a & c < b & c < d)
            m2 = c;
        else
            m2 = d;
        return m2;

    }

    public static int min(int a, int b)
    {
        int m2;
        if (a < b)
            m2 = a;
        else
            m2 = b;

        return m2;
    }

    public static void main(String[] args)
    {
        int n1 = 3;
        int n2 = 4;
        int n3 = 2;
        int n4 = 5;

        int cm1 = min(n1, n2, n3, n4);
        System.out.println("Minimum is: " + cm1);
        int cm2 = min(n1, n2);
        System.out.println("Minimum2 is: " + cm2);



    }

}