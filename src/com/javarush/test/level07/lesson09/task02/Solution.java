package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 5 слов в обратном порядке
Введи с клавиатуры 5 слов в список строк. Выведи их в обратном порядке.
*/

public class Solution
{
    final static int QTY = 5;

    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < QTY; i++) {
            list.add(reader.readLine());
        }

        for (int i = 0, n = QTY - 1; i < list.size(); i++, n--) {
            System.out.println(list.get(n));
        }

    }
}
