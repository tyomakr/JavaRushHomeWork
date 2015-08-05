package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static int min (int i1, int i2) {

        int minim = 0;
        if (i1 > i2) minim = i2;
        else if (i2 > i1) minim = i1;
        return minim;
    }

    public static long min (long i1, long i2) {

        long minim = 0;
        if (i1 > i2) minim = i2;
        else if (i2 > i1) minim = i1;
        return minim;
    }

    public static double min (double i1, double i2) {

        double minim = 0;
        if (i1 > i2) minim = i2;
        else if (i2 > i1) minim = i1;
        return minim;
    }
}
