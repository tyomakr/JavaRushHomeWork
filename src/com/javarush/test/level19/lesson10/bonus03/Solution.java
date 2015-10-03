package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/


import java.io.*;
import java.nio.file.Files;



public class Solution {
    public static void main(String[] args) throws IOException {

        String tag = args[0];
        String fileName;

        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        fileName = rd.readLine();
        rd.close();

        String text = readFile(fileName);

        stringBuilder = stringBuilder.append(text);
        text = stringBuilder.toString().replaceAll("\r\n", "");


        findTags(tag, text, 0);

    }

    public static void findTags(String tag, String text, int q)
    {
        int howManyTag = 0, lastTagsIndex = 0;
        int i = q;
        while (i < (text.length() - tag.length() - 1))
        {
            if (text.substring(i, i + tag.length() + 1).equals("<" + tag))
            {
                if (howManyTag == 0) lastTagsIndex = i;
                howManyTag++;
            }
            else if (text.substring(i, i + tag.length() + 2).equals("</" + tag))
            {
                howManyTag--;
                if (howManyTag == 0)
                {
                    String newString = text.substring(lastTagsIndex, i + tag.length() +3);
                    System.out.println(newString);
                    findTags(tag, newString, 1);
                }
            }
            i++;
        }
    }





    public static String readFile(String filename) {
        File f = new File(filename);
        try {
            byte[] bytes = Files.readAllBytes(f.toPath());
            return new String(bytes,"UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
