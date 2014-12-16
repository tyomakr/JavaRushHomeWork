package com.javarush.test.level11.lesson11.home02;

/* AppleIPhone и SamsungGalaxyS2
Написать два класса AppleIPhone и SamsungGalaxyS2.
Унаследовать SamsungGalaxyS2 от AppleIPhone.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class AppleIPhone
    {
        Object hardwareCase;
        Object screen;
    }

    public class SamsungGalaxyS2 extends AppleIPhone
    {
        Object copypaste;
    }
}
