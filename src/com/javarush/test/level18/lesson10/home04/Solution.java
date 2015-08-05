package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        RandomAccessFile rafFile1 = new RandomAccessFile(fileName1, "rw");
        RandomAccessFile rafFile2 = new RandomAccessFile(fileName2, "r");

        //создаем буфер для первого файла и считываем в него первый файл
        byte[] bufferFile1 = new byte[(int) rafFile1.length()];
        rafFile1.read(bufferFile1);

        //создаем буфер для второго файла и считываем в него второй файл
        byte[] bufferFile2 = new byte[(int) rafFile2.length()];
        rafFile2.read(bufferFile2);

        //устанавливаем курсор на нулевую позицию в файле
        rafFile1.seek(0);

        //пишем в файл 1 содержимое файла 2 из буфера
        rafFile1.write(bufferFile2);
        //пишем в файл 1 начальное содержимое файла 1 из буфера
        rafFile1.write(bufferFile1);

        rafFile1.close();
        rafFile2.close();



    }
}
