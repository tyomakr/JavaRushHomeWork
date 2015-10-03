package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        String fileName;
        int count = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            fileName = reader.readLine();
            reader.close();

            FileReader fileReader = new FileReader(fileName);

            Pattern pattern = Pattern.compile("\\bworld\\b", Pattern.CASE_INSENSITIVE);
            String str = "";

            while (fileReader.ready()) {
                str = str + (char) fileReader.read();
            }
            fileReader.close();

            //System.out.println(str);

            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                count++;
            }


            System.out.println(count);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
