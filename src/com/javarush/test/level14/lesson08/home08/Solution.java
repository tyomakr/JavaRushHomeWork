package com.javarush.test.level14.lesson08.home08;

/*
1 Подумать, как связаны интерфейсы Swimable(способен плавать) и Walkable(способен ходить) с классом OceanAnimal(животное океана)
2 Расставить правильно наследование интерфейсов и класса OceanAnimal
3 Подумать, как могут быть связаны классы  Orca(Касатка), Whale(Кит), Otter(Выдра) с классом OceanAnimal
4 Расставить правильно наследование между классами Orca, Whale, Otter и классом OceanAnimal
5 Подумать, какой класс должен реализовать интерфейс Walkable и добавить интерфей этому классу
6 Подумать, какое животное на самом деле умеет плавать, но его класс не реализует интерфейс Swimable. Добавь этому классу интерфейс Swimable
7 Метод getCurrentAnimal должен быть реализован во всех классах, которые наследуются от OceanAnimal. Подумай, что должен возвращать этот метод.
 */
public class Solution
{
    public static void main(String[] args)
    {
        Swimable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test(Swimable animal)
    {
        animal.swim();
    }

    static interface Walkable
    {
        void walk();
    }

    static interface Swimable
    {
        void swim();
    }

    static abstract class OceanAnimal implements Swimable
    {
        public void swim()
        {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.swimming();
        }

        private void swimming()
        {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimable getCurrentAnimal();
    }

    static class Orca extends OceanAnimal
    {
        @Override
        Swimable getCurrentAnimal()
        {
            return this;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    static class Whale extends OceanAnimal
    {

        @Override
        Swimable getCurrentAnimal()
        {
            return this;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    static class Otter implements Walkable, Swimable
    {

        @Override
        public void swim()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void walk()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}