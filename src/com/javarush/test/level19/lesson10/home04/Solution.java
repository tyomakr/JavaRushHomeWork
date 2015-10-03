package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    public static List<String> results = new ArrayList<>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        String fileName;
        String line;
        List<String> strings = new ArrayList<>();



        BufferedReader rd1 = new BufferedReader(new InputStreamReader(System.in));
        fileName = rd1.readLine();
        rd1.close();

        BufferedReader rd2 = new BufferedReader(new FileReader(fileName));

        while ((line = rd2.readLine()) != null) {
            strings.add(line);
        }
        rd2.close();

        for (int i = 0; i < strings.size(); i++) {
            String[] currentLine = strings.get(i).split(" ");
            calculate(currentLine, strings.get(i));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

    }

    public static void calculate (String[] currentLine, String s) {

        int counter = 0;
        for (int i = 0; i < currentLine.length; i++) {  //цикл прохода каждого слова в одной строке

            for (int j = 0; j < words.size(); j++) {    //цикл прохода по списку words
                if (currentLine[i].equals(words.get(j))) {
                    counter ++;

                }
            }
        }
        if (counter == 2) {
            results.add(s);
        }
    }
}
