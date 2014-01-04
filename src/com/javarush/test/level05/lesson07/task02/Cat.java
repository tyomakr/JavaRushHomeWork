package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{

    private String catName = null;
    private int catAge = 0;
    private int catWeight = 0;
    private String catColor = null;
    private String catAdress = null;

    public void initialize (String name) {
        this.catName = name;
    }

    public void initialize (String name, int weight, int age) {
        this.catName = name;
        this.catWeight = weight;
        this.catAge = age;
    }

    public void initialize (String name, int age) {
        this.catName = name;
        this.catWeight = 4;
        this.catAge = age;
    }

    public void initialize (String name, int age, String adress) {
        this.catName = name;
        catWeight = 4;
        catColor = "black";
        this.catAge = age;
        this.catAdress = adress;
    }

    public void initialize (int weight, String color, String adress) {
        this.catWeight = weight;
        this.catColor = color;
        this.catAdress = adress;

    }





}
