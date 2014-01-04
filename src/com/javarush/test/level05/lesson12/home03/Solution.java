package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
// Mouse jerryMouse = new Mouse(“Jerry”, 12 высота, см , 5 длина хвоста, см )
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Cat thomasCat = new Cat("Tom", 50, 20);
        Dog spikeDog = new Dog ("Spike", 120, 10);

    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }

    }

    public static class Cat {

        String name;
        int height;
        int moustanche;

        public Cat(String name, int height, int moustanche) {

            this.name = name;
            this.height = height;
            this.moustanche = moustanche;
        }
    }

    public static class Dog {

        String name;
        int height;
        int tooth;

        public Dog(String name, int height, int tooth) {

            this.name = name;
            this.height = height;
            this.tooth = tooth;
        }
    }


}
