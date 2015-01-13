package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //открываем входящий поток, читающий с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //поток, читающий из файла
        reader = new BufferedReader(new InputStreamReader((new FileInputStream(fileName))));

        //Коллекция
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Преобразуем в int и узнаем четный или нет
        while (reader.ready()) {
            int num = Integer.parseInt(reader.readLine());
            if (num % 2 == 0) {
                numbers.add(num);
            }
        }
        // Закрываем ридер
        reader.close();

        // Сортируем коллекцию
        Collections.sort(numbers);

        // вывод на экран
        for (int i : numbers) {
            System.out.println(i);
        }




    }
}
