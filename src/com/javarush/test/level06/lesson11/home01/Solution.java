package com.javarush.test.level06.lesson11.home01;

/* Класс Cat и статическая переменная catCount
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat) статическая переменная
catCount увеличивается на 1. Создать 10 объектов Cat и вывести значение переменной catCount на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int qty = 10;
        Cat cat[] = new Cat[qty];

        for (int i = 0; i < qty; i++) {
            cat[i] = new Cat();
        }

        System.out.println(Cat.catCount);
    }

    public static class Cat
    {
        static int catCount = 0;

        public Cat() {
            Cat.catCount ++;
        }
    }

}
