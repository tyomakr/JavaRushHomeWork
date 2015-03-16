package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        int count = 0;
        int spaces = 0;
        double res = 0;

        if(args.length > 0){
            FileInputStream in = new FileInputStream(args[0]);

            while(in.available() > 0){
                count++;
                int data = in.read();

                if(data == Integer.valueOf(' ')){
                    spaces++;
                }
            }

            in.close();
        }

        if(count == 0){

        } else {
            res = (double)spaces / count * 100;
        }

        System.out.printf("%.2f", res);
    }
}
