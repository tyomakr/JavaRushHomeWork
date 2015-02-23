package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream iStream = new FileInputStream(fileName);

        ArrayList<Integer> streamList = new ArrayList<>();
        Map <Integer, Integer> map = new HashMap<>();


        //записываем байты в лист
        while (iStream.available() > 0) {
            streamList.add(iStream.read());
        }

        //считаем кол-во повторов и пишем в map



    }
}
