package com.javarush.test.level31.lesson15.big01;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {

    private Path zipFile;

    //Constructor
    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }


    //methods
    public void createZip(Path source) throws Exception {

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
            InputStream inputStream = Files.newInputStream(source)) {

            ZipEntry sourceEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(sourceEntry);

            //Считываем содержимое файла в массив byte
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);

            //Добавляем содержимое к архиву
            zipOutputStream.write(buffer);
            //Закрываем текущую запись для новой записи
            zipOutputStream.closeEntry();

        }
    }
}
