package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = new String();
        Integer integer = (Integer) obj;
    }

    public void methodThrowsNullPointerException() {
        Object unknownObject = null;

        if (unknownObject.equals("known")) {
            System.out.println("OK");
        }
    }
}
