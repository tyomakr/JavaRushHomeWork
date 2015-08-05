package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args)
    {
        String[] wordsArray = new String[0];
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            List<String> words = new ArrayList<>();
            while (fileReader.ready())
            {
                String line = fileReader.readLine();
                words.addAll(Arrays.asList(line.split(" ")));
            }
            fileReader.close();
            wordsArray = words.toArray(new String[words.size()]);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        StringBuilder result = getLine(wordsArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder resultStringBuilder = new StringBuilder();
        if (words == null)
            return resultStringBuilder;
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);

        int cycleCounter = 0;
        while (!wordList.isEmpty())
        {
            //находим первый случайный элемент
            if (resultStringBuilder.toString().equals(""))
            {
                int randomIndex = (int) (Math.random() * wordList.size());
                resultStringBuilder.append(wordList.get(randomIndex));
                wordList.remove(randomIndex);
            }

            //создаём временный лист для случайного перебора оставшихся элементов
            List<String> tempList = new ArrayList<>();
            tempList.addAll(wordList);
            //перебираем оставшиеся элементы в случайном порядке
            while (!tempList.isEmpty())
            {
                int randomIndex = (int) (Math.random() * tempList.size());
                String word = tempList.get(randomIndex);

                if (resultStringBuilder.toString().toLowerCase().charAt(resultStringBuilder.length() - 1) ==
                        word.toLowerCase().charAt(0))
                {
                    resultStringBuilder.append(" ").append(word);
                    //удаляем этот же элемент в основном листе
                    wordList.remove(word);
                }
                tempList.remove(randomIndex);
            }
            cycleCounter++;

            //если итераций уже прошло больше чем слов в изначальном списке, то повторяем всё заново
            if (cycleCounter > words.length)
            {
                wordList.clear();
                Collections.addAll(wordList, words);
                resultStringBuilder.delete(0, resultStringBuilder.length());
                cycleCounter = 0;
            }
        }

        return resultStringBuilder;
    }
}
