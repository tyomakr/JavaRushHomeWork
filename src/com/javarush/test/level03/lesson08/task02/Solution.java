package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры Имя и два числа, вывести надпись:
name1 получает «число1» денег через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String n1 = reader.readLine();
        String n2 = reader.readLine();

        int qty = Integer.parseInt(n1);
        int years = Integer.parseInt(n2);

        System.out.println(name + " " + "получает" + " " + qty + " " + "через" + " " + years + " " + "лет." );

    }
}