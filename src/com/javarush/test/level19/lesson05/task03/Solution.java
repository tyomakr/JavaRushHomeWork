package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        String fileName1;
        String fileName2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            fileName1 = reader.readLine();
            fileName2 = reader.readLine();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            FileWriter fileWriter = new FileWriter(fileName2);

            String str = "";

            while (fileReader.ready()) {
                str = fileReader.readLine() + " ";
            }

            String arr[] = str.split(" ");
            for (String s : arr) {
                try {
                    int i = Integer.parseInt(s);
                    fileWriter.write(i + " ");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            fileReader.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
