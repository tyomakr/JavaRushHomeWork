package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    // ключ -имя клиента, а значение - соединение с ним
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    /** MAIN **/
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        try {
            // вводим порт
            serverSocket = new ServerSocket(ConsoleHelper.readInt());
            ConsoleHelper.writeMessage("Сервер запущен");


            while (true) {
                //Слушаем
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                //запускаем handler
                handler.start();
            }

        } catch (Exception e) {

            serverSocket.close();
            e.printStackTrace();
        }

    }


    /** отправка сообщения для всех **/
    public static void sendBroadcastMessage(Message message) {

        try {

            for (Connection connection : connectionMap.values()) {
                connection.send(message);
            }

        } catch (Exception e){
            e.printStackTrace();
            ConsoleHelper.writeMessage("Сообщение не отправлено");
        }

    }


    /**обработчик Handler, в котором будет происходить обмен сообщениями с клиентом **/
    private static class Handler extends Thread {

        private Socket socket;

        //Constructor
        public Handler(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {

            ConsoleHelper.writeMessage("Установленно соединение с адресом " + socket.getRemoteSocketAddress());

            try {
                //Создаем Connection
                Connection connection = new Connection(socket);

                serverHandshake(connection);




            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            /*
11.2.	Создавать Connection, используя поле Socket
11.3.	Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового
клиента
11.4.	Рассылать всем участникам чата информацию об имени присоединившегося
участника (сообщение с типом USER_ADDED). Подумай, какой метод подойдет для
этого лучше всего.
11.5.	Сообщать новому участнику о существующих участниках
11.6.	Запускать главный цикл обработки сообщений сервером
11.7.	Обеспечить закрытие соединения при возникновении исключения
11.8.	Отловить все исключения типа IOException и ClassNotFoundException, вывести в
консоль информацию, что произошла ошибка при обмене данными с удаленным
адресом
11.9.	После того как все исключения обработаны, если п.11.3 отработал и возвратил
нам имя, мы должны удалить запись для этого имени из connectionMap и разослать
всем остальным участникам сообщение с типом USER_REMOVED и сохраненным
именем.
11.10.	Последнее, что нужно сделать в методе run() – вывести сообщение,
информирующее что соединение с удаленным адресом закрыто.
Наш сервер полностью готов. Попробуй его запустить.
             */

        }

        /** Handshake **/
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                // Сформировать и отправить команду запроса имени пользователя
                connection.send(new Message(MessageType.NAME_REQUEST));
                // Получить ответ клиента
                Message message = connection.receive();

                // Проверить, что получена команда с именем пользователя
                if (message.getType() == MessageType.USER_NAME) {

                    //Достать из ответа имя, проверить, что оно не пустое
                    if (message.getData() != null && !message.getData().isEmpty()) {

                        // и пользователь с таким именем еще не подключен (используй connectionMap)
                        if (connectionMap.get(message.getData()) == null) {

                            // Добавить нового пользователя и соединение с ним в connectionMap
                            connectionMap.put(message.getData(), connection);
                            // Отправить клиенту команду информирующую, что его имя принято
                            connection.send(new Message(MessageType.NAME_ACCEPTED));

                            // Вернуть принятое имя в качестве возвращаемого значения
                            return message.getData();
                        }
                    }
                }
            }
        }


        /** Отправка списка всех пользователей **/
        private void sendListOfUsers(Connection connection, String userName) throws IOException {

            for (String key : connectionMap.keySet()) {
                Message message = new Message(MessageType.USER_ADDED, key);

                if (!key.equals(userName)) {
                    connection.send(message);
                }
            }
        }


        /** Главный цикл обработки сообщений сервером **/
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true) {

                Message message = connection.receive();
                // Если принятое сообщение – это текст (тип TEXT)
                if (message.getType() == MessageType.TEXT) {

                    String s = userName + ": " + message.getData();

                    Message formattedMessage = new Message(MessageType.TEXT, s);
                    sendBroadcastMessage(formattedMessage);
                } else {
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }
    }
}


