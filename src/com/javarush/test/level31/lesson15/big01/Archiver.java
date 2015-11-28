package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите полный путь к архиву: ");
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(reader.readLine()));

            System.out.println("Введите путь к архивируемому файлу: ");
            zipFileManager.createZip(Paths.get(reader.readLine()));

            reader.close();

            ExitCommand exitCommand = new ExitCommand();
            exitCommand.execute();


        } catch (Exception e) {}
    }
}
