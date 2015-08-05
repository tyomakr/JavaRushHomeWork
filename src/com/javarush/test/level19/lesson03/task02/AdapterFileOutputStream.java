package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fis;
    AdapterFileOutputStream (FileOutputStream fis) {
        this.fis = fis;
    }


    @Override
    public void flush() throws IOException {
        this.fis.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        this.fis.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        this.fis.close();
    }
}

