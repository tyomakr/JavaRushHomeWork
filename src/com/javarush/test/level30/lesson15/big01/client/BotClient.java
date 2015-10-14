package com.javarush.test.level30.lesson15.big01.client;

public class BotClient extends Client {

    // Bots counter
    private static int botsCounter = 0;


    /** PSVM **/
    public static void main(String args []) {
        new BotClient().run();
    }


    /** inner class */
    public class BotSocketThread extends SocketThread {

    }

    /** methods **/

    @Override
    protected SocketThread getSocketThread() {
        //Он должен создавать и возвращать объект класса BotSocketThread
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        //Он должен всегда возвращать false. Мы не хотим, чтобы бот отправлял текст введенный в консоль.
        return false;
    }

    @Override
    protected String getUserName() {
        // метод должен генерировать новое имя бота, например: date_bot_XX, где XX – любое число от 0 до 99.
        // Этот метод должен возвращать каждый раз новое значение, на случай, если на сервере захотят зарегистрироваться несколько ботов, у них должны быть разные имена.
        if (botsCounter == 99) {
            botsCounter = 0;
        }

        return "date_bot_" + botsCounter++;

    }
}
