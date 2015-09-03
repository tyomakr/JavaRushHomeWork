package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class ExitCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("\nExit ?  (y/n)");

        if (ConsoleHelper.readString().equals("yes"))
            ConsoleHelper.writeMessage("ShutDown...");
    }


}
