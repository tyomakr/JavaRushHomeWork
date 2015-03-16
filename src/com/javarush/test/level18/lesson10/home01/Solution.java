package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;



public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        int count = 0;
        FileInputStream iStream = new FileInputStream(fileName);

        while (iStream.available() > 0 ) {
            int data = iStream.read();
            if ((data >= Integer.valueOf('A') && data <= Integer.valueOf('Z')) || (data >= Integer.valueOf('a') && data <= Integer.valueOf('z'))) {
                count ++;
            }
        }

        iStream.close();

        System.out.println(count);



    }
}
