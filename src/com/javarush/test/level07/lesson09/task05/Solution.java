package com.javarush.test.level07.lesson09.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удвой слова
1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Используя цикл for выведи результат на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static int INPUT_QTY = 10;

    public static void main(String[] args) throws Exception {

        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < INPUT_QTY; i++) {
            list.add(reader.readLine());
        }

        ArrayList<String> result = doubleValues(list);


        for (String output: result) {
            System.out.println(output);
        }

    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {


        ArrayList<String> list1 = new ArrayList<String>();
        for (String value: list) {

            list1.add(value);
            list1.add(value);
        }
        return list1;
    }
}
