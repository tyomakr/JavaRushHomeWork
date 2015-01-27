package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // вводим урл в консоль
        String url = reader.readLine();
        // закрываем поток
        reader.close();

        //переменная, обозначающая начало первого параметра после вопросительного знака
        //substring возврашает новую строку, которая является подстрокой этой строки.
        //indexOf возвращает индексирование в пределах этой строки первого возникновения указанного символа.
        String qMarked = url.substring(url.indexOf("?")+1);

        // массив
        // split - разделение этой строки вокруг соответствий данного регулярного выражения.
        String [] arrT = qMarked.split("(\\&+)|(\\?+)");

        //коллекция для параметров типа obj
        ArrayList<String> objList = new ArrayList<String>();
        //Компилируем регулярное выражение через паттерн
        Pattern objPattern = Pattern.compile("^obj=.*");

        for(String a: arrT) {
            if (!a.equals("")) {
                //делаем матчер по созданному паттерну
                Matcher matcher = objPattern.matcher(a);
                if(matcher.find()) {
                    objList.add(a.substring(a.indexOf("=")+1));
                }
                if(a.contains("=")) {
                    System.out.println(a.substring(0,(a.indexOf("=")))+ " ");
                }
                else {
                    System.out.println(a + " ");
                }
            }
        }

        Pattern doublePatt = Pattern.compile("[0-9.]");
        Pattern stringPatt = Pattern.compile("[A-Za-z]");



        for (String a:objList) {
            Matcher matcherS = stringPatt.matcher(a);
            Matcher matcherD = doublePatt.matcher(a);

            if(matcherS.find()) {
                alert(a);
            }
            else if(matcherD.find()) {
                alert(Double.parseDouble(a));
            }
        }
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
