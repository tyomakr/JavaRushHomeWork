package com.javarush.test.level33.lesson15.big01.strategies;

public interface StorageStrategy {

    //должен вернуть true, если хранилище содержит переданный ключ
    boolean containsKey(Long key);

    //должен вернуть true, если хранилище содержит переданное значение
    boolean containsValue(String value);

    //добавить в хранилище новую пару ключ –значение
    void put(Long key, String value);

    //вернуть ключ для переданного значения
    Long getKey(String value);

    //вернуть значение для переданного ключа
    String getValue(Long key);
}
