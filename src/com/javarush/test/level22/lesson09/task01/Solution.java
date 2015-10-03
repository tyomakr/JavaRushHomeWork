package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        List<String> wordsList = new ArrayList<>();
        Pair pair;

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            wordsList.addAll(Arrays.asList(fileReader.readLine().split(" ")));          //пишем слова из файла в коллекцию
        }
        fileReader.close();


        for (int i1 = 0; i1 < wordsList.size(); i1++) {

            for (int i2 = 0; i2 < wordsList.size() ; i2++) {

                if (wordsList.get(i1)==null || wordsList.get(i2)==null) {
                    continue;
                }

                StringBuilder sb = new StringBuilder(wordsList.get(i1)).reverse();

                if (sb.toString().equals(wordsList.get(i2)) && i1 != i2) {
                    pair = new Pair();

                    pair.first = wordsList.get(i1);
                    pair.second = wordsList.get(i2);

                    result.add(pair);
                    wordsList.set(i1, null);
                    wordsList.set(i2, null);
                }
            }

        }

        System.out.println(result);

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

