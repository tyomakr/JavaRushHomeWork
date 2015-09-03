package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


class LoginCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {

        String cardNumber = "123456789012";
        String pin = "1234";
        String tempCardNumber;
        String tempPin;


        while (true) {

            ConsoleHelper.writeMessage("Enter CardNumber and PIN");
            tempCardNumber = ConsoleHelper.readString();
            tempPin = ConsoleHelper.readString();

            if (tempCardNumber.matches("\\d{12}") && tempCardNumber.length() == 12 && tempPin.matches("\\d{4}") && tempPin.length() == 4) {

                if (tempCardNumber.equals(cardNumber) && tempPin.equals(pin)) {
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


