package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{

        //вводим имена файлов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        //подсчитываем сколько всего байт в файле1
        FileInputStream iStreamFile1 = new FileInputStream(fileName1);
        int sumBytesFile1 = iStreamFile1.available();


        // делим на поток на два файла
        FileOutputStream oStreamFile2 = new FileOutputStream(fileName2);
        FileOutputStream oStreamFile3 = new FileOutputStream(fileName3);

        //проверка на четность байт
        int even = iStreamFile1.available() % 2;
        int count = 0;

        //пишем в потоки
        if (even == 1) {
            while (iStreamFile1.available() > 0) {
                int read = iStreamFile1.read();
                if (count > sumBytesFile1 / 2) {
                    oStreamFile3.write(read);
                    count ++;
                }
                else {
                    oStreamFile2.write(read);
                    count ++;
                }
            }

        }
        else if (even == 0) {
            while (iStreamFile1.available() > 0) {
                int read = iStreamFile1.read();
                if (count >= sumBytesFile1 / 2) {
                    oStreamFile3.write(read);
                    count ++;
                }
                else {
                    oStreamFile2.write(read);
                    count ++;
                }
            }
        }


        iStreamFile1.close();
        oStreamFile2.close();
        oStreamFile3.close();

    }
}
