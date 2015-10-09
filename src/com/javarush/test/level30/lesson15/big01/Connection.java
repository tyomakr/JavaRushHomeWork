package com.javarush.test.level30.lesson15.big01;


import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Closeable {

    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;


    //Constructor
    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }


    public void send(Message message) throws IOException {                             ///????

        synchronized (out) {
            out.writeObject(message);
            out.flush();

        }

    }


    public Message receive() throws IOException, ClassNotFoundException {                 ///????

        Message message;

        synchronized (in) {
            message = (Message)in.readObject();
            return message;
        }

    }


    public SocketAddress getRemoteSocketAddress() {

        return socket.getRemoteSocketAddress();
    }


    public void close() throws IOException {

        in.close();
        out.close();
        socket.close();
    }



}
/*
“ак! ¬ потоке каждого сокета храним очередь?!! ј отдельный поток будет читать эти очереди??!!
“огда вопрос каким образом оптимальнее(быстрее) проводить эту пердачу?
я вот передаю так:
private void messageToObjectOutput(Message mes) throws IOException {
ObjectOutputStream oos = new ObjectOutputStream(pout);
synchronized(mes) {
oos.writeObject(mes);
oos.flush();
pout.flush();
}
}
pout это PipedOutputStream

а принимаю : ObjectInputStream ois = new ObjectInputStream(pin);
Message mes = (Message)ois.readObject(); pin PipedInputStream
 */

/*
ƒобавь в класс Connection:

5.3.	ћетод void send(Message message) throws IOException. ќн должен записывать
(сериализовать) сообщение message в ObjectOutputStream. Ётот метод будет
вызыватьс€ из нескольких потоков. ѕозаботьс€, чтобы запись в объект
ObjectOutputStream была возможна только одним потоком в определенный момент
времени, остальные желающие ждали завершени€ записи. ѕри этом другие методы
класса Connection не должны быть заблокированы.


5.4.	ћетод Message receive() throws IOException, ClassNotFoundException. ќн должен читать
(десериализовать) данные из ObjectInputStream. —делай так, чтобы операци€ чтени€
не могла быть одновременно вызвана несколькими потоками, при этом вызов других
методы класса Connection не блокировать.

5.5.	ћетод SocketAddress getRemoteSocketAddress(), возвращающий удаленный адрес
сокетного соединени€.
5.6.	ћетод void close() throws IOException, который должен закрывать все ресурсы класса.
 ласс Connection должен реализовывать интерфейс Closeable.
 */