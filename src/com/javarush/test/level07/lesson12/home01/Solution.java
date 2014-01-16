package com.javarush.test.level07.lesson12.home01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Вывести числа в обратном порядке
Ввести с клавиатуры 10 чисел и заполнить ими список.
Вывести их в обратном порядке.
Использовать только цикл for.
*/

public class Solution
{
    final static int QTY = 10;

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < QTY; i++ ) {
            String st = reader.readLine();
            numbers.add(Integer.parseInt(st));
        }

        for (int i = 0, n = numbers.size()-1; i < numbers.size(); i++, n--) {
            System.out.println(numbers.get(n));
        }
    }
}
