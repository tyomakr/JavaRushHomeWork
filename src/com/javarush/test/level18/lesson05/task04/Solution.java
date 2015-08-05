package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        ArrayList<Integer> byteData = new ArrayList<>();

        FileInputStream iStream = new FileInputStream(fileName1);

        while (iStream.available() > 0) {
            byteData.add(iStream.read());
        }

        Collections.reverse(byteData);


        FileOutputStream oStream = new FileOutputStream(fileName2);
        for (int i = 0; i < byteData.size(); i++) {
            oStream.write(byteData.get(i));
        }

        iStream.close();
        oStream.close();

    }
}
