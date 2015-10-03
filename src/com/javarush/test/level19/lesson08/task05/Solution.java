package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

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

        //Вводим имя файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            reader.close();

            FileWriter fileWriter = new FileWriter(fileName);

            fileWriter.write(result);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        //Вывод в консоль
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

