package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream iStream = new FileInputStream(fileName);

        long minByte = 1000;

        while (iStream.available() > 0) {
            int rByte = iStream.read();
            if (rByte <= minByte) {
                minByte = rByte;
            }
        }
        iStream.close();

        System.out.println(minByte);

    }
}
