package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //Запоминаем настоящий PrintStream в спец.переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем адаптер как текущий System.out
        System.setOut(stream);

        //вызываем функцию с sout
        testString.printSomething();

        //Преобразовываем записанные в ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем System.out как было изначально
        System.setOut(consoleStream);

        //вычленяем пробелы и помещаем в массив строк
        String[] stringArray = (result.trim()).split(" ");

        //Выясняем знак
        int answer = 0;
        if (stringArray[1].equals("+")) {
            answer = Solution.Addition(Conv(stringArray[0]), Conv(stringArray[2]));
        }

        else if (stringArray[1].equals("-")) {
            answer = Solution.Subtraction(Conv(stringArray[0]), Conv(stringArray[2]));

        }

        else if (stringArray[1].equals("*")) {
            answer = Solution.Multiply(Conv(stringArray[0]), Conv(stringArray[2]));
        }

        //выводим
        String rz = stringArray[0] + " " + stringArray[1] + " " + stringArray[2] + " " + stringArray[3] + " " + answer;
        System.out.println(rz);


    }

    public static int Addition (int i1, int i2) {
        int res = i1 + i2;
        return res;
    }

    public static int Subtraction (int i1, int i2) {
        int res = i1 - i2;
        return res;
    }

    public static int Multiply (int i1, int i2) {
        int res = i1 * i2;
        return res;
    }


    public static int Conv (String s) {
        Integer i  = new Integer(s);
        return i;
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

