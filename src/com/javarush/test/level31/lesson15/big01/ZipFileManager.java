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

        try ( ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile)))
        {
            try( InputStream inputStream = Files.newInputStream(source))
            {
                ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
                zipOutputStream.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];

                while (inputStream.available() > 0) {
                    int size = inputStream.read(buffer);
                    zipOutputStream.write(buffer, 0, size);
                }

                zipOutputStream.closeEntry();
            }
        }
    }
}
