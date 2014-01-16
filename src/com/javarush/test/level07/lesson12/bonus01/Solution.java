package com.javarush.test.level07.lesson12.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача:  Программа вводит с клавиатуры данные про котов и выводит их на экран. Пример:
Cat name is Barsik age is 6, weight is 5, tail = 22
Cat name is Murka age is 8, weight is 7, tail = 20
*/

public class Solution
{
    public final static ArrayList<Cat> CATS = new ArrayList<Cat>();

    public static void main(String[] args) throws IOException
    {
        int catAge = 0;
        int catWeight = 0;
        int catTail = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String name = reader.readLine();

            if (name.isEmpty()) break;

            String sAge = reader.readLine();
            catAge = Integer.parseInt(sAge);

            String sWeight = reader.readLine();
            catWeight = Integer.parseInt(sWeight);

            String sTail = reader.readLine();
            catTail = Integer.parseInt(sTail);

            Cat cat = new Cat(name, catAge, catWeight, catTail);
            CATS.add(cat);
        }

        printList();
    }


    public static void printList() {
        for (int i = 0; i < CATS.size(); i++)
        {
            System.out.println(CATS.get(i));
        }
    }

    public static class Cat
    {
        private String name;
        private int age;
        private int weight;
        private int tailLength;

        Cat(String name, int age, int weight, int tailLength)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.tailLength = tailLength;
        }

        @Override
        public String toString()
        {
            return "Cat name is " + name + ", age is " + age + ", weight is " + weight + ", tail = " + tailLength;
        }
    }
}
