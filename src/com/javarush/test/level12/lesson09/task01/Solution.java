package com.javarush.test.level12.lesson09.task01;

/* Интерфейс Fly
Напиши свой public интерфейс Fly(летать). Добавь в него два метода.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly {

        void takeOff(String ICAOCode, int x, int y);
        void landing(String ICAOCode, int x, int y);
    }


}
