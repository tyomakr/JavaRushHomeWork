package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String c1 = reader.readLine();
        String c2 = reader.readLine();
        String c3 = reader.readLine();

        int n1 = Integer.parseInt(c1);
        int n2 = Integer.parseInt(c2);
        int n3 = Integer.parseInt(c3);

        if (n1 > n2 & n1 > n3) {
            System.out.println(n1);
            if (n2 > n3) {
                System.out.println(" " + n2 + " " + n3);
            } else {
                System.out.println(" " + n3 + " " + n2);
            }

        } else if (n2 > n1 & n2 > n3) {
            System.out.println(n2);
            if (n1 > n3) {
                System.out.println(" " + n1 + " " + n3);
            } else {
                System.out.println(" " + n3 + " " + n1);
            }

        } else if (n3 > n1 & n3 > n2) {
            System.out.println(n3);
            if (n1 > n2) {
                System.out.println(" " + n1 + " " + n2);
            } else {
                System.out.println(" " + n2 + " " + n1);
            }

        }

    }
}
