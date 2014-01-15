package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    final static int ELEMENTS = 5;

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<String>();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < ELEMENTS; i++)
        {
            list.add( 0, input.readLine() );
        }

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
