package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        String resultFileName = args[0];

        List<String> fileList = new ArrayList<>();

        fileList.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileList);

        List<FileInputStream> fileInputStreamList = new ArrayList<>();

        for (int i = 0; i < fileList.size(); i++) {

            try {
                fileInputStreamList.add(new FileInputStream(fileList.get(i)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(fileInputStreamList));

        ZipInputStream zipInStream = new ZipInputStream(sequenceInputStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buf = new byte[1024 * 1024];

        while (zipInStream.getNextEntry() != null) {

            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }

        sequenceInputStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
}

