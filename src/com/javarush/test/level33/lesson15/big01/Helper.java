package com.javarush.test.level33.lesson15.big01;


import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {

    //генерировать случайную строку
    public static String generateRandomString() {

        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(100, secureRandom).toString(32);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
