package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception{

        //вводим имена файлов и закрываем поток
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        //открываем istream ostream
        FileInputStream iStreamFile2 = new FileInputStream(fileName2);
        FileInputStream iStreamFile3 = new FileInputStream(fileName3);
        FileOutputStream oStreamFile1 = new FileOutputStream(fileName1);

        //читаем из второго файла в первый, а после с третьего в первый
        while (iStreamFile2.available() > 0) {
            int read = iStreamFile2.read();
            oStreamFile1.write(read);
        }
        while (iStreamFile3.available() > 0) {
            int read = iStreamFile3.read();
            oStreamFile1.write(read);
        }




    }
}
