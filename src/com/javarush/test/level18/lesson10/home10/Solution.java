package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception{

        String fileName;
        String path;
        Set<File> filesSet = new TreeSet<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //считываем имена файлов и пишем их в treeset + сортировка внутри
        while (!(fileName = reader.readLine()).equals("end")) {
            File file = new File(fileName);
            filesSet.add(file);
        }

        //выясняем папку и путь к файлу
        Iterator<File> iterator = filesSet.iterator();
        path = iterator.next().getAbsolutePath();
        path = path.substring(0, path.length() - 6);

        //cоздаем файл, в который будем записывать, без приставки part#
        FileOutputStream resFile = new FileOutputStream(path, true);

        for (File file : filesSet) {
            FileInputStream iStream = new FileInputStream(file);
            byte[] buffer = new byte[iStream.available()];

            while (iStream.available() > 0) {
                iStream.read(buffer);
                resFile.write(buffer);
            }
            iStream.close();
        }
        resFile.close();


    }
}
