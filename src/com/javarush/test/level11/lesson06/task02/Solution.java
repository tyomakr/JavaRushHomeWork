package com.javarush.test.level11.lesson06.task02;

/* Домашние животные
Написать три класса: Pet (домашнее животное), Cat(кот) и Dog(собака).
Унаследовать кота и собаку от животного.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Pet
    {
        Object head;
        Object body;
    }

    public class Cat extends Pet
    {
        Object mrr;
    }

    public class Dog extends Pet
    {
        Object bark;
    }
}
