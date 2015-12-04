package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;
import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    // Полный путь zip файла
    private final Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        // Проверяем, существует ли директория, где будет создаваться архив
        // При необходимости создаем ее
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory))
            Files.createDirectories(zipDirectory);

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isDirectory(source)) {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                // Добавляем каждый файл в архив
                for (Path fileName : fileNames)
                    addNewZipEntry(zipOutputStream, source, fileName);

            } else if (Files.isRegularFile(source)) {

                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else {

                // Если переданный source не директория и не файл, бросаем исключение
                throw new PathIsNotFoundException();
            }
        }
    }

    public List<FileProperties> getFilesList() throws Exception {
        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        List<FileProperties> files = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                // Поля "размер" и "сжатый размер" не известны, пока элемент не будет прочитан
                // Давайте вычитаем его в какой-то выходной поток
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                copyData(zipInputStream, baos);

                FileProperties file = new FileProperties(zipEntry.getName(), zipEntry.getSize(), zipEntry.getCompressedSize(), zipEntry.getMethod());
                files.add(file);
                zipEntry = zipInputStream.getNextEntry();
            }
        }

        return files;
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    public void extractAll(Path outputFolder) throws Exception {

        //Проверь, есть ли zip файл вообще
        if (Files.notExists(zipFile)) {
            throw new WrongZipFileException();
        }
        //Если директория outputFolder не существует, то ее нужно создать, как и все папки, внутри которых она лежит.
        if (Files.notExists(outputFolder)) {
            Files.createDirectories(outputFolder);
        }

        ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));
        ZipEntry entry;

        while ((entry = zipInputStream.getNextEntry()) != null) {
            Path path = outputFolder.resolve(entry.getName());

            if (entry.isDirectory()) {
                Files.createDirectories(path.getParent());
            }

            else {
                Files.createDirectories(path.getParent());
                OutputStream fileOutputStream = Files.newOutputStream(path);
                copyData(zipInputStream, fileOutputStream);
                fileOutputStream.close();
            }
        }
        zipInputStream.close();

    }

}

/*
Пора попробовать что-нибудь распаковать. Для этого добавим публичный метод void extractAll(Path
outputFolder) throws Exception в класс ZipFileManager. Path outputFolder  - это путь, куда мы будем
распаковывать наш архив. У тебя уже большой опыт работы с элементами архива и потоками. Так что, я
дам только подсказки по реализации этого метода, а тебе придется хорошенько подумать, как это все
сделать:
1.	Проверь, есть ли zip файл вообще
2.	Если директория outputFolder не существует, то ее нужно создать, как и все папки, внутри которых
она лежит.
3.	Внутри архива некоторые файлы могут лежат внутри папок, тогда метод getName() элемента
архива ZipEntry, вернет не совсем имя, как может показаться из названия, а относительный путь
внутри архива. Этот относительный путь должен сохраниться и после распаковки, но уже
относительно той директории, куда мы распаковали архив
4.	Реализуй метод execute() класса ZipExtractCommand, по аналогии с таким же методом класса
ZipCreateCommand, сделай такой же блок try-catch, только поменяй сообщения выводимые
пользователю, чтобы он понял, что сейчас мы будем распаковывать архив, и что нужно ввести
полное имя архива и директорию, куда будем распаковывать. Не забудь вызвать метод extractAll
класса ZipFileManager, а не createZip, как это было в ZipCreateCommand
5.	Запускай программу и наслаждайся результатом распаковки
 */