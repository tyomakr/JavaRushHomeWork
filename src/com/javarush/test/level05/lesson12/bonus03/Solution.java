package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       int numbers[];
        int quantity;
        Scanner input = new Scanner(System.in);
        quantity = input.nextInt();
        numbers = new int[quantity];

        for (int i = 0; i < quantity; i++) {
            numbers[i] = input.nextInt();
        }

        int maximum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (maximum < numbers[i]) {
                maximum = numbers[i];
            }
        }

        System.out.println(maximum);

    }
}
