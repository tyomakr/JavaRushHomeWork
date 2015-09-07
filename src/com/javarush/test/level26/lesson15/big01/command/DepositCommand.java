package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        String [] arg = new String[0];
        try {
            arg = ConsoleHelper.getValidTwoDigits(code);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), code));

        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        currencyManipulator.addAmount(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]));

        System.out.println(currencyManipulator.getTotalAmount());


    }

}
