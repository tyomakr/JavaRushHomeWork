package com.javarush.test.level11.lesson06.task04;

/* Все мы работники
Написать четыре класса: Worker(сотрудник), Manager(управляющий), Chief(директор) и  Secretary(секретарь).
Унаследовать управляющего, директора и секретаря от сотрудника.
*/

public class Solution
{
    public class Manager extends Worker
    {
        Object manager;
    }

    public class Chief extends Worker
    {
        Object chief;
    }

    public class Worker
    {
        Object human;
    }

    public class Secretary extends Worker
    {
        Object Secretary;
    }
}
