package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();


        FileInputStream iStream = new FileInputStream(fileName);

        int countByte;
        int countSymbol = 0;

        while (iStream.available() > 0) {
            countByte = iStream.read();
            if (countByte == 44) {
                countSymbol += 1;
            }
        }

        System.out.println(countSymbol);

        reader.close();
        iStream.close();
    }
}
