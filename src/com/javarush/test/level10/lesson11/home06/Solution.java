package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        boolean sex;
        Date birthday;
        int weight;
        int height;


        public Human() {}

        public Human(String name, int age, boolean sex, Date birthday, int weight, int height) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.birthday = birthday;
            this.weight = weight;
            this.height = height;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, Date birthday) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.birthday = birthday;
        }

        public Human(String name, int age, boolean sex, Date birthday, int weight) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.birthday = birthday;
            this.weight = weight;
        }

        public Human(String name, int age, Date birthday, int weight, int height) {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
            this.weight = weight;
            this.height = height;
        }

        public Human(String name, int age, Date birthday) {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
        }

        public Human(int age, boolean sex, Date birthday) {
            this.age = age;
            this.sex = sex;
            this.birthday = birthday;
        }
    }
}
