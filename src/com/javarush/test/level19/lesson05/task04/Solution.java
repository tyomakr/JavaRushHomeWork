package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        String fileName1;
        String fileName2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

            while (fileReader.ready()) {
                String str = fileReader.readLine();
                str = str.replaceAll("[.]", "!");
                fileWriter.write(str);
                fileWriter.newLine();
            }

            fileReader.close();
            fileWriter.close();

        } catch (Exception e ) {
            e.printStackTrace();
        }

    }
}
