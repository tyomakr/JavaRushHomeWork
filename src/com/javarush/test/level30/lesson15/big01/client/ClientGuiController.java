package com.javarush.test.level30.lesson15.big01.client;


public class ClientGuiController extends Client {

    // Создай и проинициализируй поле, отвечающее за модель ClientGuiModel model.
    private ClientGuiModel model = new ClientGuiModel();

    // Создай и проинициализируй поле, отвечающее за представление ClientGuiView view.
    // Подумай, что нужно передать в конструктор при инициализации объекта
    private ClientGuiView view = new ClientGuiView(this);


    /** PSVM **/
    public static void main(String[] args) {

        ClientGuiController controller = new ClientGuiController();
        controller.run();
    }


    /** methods **/
    // должен создавать и возвращать объект типа GuiSocketThread.
    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    // должен получать объект SocketThread через метод getSocketThread()и вызывать у него метод run().
    // Разберись, почему нет необходимости вызывать метод run в отдельном потоке, как мы это делали для консольного клиента.
    @Override
    public void run() {
        getSocketThread().run();
    }

    // Объяви метод ClientGuiModel getModel(), который должен возвращать модель.
    public ClientGuiModel getModel() {
        return model;
    }

    //getters
    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    /** inner class GuiSocketThread**/
    //Добавь внутренний класс GuiSocketThread унаследованный от SocketThread. Класс GuiSocketThread должен быть публичным.
    public class GuiSocketThread extends SocketThread {


        // должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
        @Override
        protected void processIncomingMessage(String message) {

            model.setNewMessage(message);
            view.refreshMessages();
        }

        // должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.
        @Override
        protected void informAboutAddingNewUser(String userName) {

            model.addUser(userName);
            view.refreshUsers();
        }

        // должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
        @Override
        protected void informAboutDeletingNewUser(String userName) {

            model.deleteUser(userName);
            view.refreshUsers();
        }

        // должен вызывать аналогичный метод у представления.
        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

}
