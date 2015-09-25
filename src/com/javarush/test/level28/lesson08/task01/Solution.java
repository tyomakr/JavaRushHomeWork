package com.javarush.test.level28.lesson08.task01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* Знакомство с Executors
1. В методе main создай фиксированный пул из 5 трэдов используя класс Executors.
2. В цикле отправь на исполнение в пул 10 тасок Runnable.
3. У каждой таски в методе run вызови метод doExpensiveOperation с порядковым номером таски начиная с 1, см. пример вывода
4. Запрети добавление новых тасок на исполнение в пул (метод shutdown)
5. Дай экзэкьютору 5 секунд на завершение всех тасок (метод awaitTermination и параметр TimeUnit.SECONDS)
Не должно быть комментариев кроме приведенного output example
*/
public class Solution {

    private static volatile int id = 1;

    public static void main(String[] args) throws InterruptedException {


        ExecutorService service = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 10; i ++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(id ++);
                }
            });
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
        }



        /* output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
