package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;


    /** Methods **/
    /** Должен запросить ввод адреса сервера и вернуть введенное значение**/
    protected String getServerAddress() {

        ConsoleHelper.writeMessage("Введите адрес сервера: ");
        return ConsoleHelper.readString();
    }


    /** Должен запрашивать ввод порта сервера и возвращать его **/
    protected int getServerPort() {

        ConsoleHelper.writeMessage("Введите порт сервера: ");
        return ConsoleHelper.readInt();
    }


    /** Должен запрашивать и возвращать имя пользователя **/
    protected String getUserName() {

        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        return ConsoleHelper.readString();
    }


    protected boolean shouldSentTextFromConsole() {

        return true;
    }


    /** должен создавать и возвращать новый объект класса SocketThread **/
    protected SocketThread getSocketThread() {

        return new SocketThread();
    }


    /**  создает новое текстовое сообщение, используя переданный текст и отправляет его серверу через соединение connection **/
    protected void sendTextMessage(String text) {

        try {
            connection.send(new Message(MessageType.TEXT, text));

        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки");
            clientConnected = false;
        }

    }


    /** SocketThread **/
    public class SocketThread extends Thread {

    }

}
