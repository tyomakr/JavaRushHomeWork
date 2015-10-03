package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";
        public A() { }
        public A(String name) {
            this.name += name;
        }
    }
    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void writeObject (ObjectOutputStream out) throws Exception{
            out.defaultWriteObject();
            out.writeObject(name);
            out.flush();
        }
        private void readObject (ObjectInputStream in) throws Exception {
            in.defaultReadObject();
            this.name = (String) in.readObject();
        }
    }
}