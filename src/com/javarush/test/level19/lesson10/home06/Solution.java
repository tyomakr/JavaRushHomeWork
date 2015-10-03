package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        String fileName;
        List<String> strings = new ArrayList<>();
        String line;

        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = fileNameReader.readLine();
        fileNameReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while ((line = fileReader.readLine()) != null) {                //читаем построчно
            strings.add(line);
        }
        fileReader.close();

        for (int i = 0; i < strings.size(); i++) {                      //с каждой строки собираем слова отдельно
            String[] words = strings.get(i).split(" ");

            for (int j = 0; j < words.length; j++) {

                for(Map.Entry entry: map.entrySet()) {

                    if (words[j].matches(entry.getKey().toString())) {
                        words[j] = entry.getValue().toString();
                    }

                }

                System.out.print(words[j] + " ");


            }

            System.out.println();

        }

    }
}
