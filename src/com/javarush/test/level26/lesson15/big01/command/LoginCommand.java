package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.ResourceBundle;


class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {

        String cardNumber;
        String pin;


        while (true) {

            ConsoleHelper.writeMessage("Enter CardNumber and PIN");
            cardNumber = ConsoleHelper.readString();
            pin = ConsoleHelper.readString();

            if (validCreditCards.containsKey(cardNumber)) {

                if (validCreditCards.getString(cardNumber).equals(pin)) {
                    ConsoleHelper.writeMessage("Verification complete successfully");
                    break;
                }
                else {
                    ConsoleHelper.writeMessage("Incorrect data");
                }
            }
            else {
                ConsoleHelper.writeMessage("Incorrect data");
            }
        }
    }
}


