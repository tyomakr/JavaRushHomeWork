package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream iStream = new FileInputStream(fileName1);
        FileOutputStream oStream = new FileOutputStream(fileName2);

        //создаем буфер, в который помещаем содержимое первого файла
        byte[] buffer = new byte[iStream.available()];
        iStream.read(buffer);

        oStream.write(calculate(buffer));

        iStream.close();
        oStream.close();

    }

    private static byte[] calculate(byte[] buff) {

        StringBuilder sBuilder = new StringBuilder();
        //создаем массив, заполняем его данными из буфера, используя в качестве разделителя пробелы
        String[] arrData = new String(buff).split(" ");
        //создаем массив для результатов
        byte[] result;
        //создаем временный массив для вычислений,
        long[] temp = new long[arrData.length];

        //округляем каждый элемент массива arrData и записываем его во временный массив
        for (int i = 0; i < arrData.length; i++) {
            temp[i] = Math.round(Double.valueOf(arrData[i]));
        }

        //добавляем пробелы
        for(long i : temp) {
            sBuilder.append(i);
            sBuilder.append(" ");
        }

        result = sBuilder.toString().getBytes();


        return result;
    }
}
