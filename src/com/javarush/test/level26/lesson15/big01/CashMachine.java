package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.Locale;

public class CashMachine {

    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args)  {
        Locale.setDefault(Locale.ENGLISH);

        try
        {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;

            do
            {
                ConsoleHelper.writeMessage("\nSelect Operation: \n1)Info\n2)Deposit\n3)Withdraw\n4)Exit\n");
                operation = ConsoleHelper.askOperation();

                CommandExecutor.execute(operation);
            }
            while (operation != Operation.EXIT);
        }
        catch (InterruptOperationException e) {

            try {

                CommandExecutor.execute(Operation.EXIT);
            }
            catch (InterruptOperationException ignored) {
            }
        }
    }
}
