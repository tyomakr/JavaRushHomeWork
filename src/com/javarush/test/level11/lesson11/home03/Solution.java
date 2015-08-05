package com.javarush.test.level11.lesson11.home03;

/* Эволюция
Написать четыре класса: Fish(Рыбы), Animal(Животные), Ape(Обезьяны), Human (Человек).
Унаследовать животных от рыб, обезьян от животных и человека от обезьян.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Fish
    {
        Object fish;
    }

    public class Animal extends Fish
    {
        Object animal;
    }

    public class Ape extends Animal
    {
        Object ape;
    }

    public class Human extends Ape
    {
        Object human;
    }

}
