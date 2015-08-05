package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        String m1 = "Мама";
        String m2 = "Мыла";
        String m3 = "Раму";

        System.out.println(m1 + m2 + m3);
        System.out.println(m2 + m3 + m1);
        System.out.println(m3 + m1 + m2);
        System.out.println(m2 + m1 + m3);
        System.out.println(m3 + m2 + m1);
        System.out.println(m1 + m3 + m2);

    }
}