package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String iN1 = reader.readLine();
        String iN2 = reader.readLine();
        String iN3 = reader.readLine();

        int n1 = Integer.parseInt(iN1);
        int n2 = Integer.parseInt(iN2);
        int n3 = Integer.parseInt(iN3);

        System.out.println(middleNumber(n1, n2, n3));
    }

    public static int middleNumber(int a, int b, int c) {
        int tmp;
        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        if (b > c) {
            b = c;
        }
        if (a > b) {
            b = a;
        }
        return b;
    }
}
