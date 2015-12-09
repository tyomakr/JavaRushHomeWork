package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.Serializable;
import java.util.Objects;


public class Entry implements Serializable {

    long key;
    String value;
    Entry next;
    int hash;


    public Entry(int hash, long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }


    public long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }


    public int hashCode() {

        return Objects.hashCode(getKey());
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value='" + value + '\'' +
                ", next=" + next +
                ", hash=" + hash +
                '}';
    }
}
/*
Приступим к реализации второй стратегии OurHashMapStorageStrategy. Она не будет
использовать готовый HashMap из стандартной библиотеки, а будет сама являться
коллекцией.
7.1.	Разберись как работает стандартный HashMap, посмотри его исходники или
погугли статьи на эту тему.
7.2.	Если ты честно выполнил предыдущий пункт, то ты знаешь для чего используется
класс Entry внутри HashMap. Создай свой аналог класса Entry внутри пакета
strategies. Это должен быть обычный, не вложенный, не generic класс. Сделай его публичным.
В отличии от класса Entry  из HashMap, наш класс будет поддерживать только
интерфейс Serializable.
7.3.	Добавь в Entry следующие поля: Long key, String value, Entry next, int hash. Как
видишь, наша реализация будет поддерживать только тип Long для ключа и только
String для значения. Область видимости полей оставь по умолчанию.
7.4.	Добавь и реализуй конструктор Entry(int hash, Long key, String value, Entry next).
7.5.	Добавь и реализуй методы: Long getKey(), String getValue(), int hashCode() и String
toString(). Реализовывать остальные методы оригинального Entry не нужно, мы
пишем упрощенную версию.
 */