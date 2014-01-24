package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("Child1", true, 8);
        Human child2 = new Human("Child2", false, 5);
        Human child3 = new Human("Child3", true, 3);
        ArrayList<Human> childs = new ArrayList<Human>();
        childs.add(child1);
        childs.add(child2);
        childs.add(child3);

        Human father = new Human("Father", true, 28, childs);
        Human mother = new Human("Mother", false, 25, childs);
        ArrayList<Human> parents1 = new ArrayList<Human>();
        ArrayList<Human> parents2 = new ArrayList<Human>();
        parents1.add(father);
        parents2.add(mother);

        Human gFather1 = new Human("GrandFather1", true, 60, parents1);
        Human gMother1 = new Human("GrandMother1", false, 55, parents1);

        Human gFather2 = new Human("GrandFather2", true, 59, parents2);
        Human gMother2 = new Human("GrandFather2", false, 56, parents2);

        System.out.println(gFather1.toString());
        System.out.println(gMother1.toString());
        System.out.println(gFather2.toString());
        System.out.println(gMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    public static class Human
    {

        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
