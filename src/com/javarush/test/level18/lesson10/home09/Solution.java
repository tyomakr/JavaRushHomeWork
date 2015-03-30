package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        String fileName = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            try {
                fileName = reader.readLine();
                FileInputStream iStream = new FileInputStream(fileName);

            } catch (FileNotFoundException e1) {
                System.out.println(fileName);
                break;
            } catch (IOException e2) {
                e2.printStackTrace();
            }

        }

    }
}
