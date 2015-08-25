package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class DepositCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {

        String code = ConsoleHelper.askCurrencyCode();
        String [] arg = new String[0];
        try {
            arg = ConsoleHelper.getValidTwoDigits(code);

        } catch (InterruptOperationException e) {
            e.printStackTrace();
        }
        CurrencyManipulator currentMon = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        currentMon.addAmount(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]));

        System.out.println(currentMon.getTotalAmount());


    }

}
