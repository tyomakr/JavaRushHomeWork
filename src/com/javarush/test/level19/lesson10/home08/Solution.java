package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName;
        List<String> strings = new ArrayList<>();
        String line;

        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = fileNameReader.readLine();
        fileNameReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while ((line = fileReader.readLine()) != null) {                //читаем построчно в коллекцию
            strings.add(line);
        }
        fileReader.close();

        for (int i = 0; i < strings.size(); i++) {
            String currentReverseLine = new StringBuilder(strings.get(i)).reverse().toString();
            strings.set(i, currentReverseLine);
            System.out.println(strings.get(i));
        }

    }
}
