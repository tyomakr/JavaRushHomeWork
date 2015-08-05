package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {


        String fileName = args[0];
        Map<String, Double> map = new TreeMap<>();
        double num = 0;
        double max = 0;
        String entryMax = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");

                num = Double.parseDouble(line[1]);

                if (map.containsKey(line[0])) {
                    num = num + map.get(line[0]);
                    map.put(line[0], num);
                }
                else {
                    map.put(line[0], num);
                }

            }
            reader.close();

            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    entryMax = entry.getKey();
                }
            }

            System.out.println(entryMax);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
