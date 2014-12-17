package com.javarush.test.level12.lesson12.home09;

/* Родитель класса CTO
Добавь такой класс-родитель к классу CTO(технический директор), чтобы класс перестал быть абстрактным.
Добавлять/реализовывать методы в классе CTO запрещается.
*/

public class Solution
{

    public static void main(String[] args)
    {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman
    {
        public void workHard();
    }

    public static class bm {
        public void workHard() {

        }
    }

    public static class CTO extends bm implements Businessman
    {

    }


}
