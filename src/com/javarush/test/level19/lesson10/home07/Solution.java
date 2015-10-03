package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName1 = args[0];
        String fileName2 = args[1];
        List<String> resList = new ArrayList<>();
        String result = "";

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        while (fileReader.ready()) {
            String[] words = fileReader.readLine().split(" ");

            for (int i = 0; i < words.length; i++) {

                if (words[i].length() > 6) {
                    resList.add(words[i]);
                }
            }
        }
        fileReader.close();

        for (int i = 0; i < resList.size(); i++) {

            if (i != resList.size() - 1 ) {
                result = result + resList.get(i) + ",";
            }
            else {
                result = result + resList.get(i);
            }
        }

        fileWriter.write(result);
        fileWriter.close();

    }
}
