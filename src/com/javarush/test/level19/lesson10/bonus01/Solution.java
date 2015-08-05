package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        List<String> stringsFile1 = new ArrayList<>();      //сюда будем писать строки из первого файла
        List<String> stringsFile2 = new ArrayList<>();      //а сюда из второго

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = rd.readLine();
        String fileName2 = rd.readLine();
        rd.close();

        BufferedReader file1Reader = new BufferedReader(new FileReader(fileName1));
        BufferedReader file2Reader = new BufferedReader(new FileReader(fileName2));

        stringsReader(file1Reader, stringsFile1);           //считываем строки в лист
        file1Reader.close();
        stringsReader(file2Reader, stringsFile2);
        file2Reader.close();

        int f1 = 0;
        int f2 = 0;

        while (f1 < stringsFile1.size() && f2 < stringsFile2.size()) {

            //Если значения равны
            if (stringsFile1.get(f1).equals(stringsFile2.get(f2))) {
                linesAddSAME(stringsFile1.get(f1));
                f1++;
                f2++;
            }
            //если в первом файле существует след.строка и эта след.строка равна текущей во втором файле
            else if (stringsFile1.size() > f1 + 1 && stringsFile1.get(f1 + 1).equals(stringsFile2.get(f2))) {
                linesAddREMOVED(stringsFile1.get(f1));
                f1++;
            }
            //если во втором файле существует след.строка и эта след.строка равна текущей в первом файле
            else if (stringsFile2.size() > f2 + 1 && stringsFile2.get(f2 + 1).equals(stringsFile1.get(f1))) {
                linesAddADDED(stringsFile2.get(f2));
                f2++;
            }

        }
        if (f1 < stringsFile1.size()) {
            linesAddREMOVED(stringsFile1.get(f1));
        }
        if (f2 < stringsFile2.size()) {
            linesAddADDED(stringsFile2.get(f2));
        }


        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i).type.toString() + " " + lines.get(i).line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    public static void stringsReader (BufferedReader reader, List<String> list) throws IOException {

        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
    }

    public static void linesAddSAME (String line) {
        lines.add(new LineItem(Type.SAME, line));
    }

    public static void linesAddADDED (String line) {
        lines.add(new LineItem(Type.ADDED, line));
    }

    public static void linesAddREMOVED (String line) {
        lines.add(new LineItem(Type.REMOVED, line));
    }


}
