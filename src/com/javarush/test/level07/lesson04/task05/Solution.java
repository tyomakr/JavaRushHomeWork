package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        int arBig [] = new int[20];
        int arSmallOne[] = new int [10];
        int arSmallTwo[] = new int [10];

        InputArray(arBig);



    }

    public static void InputArray(int[] array) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < array.length; i++) {
            String st = reader.readLine();
            array[i] = Integer.parseInt(st);
        }
    }

    public static void CopyArrays(int[] array1, int[] array2, int[]arrayResult) {



    }

    public static void PrintArray(int[] array) throws Exception {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }


}
