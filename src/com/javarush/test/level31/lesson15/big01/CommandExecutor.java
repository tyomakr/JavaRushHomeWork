package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.Command;
import java.util.Map;

public class CommandExecutor {

    private CommandExecutor() {
    }

    private static Map<Operation, Command> allKnownCommandsMap;

    public void execute(Operation operation) throws Exception {

    }
}
