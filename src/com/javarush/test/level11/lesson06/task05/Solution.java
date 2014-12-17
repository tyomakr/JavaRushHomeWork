package com.javarush.test.level11.lesson06.task05;

/* ИТ-компания
Написать девять классов: Worker(сотрудник), Clerk (клерк), IT (ИТ-специалист), Programmer(программист),
ProjectManager(менеджер проекта), CTO(технический директор), HR(рекрутер),
OfficeManager(офис-менеджер), Cleaner (уборщик).

Унаследовать программиста, менеджера проекта и технического директора от ИТ-специалиста.
Унаследовать рекрутера, уборщика и офис-менеджера от клерка.
Унаследовать клерка и ИТ-специалиста от сотрудника.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Worker
    {
        Object Human;
    }

    public class Clerk extends Worker
    {
        Object clerk;
    }

    public class IT extends Worker
    {
        Object IT;
    }

    public class Programmer extends IT
    {
        Object programmer;
    }

    public class ProjectManager extends IT
    {
        Object pm;
    }

    public class CTO extends IT
    {
        Object cto;
    }

    public class OfficeManager extends Clerk
    {
        Object om;
    }

    public class HR extends Clerk
    {
        Object hr;
    }

    public class Cleaner extends Clerk
    {
        Object cleaner;
    }
}
