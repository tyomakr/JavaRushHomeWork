package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


class LoginCommand implements Command {

    String cardNumber = "123456789012";
    String pin = "1234";

    @Override
    public void execute() throws InterruptOperationException {


        String tempCardNumber;
        String tempPin;


        while (true) {

            ConsoleHelper.writeMessage("Введите номер карты и пин");
            tempCardNumber = ConsoleHelper.readString();
            tempPin = ConsoleHelper.readString();

            if (tempCardNumber.length() != 12) {
                ConsoleHelper.writeMessage("Неверный номер карты");
                continue;
            }
            else if (tempPin.length() != 4) {
                ConsoleHelper.writeMessage("Неверный пин");
                continue;
            }

            else {
                if (cardNumber.equals(tempCardNumber) && pin.equals(tempPin)) {
                    ConsoleHelper.writeMessage("Верификация пройдена успешно");
                    break;
                }

            }

        }

    }
}


