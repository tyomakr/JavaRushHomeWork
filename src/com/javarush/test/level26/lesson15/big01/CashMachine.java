package com.javarush.test.level26.lesson15.big01;


import java.util.Locale;

public class CashMachine {


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        ConsoleHelper.writeMessage("Выберите операцию: ");
        ConsoleHelper.askOperation();



    }


}
