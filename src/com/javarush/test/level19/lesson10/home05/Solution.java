package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));

        while(reader.ready()){

            String str = reader.readLine();
            String[] words =  str.split(" ");

            for (int i = 0; i < words.length; i++) {

                if (words[i].matches(".*\\d.*")) {
                writer.write(words[i] + " ");
                }
            }

        }

        reader.close();
        writer.close();

    }
}
