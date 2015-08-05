package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream iStream = new FileInputStream(fileName);
        ArrayList<Integer> streamList = new ArrayList<>();


        //записываем байты в лист
        while (iStream.available() > 0) {
            streamList.add(iStream.read());
        }
        iStream.close();


        List<Integer> resultList = new ArrayList<Integer>(new HashSet<Integer>(streamList));

        Collections.sort(resultList);

        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i) + " ");
        }


    }
}
