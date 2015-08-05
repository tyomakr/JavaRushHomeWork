package com.javarush.test.level07.lesson04.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 2 массива
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк,
индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.
Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int length = 10;

        String arStrings[] = new String [length];
        int arNumbers[] = new int[length];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arStrings.length; i ++) {
            arStrings[i] = reader.readLine();

        }

        for (int i = 0; i < arNumbers.length; i++) {
            arNumbers[i] = arStrings[i].length();

            System.out.println(arNumbers[i]);
        }


    }




}
