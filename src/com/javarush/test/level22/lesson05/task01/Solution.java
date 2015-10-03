package com.javarush.test.level22.lesson05.task01;


/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {


    public static String getPartOfString(String string) throws TooShortStringException{

        if (string == null) {
            throw new TooShortStringException();
        }

        String str[] = string.split(" ");

        if (str.length < 5 ) {
            throw new TooShortStringException();
        }

        String s = str[1] + " " + str[2] + " " + str[3] + " " + str[4];

        return s;
    }

    public static class TooShortStringException extends Exception{
    }
}
