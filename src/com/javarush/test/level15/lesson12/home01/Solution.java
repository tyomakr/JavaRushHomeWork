package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String str = reader.readLine();

            if (str.equals("exit")) {
                break;
            }
            else if (str.contains(".")) {
                print(Double.parseDouble(str));
            }
            else if (isShort(str)) {
                print(Short.parseShort(str));
            }
            else if (isInteger(str)) {
                print(Integer.parseInt(str));
            }
            else {
                print(str);
            }
        }
        reader.close();

    }

    public static boolean isShort (String str) {
        try {
            if ((Integer.parseInt(str) > 0)&&(Integer.parseInt(str) < 128)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean isInteger (String str)
    {
        try {
            if (Integer.parseInt(str)>=128) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
