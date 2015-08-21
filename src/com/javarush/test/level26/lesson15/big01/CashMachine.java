package com.javarush.test.level26.lesson15.big01;


import java.util.Locale;

public class CashMachine {


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        ConsoleHelper.writeMessage("Выберите операцию: ");
        ConsoleHelper.askOperation();




        /*
        String code = ConsoleHelper.askCurrencyCode();
        String [] arg = new String[0];
        try {
            arg = ConsoleHelper.getValidTwoDigits(code);

        } catch (InterruptOperationException e) {
            e.printStackTrace();
        }
        CurrencyManipulator  currentMon = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        currentMon.addAmount(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]));

        System.out.println(currentMon.getTotalAmount());

        */

    }


}
