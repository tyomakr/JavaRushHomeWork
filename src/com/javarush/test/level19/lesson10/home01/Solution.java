package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
                System.out.println(entry.getKey() + " " + entry.getValue());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
