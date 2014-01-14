package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int arNumbers[] = new int [10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arNumbers.length; i++) {

            String st = reader.readLine();
            arNumbers [i] = Integer.parseInt(st);
        }

         for(int i = 0, n = arNumbers.length - 1; i < n; ++i, --n) {
            int temp = arNumbers[i];
            arNumbers[i] = arNumbers[n];
            arNumbers[n] = temp;
        }

        for (int i = 0; i < arNumbers.length; i++) {
            System.out.println(arNumbers[i]);

        }
    }
}