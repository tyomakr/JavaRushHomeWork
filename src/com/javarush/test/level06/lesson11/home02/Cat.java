package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {

    public static ArrayList<Cat> cats = new ArrayList<Cat>();

    public Cat() {
        cats.add(this);
    }

    public static void main(String[] args) {

        int qty = 10;
        for (int i = 0; i < qty; i++) {
            Cat cati = new Cat();
        }

        printCats();
    }

    public static void printCats() {

        for (int i = 0; i < Cat.cats.size(); i++) {
            System.out.println(Cat.cats.get(i));
        }
    }
}
