package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Solution {

    //Этот метод должен для переданного множества строк возвращать множество идентификаторов
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> resultSet = new HashSet<>();

        for (String s : strings) {
            resultSet.add(shortener.getId(s));
        }
        return resultSet;
    }

    //Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> resultSet = new HashSet<>();

        for (Long l : keys) {
            resultSet.add(shortener.getString(l));
        }
        return resultSet;
    }

    //Метод будет тестировать работу переданной стратегии на определенном количестве
    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {

        //Выводить имя класса стратегии. Имя не должно включать имя пакета
        Helper.printMessage(strategy.getClass().getSimpleName());

        //Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber
        Set<String> testSetStrings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testSetStrings.add(Helper.generateRandomString());
        }

        //Создавать объект типа Shortener, используя переданную стратегию
        Shortener shortener = new Shortener(strategy);


        //Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии и заданного множества элементов
        //Время вывести в миллисекундах. При замере времени работы метода можно пренебречь переключением процессора на другие потоки,
        // временем, которое тратится на сам вызов, возврат значений и вызов методов получения времени (даты).
        // Замер времени произведи с использованием объектов типа Date.

        Set<Long> idsSet;

        Date startTime1 = new Date();
        idsSet = getIds(shortener, testSetStrings);
        Date finishTime1 = new Date();

        long msDelay1 = finishTime1.getTime() - startTime1.getTime();
        Helper.printMessage(Long.toString(msDelay1));


        //Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии и
        //полученного в предыдущем пункте множества идентификаторов.
        Set<String> stringSet;
        Date startTime2 = new Date();
        stringSet = getStrings(shortener, idsSet);
        Date finishTime2 = new Date();

        long msDelay2 = finishTime2.getTime() - startTime2.getTime();
        Helper.printMessage(Long.toString(msDelay2));


        //Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано
        // и множества, которое было возвращено методом getStrings.
        // Если множества одинаковы, то выведи "Тест пройден.", иначе "Тест не пройден.".
        if (testSetStrings.equals(stringSet)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
        //Добавь метод main(). Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов.

        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);
        OurHashMapStorageStrategy strategy2 = new OurHashMapStorageStrategy();
        testStrategy(strategy2, 10000);
        FileStorageStrategy strategy3 = new FileStorageStrategy();
        testStrategy(strategy3, 500);
        OurHashBiMapStorageStrategy strategy4 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy4, 10000);
        HashBiMapStorageStrategy strategy5 = new HashBiMapStorageStrategy();
        testStrategy(strategy5, 10000);
        DualHashBidiMapStorageStrategy strategy6 = new DualHashBidiMapStorageStrategy();
        testStrategy(strategy6, 10000);

    }

}
