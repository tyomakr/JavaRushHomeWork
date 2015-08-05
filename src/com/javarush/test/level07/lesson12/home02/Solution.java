package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sn = reader.readLine();
        String sm = reader.readLine();

        int n = Integer.parseInt(sn);
        int m = Integer.parseInt(sm);

        ArrayList<String> str = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            str.add(reader.readLine());
        }

        Collections.rotate(str, m);

        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
        }
    }
}
