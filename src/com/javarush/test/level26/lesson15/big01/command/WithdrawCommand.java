package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class WithdrawCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {


        ConsoleHelper.writeMessage("Введите код валюты: ");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator curManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int sum;

        while (true) {
            ConsoleHelper.writeMessage("Введите сумму: ");
            String str = ConsoleHelper.readString();

            try {
                sum = Integer.parseInt(str);
            } catch (NumberFormatException e ) {
                ConsoleHelper.writeMessage("Неверный ввод");
                continue;
            }
            if (sum <= 0) {
                ConsoleHelper.writeMessage("Введите правильное значение");
                continue;
            }


        }


    }


}
