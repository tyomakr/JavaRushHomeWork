package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        String fileName1;
        String fileName2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            reader.close();


            FileReader fileReader = new FileReader(fileName1);
            FileWriter fileWriter = new FileWriter(fileName2);

            List<Integer> list = new ArrayList<>();
            while (fileReader.ready()) {
                list.add(fileReader.read());
            }
            fileReader.close();

            for (int i = 1; i < list.size(); i = i + 2) {
                fileWriter.write((char)(int)list.get(i));
            }
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
