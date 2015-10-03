package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        List<String> strings = new ArrayList<>();


        String fileName_win1251 = args[0];
        String fileName_utf8 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName_win1251));
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName_utf8));

        while (fileReader.ready()) {
            strings.add(fileReader.readLine());
        }
        fileReader.close();

        for(String currentString : strings) {

            String s = new String(currentString.getBytes("Windows-1251"));
            printWriter.println(s);
        }
        printWriter.close();



    }
}
