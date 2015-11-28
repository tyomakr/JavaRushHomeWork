package com.javarush.test.level31.lesson06.home01;

import java.io.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.
Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip
Файлы внутри test.zip:
a.txt
b.txt
После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt
Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/

// !!!! Закидывать файл в архив нужно только если он там уже есть, иначе не принимается.


public class Solution {

    public static Map <ZipEntry, byte[]> entryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        File zipArchive = new File(args[1]);
        File addedFile = new File(args[0]);

        zipToMap(zipArchive);
        addNewFileToZIP(addedFile, zipArchive);
    }


    public static void zipToMap(File file)  {

        // Записываем содержимое архива в карту

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file))) {

            ZipEntry zipEntry;

            // перебираем все zipEntries
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int count;

                while ((count = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }

                byte[] bytes = byteArrayOutputStream.toByteArray();
                entryMap.put(zipEntry, bytes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addNewFileToZIP(File addedFile, File zipArchive) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipArchive)); FileInputStream fileInputStream = new FileInputStream(addedFile)) {

            ZipEntry addingFileEntry = new ZipEntry("new/" + addedFile.getName());


            //temp
            ZipEntry fileNameComparator = new ZipEntry(addedFile.getName());


            //Копируем zipEntry с entryMap в архив
            for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet()) {


                Path path = Paths.get(zipEntry.getKey().getName());
                //Сравниваем имя добавляемого файла ....
                if(!(path.getFileName().toString().equals(fileNameComparator.getName()))) {

                    //temp
                    System.out.println("файл " + path.getFileName());
                    System.out.println("Обработка файла " + zipEntry.getKey().getName());

                    /*
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey().getName()));
                    zipOutputStream.write(zipEntry.getValue());
                    */
                }

                else {

                }

            }

            /*

            zipOutputStream.putNextEntry(addingFileEntry);

            //Считываем содержимое файла в массив byte
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            //Добавляем содержимое к архиву
            zipOutputStream.write(buffer);
            //Закрываем текущую запись для новой записи
            zipOutputStream.closeEntry();

            */


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

