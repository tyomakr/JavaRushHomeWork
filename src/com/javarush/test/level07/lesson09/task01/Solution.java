package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    final static int INPUT_QTY = 20;

    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> listMain = new ArrayList<Integer>();
        ArrayList<Integer> list_d3 = new ArrayList<Integer>();
        ArrayList<Integer> list_d2 = new ArrayList<Integer>();
        ArrayList<Integer> list_other = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < INPUT_QTY; i++) {
            String s = reader.readLine();
            int num = Integer.parseInt(s);
            listMain.add(num);
        }


        for (int i = 0; i < listMain.size(); i++) {

            if (listMain.get(i) % 3 == 0 && listMain.get(i) % 2 == 0) {
                list_d3.add(listMain.get(i));
                list_d2.add(listMain.get(i));
            }
            else if (listMain.get(i) % 3 == 0) {
                list_d3.add(listMain.get(i));
            }
            else if (listMain.get(i) % 2 == 0) {
                list_d2.add(listMain.get(i));
            }
            else {
                list_other.add(listMain.get(i));
            }

        }

        printList(list_d3);
        printList(list_d2);
        printList(list_other);

    }

    public static void printList(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
