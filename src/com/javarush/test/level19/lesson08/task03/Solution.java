package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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

        //вычленяем символы для вывода и выводим в консоль
        String[] array = (result.replaceAll("\\D+", "").trim()).split(" ");
        int[] a = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = Integer.valueOf(array[i]);
            System.out.print(a[i]);
        }





    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
