package com.javarush.test.level16.lesson10.task02;

/* Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с countSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды и более, прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].
Пример для countSeconds=4 : [4 3 2 1 Прервано!]
4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для countSeconds=3 : [3 2 1 Марш!]
PS: метод sleep выбрасывает InterruptedException.
*/

import java.io.IOException;

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException, IOException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут

        Thread.sleep(3500);
        if (clock.isAlive())
        {
            clock.interrupt();
        }


    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try{
                long startTime = System.currentTimeMillis();
                while (countSeconds > 0)
                {
                    System.out.print(countSeconds + " ");
                    Thread.sleep(1000);
                    countSeconds--;

                }
                System.out.println("Марш!");
            }catch (InterruptedException e)
            {
                System.out.println("Прервано!");
            }
        }
    }

}
