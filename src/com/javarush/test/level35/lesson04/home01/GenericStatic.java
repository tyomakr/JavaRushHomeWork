package com.javarush.test.level35.lesson04.home01;

public class GenericStatic<T extends Number> {
    public static Object someStaticMethod(Object genericObject) {
        System.out.println(genericObject);
        return genericObject;
    }
}
